public class Cross {
    public static void main(String[] args) {
        String[][] array = {
                {"X", " ", " ", " ", " ", " ", " ","X"},
                {"  X", " "," X"},
                {" "," "," X"},
                {" "," X"," "," ","X"},
                {"X"," "," "," "," "," "," X"},
        };
        for ( int a = 0 ;a < array.length; a++ ){
            for (int b = 0 ; b < array[a].length; b ++){
                System.out.print(array[a][b]);
            }
            System.out.println();
        }
    }
}