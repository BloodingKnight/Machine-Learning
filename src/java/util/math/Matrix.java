package util.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unlimited on 2014/5/14.
 */
public class Matrix {

    public static List<Double> add(List<Double> A, List<Double> B) {
        ArrayList<Double> list = new ArrayList<Double>();
        for (int i = 0; i < A.size(); i++) {
            list.add(A.get(i) + B.get(i));
        }

        return list;
    }

    public static List<Double> minus(List<Double> A, List<Double> B) {
        ArrayList<Double> list = new ArrayList<Double>();
        for (int i = 0; i < A.size(); i++) {
            list.add(A.get(i) - B.get(i));
        }

        return list;
    }

    public static Double multiply(List<Double> A, List<Double> B) {
        Double sum = 0.0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i) * B.get(i);
        }

        return sum;
    }

    /**
     * 矩阵转置
     * @param A
     * @return
     */
    public static List<List<Double>> transposition(List<List<Double>> A) {
        List<List<Double>> T = new ArrayList<List<Double>>();

        for (int i = 0; i < A.get(0).size(); i++) {
            List<Double> temp = new ArrayList<Double>();
            for (int j = 0; j < A.size(); j++) {
                temp.add(A.get(j).get(i));
            }

            T.add(temp);
        }
        return T;
    }
}
