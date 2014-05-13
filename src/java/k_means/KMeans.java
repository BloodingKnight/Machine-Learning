package k_means;

import util.math.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by unlimited on 5/2/14.
 *
 * K-means 算法
 */
public class KMeans {

    private List<Point> points;
    private int k;
    private List<Point> keys;
    private Map<Point, List<Point>> clusters;

    public KMeans(List<Point> points, int k) {
        this.points = points;
        this.k = k;
    }

    /**
     * 聚类主方法
     * @return
     */
    public Map<Point, List<Point>> cluster() {
        // 随即选取k个点作为中心点
        List<Point> keys = Random.choice(points, k);
        while (true) {
            // 根据中心点对属性点聚类
            clusters = clusterPoints(keys);

            // 根据聚类结果计算中心点
            ArrayList<Point> tmpKeys = new ArrayList<Point>();
            for (List<Point> pointList : clusters.values()) {
                tmpKeys.add(getKey(pointList));
            }


            // 如果重新计算的中心点没有变化，则迭代结束
            if (keys.containsAll(tmpKeys)) {
                break;
            }

            // 如果中心点变化了，则更新中心点
            keys = tmpKeys;
        }
        return clusters;
    }

    /** 给定一组记录点，求记录点的中心
     *
     * @param cluster 记录点
     * @return 该组记录点的中心点
     */
    private Point getKey(List<Point> cluster) {
        Point p = cluster.get(0).clone();
        for (Point point : cluster) {
            p.add(point);
        }
        return p.minus(cluster.get(0));
    }

    /** 根据中心点对记录点进行聚类
     *
     * @return
     */
    private Map<Point, List<Point>> clusterPoints(List<Point> keys) {
        Map<Point, List<Point>> map = new TreeMap<Point, List<Point>>();

        for (Point point : points) {
            double min = Double.MAX_VALUE;
            Point k = null;
            for (Point key : keys) {
                double distance = getDistance(point, key);
                min = min < distance ? min : distance;
                k = key;
            }

//            List<Point> ps = map.get(k) == null ? new ArrayList<Point>() : map.get(k);
            List<Point> ps = map.get(k);
            if (ps == null) {
                ps = new ArrayList<Point>();
            }
            ps.add(point);
            map.put(k, ps);
        }

        return map;
    }

    /**
     * 计算两个点距离（欧式距离）
     * @param point
     * @param key
     * @return
     */
    private double getDistance(Point point, Point key) {
        double sum = 0;
        for (int i = 0; i < point.size(); i++) {
            sum += point.get(i) * point.get(i) + key.get(i) * key.get(i);
        }
        return Math.sqrt(sum);
    }
}

class Point {
    public List<Double> properties;
    public String name;

    public Point() {
        this.properties = new ArrayList<Double>();
        this.name = "";
    }

    public Point(List<Double> properties, String name) {
        this.properties = properties;
        this.name = name;
    }

    public double get(int index) {
        return properties.get(index);
    }

    public Double set(int index, double v) {
        return properties.set(index, v);
    }

    public int size() {
        return properties.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        Point p = (Point) obj;
        return properties == null ? p.properties == null : properties.equals(p.properties);
    }

    /**
     * 两个点相加
     * @param p
     * @return
     */
    public Point add(Point p) {
        if (!(p == null || p.properties == null || properties == null)) {
            for (int i = 0; i < properties.size(); i++) {
                set(i, p.get(i) + get(i));
            }
        }

        return this;
    }

    /**
     * 两个点相减
     * @param p
     * @return
     */
    public Point minus(Point p) {
        if (!(p == null || p.properties == null || properties == null)) {
            for (int i = 0; i < properties.size(); i++) {
                set(i, get(i) - p.get(i));
            }
        }

        return this;
    }

    /**
     * 一个点除以一个数
     * @param d
     * @return
     */
    public Point devide(double d) {
        if (properties != null) {
            for (int i = 0; i < properties.size(); i++) {
                set(i, get(i) / d);
            }
        }

        return this;
    }

    @Override
    public Point clone() {
        return new Point(properties, "");
    }
}
