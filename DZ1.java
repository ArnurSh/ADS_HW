import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    //#1
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    //#2
    public static double findAverage(int[] arr) {
        double aver = 0;
        for (int i = 0; i < arr.length; i++) {
            aver+=arr[i];
        }
        return aver / arr.length;
    }

    //#3
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //#4
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    //#5
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;  // F0 = 0
        } else if (n == 1) {
            return 1;  // F1 = 1
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    //#6
    public static double power(double a, int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return a * power(a, n - 1);
        } else {
            return 1 / power(a, -n);
        }
    }

    //#7
    public static void generatePermutations(String str) {
        ArrayList<String> permutations = new ArrayList<>();
        permute("", str, permutations);

        System.out.println("All permutations:");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    private static void permute(String prefix, String suffix, ArrayList<String> permutations) {
        int n = suffix.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, n), permutations);
            }
        }
    }
    //#8
    public static boolean isAllDigits(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    //#9
    public static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
        }
    }

    //#10
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //#1-2
        /*
        System.out.print("Enter length: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter numbers: " + n);
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
         */

        //#1
        /*
        int min = findMin(arr);
        System.out.println("Min: " + min);
         */

        //#2
        /*
        double aver = findAverage(arr);
        System.out.println("Average: " + aver);
         */

        //#3
        /*
        System.out.print("Enter number: ");
        int numb = scanner.nextInt();
        if(isPrime(numb))
            System.out.println("Prime");
        else
            System.out.println("Composite");
         */

        //#4
        /*
        System.out.print("Enter number: ");
        int numb = scanner.nextInt();
        long result = factorial(numb);
        System.out.println("Factorial: " + result);
         */

        //#5
        /*
        System.out.print("Enter number: ");
        int numb = scanner.nextInt();
        int result = fibonacci(numb);
        System.out.println("Fibonachi: " + result);
        */

        //#6
        /*
        System.out.print("Enter powering number: ");
        double base = scanner.nextDouble();
        System.out.print("Enter number: ");
        int exponent = scanner.nextInt();
        double result = power(base, exponent);
        System.out.println(result);
        */

        //#7
        /*
        System.out.print("Enter line: ");
        String inputString = scanner.nextLine();
        generatePermutations(inputString);
         */

        //#8
        /*
        String inputString = scanner.nextLine();
        if (isAllDigits(inputString)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
         */

        //#9
        /*
        System.out.println("N: ");
        int n = scanner.nextInt();
        System.out.println("K: ");
        int k = scanner.nextInt();
        int result = binomialCoefficient(n, k);
        System.out.println("C(" + n + ", " + k + ") = " + result);
        */

        //#10
        /*
        System.out.println("A: ");
        int numb1 = scanner.nextInt();
        System.out.println("B: ");
        int numb2 = scanner.nextInt();
        int result = gcd(numb1, numb2);
        System.out.println("GCD(" + numb1 + ", " + numb2 + ") = " + result);
        */

        scanner.close();
    }
}