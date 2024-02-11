import java.util.Arrays;

/**
 * @author andderV
 * @date 10.02.2024 14:21
 * PerformanceLab
 */
public class Task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        findWay(n, m);


    }

    public static void findWay(int n, int m) {

        int[] array = new int[n];
        Arrays.setAll(array, i -> ++i);

        int current = 0;
        do {
            System.out.print(array[current]);
            current = (current + m - 1) % n;
        } while (current != 0);
    }
}
