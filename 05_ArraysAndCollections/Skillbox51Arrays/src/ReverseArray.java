public class ReverseArray {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String [] arr = text.split(",?\\s+");
        for (int a = arr.length -1 ; a >= 0 ; a--){
            System.out.println(arr[a]);
        }
    }
}