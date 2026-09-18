import java.util.Scanner;

public class MasterTheorem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a: ");
        int a = sc.nextInt();

        System.out.print("Enter b: ");
        int b = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        double logBA = Math.log(a) / Math.log(b);

        System.out.println("\nT(n) = " + a + "T(n/" + b + ") + n^" + k);
        System.out.printf("log_b(a) = %.2f%n", logBA);

        System.out.println("\n----- Master Theorem Result -----");

        // CASE 1
        if (k < logBA) {

            double epsilon = logBA - k;

            System.out.println("Case 1");
            System.out.printf(
                "Formal Condition: f(n) = O(n^(log_b(a) - ε)), ε = %.2f%n",
                epsilon
            );
            System.out.println("Answer: O(n^(log_b(a)))");

        }

        // CASE 2
        else if (k == logBA) {

            System.out.println("Case 2");
            System.out.println(
                "Formal Condition: f(n) = Θ(n^(log_b(a)))"
            );
            System.out.println(
                "Answer: O(n^(log_b(a) log n))"
            );

        }

        // CASE 3
        else {

            double epsilon = k - logBA;

            // c = a / b^k
            double c = a / Math.pow(b, k);

            System.out.println("Case 3");

            System.out.printf(
                "Formal Condition: f(n) = Ω(n^(log_b(a) + ε)), ε = %.2f%n",
                epsilon
            );

            System.out.printf(
                "Regularity Condition: a*f(n/b) <= c*f(n)%n"
            );

            System.out.printf(
                "c = a / b^k = %.216f%n",
                c
            );

            if (c < 1) {
                System.out.println("c < 1 : Condition satisfied");
                System.out.println("Answer: O(f(n))");
                System.out.println("Specific Answer: O(n^" + k + ")");
            } else {
                System.out.println("c >= 1 : Condition NOT satisfied");
                System.out.println("Case 3 cannot be applied.");
            }
        }

        sc.close();
    }
}