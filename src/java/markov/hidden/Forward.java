package markov.hidden;

import util.math.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unlimited on 2014/5/14.
 *
 * 前向算法
 *
 */
public class Forward {

    public static Double caculate(Model m, List<String> observe) {
        List<Double> initial = m.pi;
        List<Double> temp = new ArrayList<Double>();
        Double result = 1d;
        for (String s : observe) {
            int index = m.V.indexOf(s);

            result *= Matrix.multiply(initial, m.B.get(index));
            temp.clear();
            for (int i = 0; i < m.S.size(); i++) {
                temp.add(Matrix.multiply(initial, m.A.get(i)));
            }
        }

        return result;
    }
}
