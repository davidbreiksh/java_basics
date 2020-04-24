import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Hospital {
    public static void main(String[] args) {
        double [] patients = new double[30];
        double averageTemperature = 0;
        int recoveredPatients = 0;

        for (int temperature = 0 ; temperature <= patients.length -1 ; temperature ++){
            patients[temperature] = 32 + (8 * Math.random());
            if ( patients[temperature] > 36.2 && patients[temperature] < 36.9){
                recoveredPatients ++;
            }
            averageTemperature += patients[temperature] / 30;
           System.out.println(patients[temperature]);
        }
        System.out.println("");
        System.out.println("Total patients : " + patients.length);
        System.out.println("");
        System.out.println("Average Temperature : " + averageTemperature);
        System.out.println("");
        System.out.println("Recovered Patients : " + recoveredPatients);
    }
}