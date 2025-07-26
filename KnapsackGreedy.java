import java.util.*;

public class KnapsackGreedy {
    static int n; // number of items
    static double weights[];
    static double profits[];
    static double capacity;

    public void solve() {
        double ratio[][] = new double[n][2]; // [][0]=index, [][1]=ratio
        for (int i = 0; i < n; i++) {
            ratio[i][0] = i; // item index
            ratio[i][1] = profits[i] / weights[i]; // profit/weight
        }

        // Sort by ratio descending
        Arrays.sort(ratio, (a, b) -> Double.compare(b[1], a[1]));

        double totalProfit = 0;
        double remainingCapacity = capacity;
        double fraction[] = new double[n]; // store how much fraction is taken

        for (int i = 0; i < n; i++) {
            int idx = (int) ratio[i][0];
            if (weights[idx] <= remainingCapacity) {
                // Take whole item
                fraction[idx] = 1;
                totalProfit += profits[idx];
                remainingCapacity -= weights[idx];
            } else {
                // Take fraction
                fraction[idx] = remainingCapacity / weights[idx];
                totalProfit += profits[idx] * fraction[idx];
                remainingCapacity = 0;
                break; // knapsack is full
            }
        }

        System.out.println("Maximum profit: " + totalProfit);
        System.out.print("Fractions taken for each item: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fraction[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        n = sc.nextInt();
        weights = new double[n];
        profits = new double[n];

        System.out.print("Enter knapsack capacity: ");
        capacity = sc.nextDouble();

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter weight of item %d: ", i + 1);
            weights[i] = sc.nextDouble();
            System.out.printf("Enter profit of item %d: ", i + 1);
            profits[i] = sc.nextDouble();
        }

        KnapsackGreedy kg = new KnapsackGreedy();
        kg.solve();
    }
}
