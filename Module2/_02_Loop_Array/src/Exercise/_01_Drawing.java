package Exercise;

public class _01_Drawing {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 5; j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = 0; i < 5; i++){
            for (int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5-i; j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = 0; i < 5; i++){
            for (int j = 0; j <= 5; j++){
                if (j < 5 - i)
                    System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
        /*for (int i = 0; i < 7; i++){
            for (int j = 0; j < 4; j++){
                if (7-j*2+)
                System.out.print("*");

            }

            System.out.println();
        }*/



    }
}
