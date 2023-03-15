import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Loader extends DefaultHandler {

    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    private static HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private static HashMap<Voter, Integer> voterCounts = new HashMap<>();

    private Voter currentVoter;
    private Integer currentStation;
    private Date currentTime;

    public static void main(String[] args) throws Exception {
        String fileName = "res/data-1M.xml";

        parseFile(fileName);

        //Printing results
        System.out.println("Voting station work times: ");
        for (Integer votingStation : voteStationWorkTimes.keySet()) {
            WorkTime workTime = voteStationWorkTimes.get(votingStation);
            System.out.println("\t" + votingStation + " - " + workTime);
        }

        System.out.println("Duplicated voters: ");
        for (Voter voter : voterCounts.keySet()) {
            Integer count = voterCounts.get(voter);
            if (count > 1) {
                System.out.println("\t" + voter + " - " + count);
            }
        }
    }

    private static void parseFile(String fileName) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        Loader loader = new Loader();
        parser.parse(new File(fileName), loader);
        DBConnection.executeMultipleInserts();
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document doc = db.parse(new File(fileName));

//        findEqualVoters(doc);
//        fixWorkTimes(doc);
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        if (qName.equals("voter")) {
            String name = attributes.getValue("name");
            Date birthDay = null;
            try {
                birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            currentVoter = new Voter(name, birthDay);
        } else if (qName.equals("visit")) {
            currentStation = Integer.parseInt(attributes.getValue("station"));
            try {
                currentTime = visitDateFormat.parse(attributes.getValue("time"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("voter")) {
            Integer count = voterCounts.get(currentVoter);
            voterCounts.put(currentVoter, count == null ? 1 : count + 1);
        } else if (qName.equals("visit")) {
            WorkTime workTime = voteStationWorkTimes.get(currentStation);
            if (workTime == null) {
                workTime = new WorkTime();
                voteStationWorkTimes.put(currentStation, workTime);
            }
            workTime.addVisitTime(currentTime.getTime());
        }
    }

//    private static void findEqualVoters(Document doc) throws Exception {
//        NodeList voters = doc.getElementsByTagName("voter");
//        int votersCount = voters.getLength();
//        for (int i = 0; i < votersCount; i++) {
//            Node node = voters.item(i);
//            NamedNodeMap attributes = node.getAttributes();
//
//            String name = attributes.getNamedItem("name").getNodeValue();
//            Date birthDay = birthDayFormat
//                .parse(attributes.getNamedItem("birthDay").getNodeValue());
//
//            Voter voter = new Voter(name, birthDay);
//            Integer count = voterCounts.get(voter);
//            voterCounts.put(voter, count == null ? 1 : count + 1);
//        }
//    }
//
//    private static void fixWorkTimes(Document doc) throws Exception {
//        NodeList visits = doc.getElementsByTagName("visit");
//        int visitCount = visits.getLength();
//        for (int i = 0; i < visitCount; i++) {
//            Node node = visits.item(i);
//            NamedNodeMap attributes = node.getAttributes();
//
//            Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
//            Date time = visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue());
//            WorkTime workTime = voteStationWorkTimes.get(station);
//            if (workTime == null) {
//                workTime = new WorkTime();
//                voteStationWorkTimes.put(station, workTime);
//            }
//            workTime.addVisitTime(time.getTime());
//        }
//    }
}