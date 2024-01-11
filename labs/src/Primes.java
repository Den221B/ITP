public class Primes {
    public static boolean isPrime(int n) {
        boolean isP=true;
        for (int i = 2; i<n; i++){
            if (n%i==0) {
                isP = false;
                break;
            }
        }
        return isP;
    }
    public static void main(String[] args) {
        for (int i =1; i<=100; i++){
            if (isPrime(i)){
                System.out.println(i);
            }
        }
    }

}
