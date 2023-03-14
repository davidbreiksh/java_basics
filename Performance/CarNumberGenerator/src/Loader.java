import java.io.FileOutputStream;

public class Loader {

    private static final int PROCESSORS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        FileOutputStream writer = new FileOutputStream("res/numbers.txt");
        FileOutputStream[] writers = new FileOutputStream[PROCESSORS];

        for (int i = 0; i < PROCESSORS; i++) {
            writers[i] = new FileOutputStream("res/numbers" + i + ".txt");
        }

        int numberPlatesPerThread = 1000 / PROCESSORS;
        Thread[] threads = new Thread[PROCESSORS];

        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

        for (int y = 0; y < PROCESSORS; y++) {
            int startNumber = y * numberPlatesPerThread + 1;
            int endNumber = startNumber + numberPlatesPerThread;
            threads[y] = new Thread(() -> {
                try {
                    for(int number = startNumber; number <= endNumber ; number++){
                        int regionCode = 199;
                        int writerIndex = number % PROCESSORS;
                        StringBuilder builder = new StringBuilder();
                        for(char firstLetter : letters){
                            for(char secondLetter : letters){
                                for(char thirdLetter : letters){
                                    builder.append(firstLetter)
                                            .append(padNumber(number, 3))
                                            .append(secondLetter)
                                            .append(thirdLetter)
                                            .append(padNumber(regionCode, 2))
                                            .append('\n');
                                }
                            }
                        }
                        writers[writerIndex].write(builder.toString().getBytes());
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
                });
            threads[y].start();
            }

//            for (int number = 1; number < 1000; number++) {
//                int regionCode = 199;
//                for (char firstLetter : letters) {
//                    for (char secondLetter : letters) {
//                        for (char thirdLetter : letters) {
//                            String carNumber = firstLetter + padNumber(number, 3) +
//                                    secondLetter + thirdLetter + padNumber(regionCode, 2);
//                            writer.write(carNumber.getBytes());
//                            writer.write('\n');
//                        }
//                    }
//                }
//            }
//
//            writer.flush();
//            writer.close();

            System.out.println((System.currentTimeMillis() - start) + " ms");
        }

        private static String padNumber ( int number, int numberLength){
            String numberStr = Integer.toString(number);
            int padSize = Math.max(0, numberLength - numberStr.length());

            StringBuilder builder = new StringBuilder(numberLength);
            builder.append("0".repeat(padSize));
            builder.append(numberStr);
            return builder.toString();
        }
    }

// first results before optimization : 16963 ms , 17003 ms , 16910 ms
// after optimization :  12 ms , 11 ms , 10 ms