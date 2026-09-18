import java.util.*;

public class JobSequencing {

    static class Job {
        String id;
        int deadline;
        int profit;

        Job(String id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        Job[] jobs = new Job[n];

        // Input job details
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Job " + (i + 1));

            System.out.print("Job ID: ");
            String id = sc.next();

            System.out.print("Deadline: ");
            int deadline = sc.nextInt();

            System.out.print("Profit: ");
            int profit = sc.nextInt();

            jobs[i] = new Job(id, deadline, profit);
        }

        // Sort jobs according to decreasing profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find maximum deadline
        int maxDeadline = 0;

        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Create time slots
        String[] schedule = new String[maxDeadline + 1];

        int totalProfit = 0;

        // Schedule jobs
        for (Job job : jobs) {

            for (int slot = job.deadline; slot >= 1; slot--) {

                if (schedule[slot] == null) {

                    schedule[slot] = job.id;
                    totalProfit += job.profit;

                    break;
                }
            }
        }

        // Display final schedule
        System.out.println("\nFinal Schedule:");

        for (int i = 1; i <= maxDeadline; i++) {

            if (schedule[i] != null) {
                System.out.println(
                    "Slot " + i + " : " + schedule[i]
                );
            } else {
                System.out.println(
                    "Slot " + i + " : Empty"
                );
            }
        }

        System.out.println("\nMaximum Profit = " + totalProfit);

        sc.close();
    }
}