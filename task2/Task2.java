import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author andderV
 * @date 11.02.2024 9:05
 * PerformanceLab
 */
public class Task2 {
    public static void main(String[] args) {
        Path circle = Paths.get(args[0]);
        Path points = Paths.get(args[1]);

        List<Float> getCircle = readFile(circle);
        float ox = getCircle.get(0);
        float oy = getCircle.get(1);
        int r = getCircle.get(2).intValue();

        List<Float> getPoints = readFile(points);
        float px, py;
        for (int i = 0; i < getPoints.size(); i+=2) {
            px = getPoints.get(i);
            py = getPoints.get(i+1);
            getPointRelativeToACircle(ox, oy, r, px, py);
        }
        ;

    }

    public static void getPointRelativeToACircle(float ox, float oy, int r, float px, float py){
        double x = Math.pow((ox - px), 2);
        double y = Math.pow((oy - py),2);
        double res = x + y;
        double rad = Math.pow(r, 2);
        if(res == rad) {
            System.out.println(0);
        } else if (res < rad) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }

    }

    public static List<Float> readFile(Path path) {
        ArrayList<Float> arr = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] str = line.trim().split(" ");
                for (String s : str) {
                    arr.add(Float.parseFloat(s));
                }
            }
        } catch (IOException ignored) {

        }
        return arr;
    }


}
