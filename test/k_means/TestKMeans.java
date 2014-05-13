package k_means;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.*;

/**
 * Created by unlimited on 5/13/14.
 */
public class TestKMeans {

    private List<Point> readData() {
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();

        List<Point> points = new ArrayList<Point>();
        int i = 0;
        while (in.hasNext() && i++ < n) {
            String name = in.next();

            List<Double> list = new ArrayList<Double>();
            for (int j = 1; j <= m; j++) {
                list.add(in.nextDouble());
            }

            points.add(new Point(list, name));
        }

        KMeans kMeans = new KMeans(points, k);

        Map<Point, List<Point>> cluster = kMeans.cluster();
        for (Point key : cluster.keySet()) {
            System.out.print("聚类1：（");
            for (Double property : key.properties) {
                System.out.print(property);
                System.out.print(", ");
            }
            System.out.println("）");

            for (Point point : cluster.get(key)) {
                System.out.print(point.name);
                System.out.print("\t");
            }

            System.out.println();

        }

    }

    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<String, String>();

        System.out.println(map.get("hello"));
    }
}
