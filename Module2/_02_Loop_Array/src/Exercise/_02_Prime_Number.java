package Exercise;

public class _02_Prime_Number {
    public static boolean prime_check(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int primeList[] = new int[20];
        int count = 0;
        int number = 2;
        while (count < 20) {
            if (prime_check(number)) {
                primeList[count] = number;
                count++;
            }
            number++;
        }
        for (int i = 0; i < primeList.length; i++) {
            System.out.print(primeList[i] + "\t");
        }
    }
}
