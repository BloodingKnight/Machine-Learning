package util.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unlimited on 5/13/14.
 */
public class Random {

    /**
     * 给定一个列表和整数n，随机从列表中取出n哥元素
     * @param list
     * @param n
     * @param <E>
     * @return
     */
    public static <E> List<E> choice(List<E> list, int n) {
        // TODO 检查n的边界
        java.util.Random random = new java.util.Random(System.currentTimeMillis());
        int size = list.size();
        ArrayList<Integer> index = new ArrayList<Integer>();
        ArrayList<E> result = new ArrayList<E>();

        for (int i = 0; i < n; i++) {
            int temp = random.nextInt(size);

            if (!index.contains(temp)) {
                index.add(temp);

                result.add(list.get(temp));

                --i;
            }
        }

        return result;
    }

    /**
     * 给定一个列表，随机从列表中取出一个元素
     * @param list
     * @param <E>
     * @return
     */
    public static <E> E choice(List<E> list) {
        java.util.Random random = new java.util.Random(System.currentTimeMillis());

        return list.get(random.nextInt(list.size()));
    }
}
