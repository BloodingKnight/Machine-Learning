package util.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by unlimited on 5/13/14.
 */
public class CollectionUtil {

    /**
     * 将给定的list转为set
     * @param list
     * @param <E>
     * @return
     */
    public static <E> Set<E> list2set(List<E> list) {
        HashSet<E> set = new HashSet<E>();
        for (E e : list) {
            set.add(e);
        }

        return set;
    }

    /**
     * 将给定的set转为list
     * @param set
     * @param <E>
     * @return
     */
    public static <E> List<E> set2list(Set<E> set) {
        ArrayList<E> list = new ArrayList<E>();
        for (E e : set) {
            list.add(e);
        }

        return list;
    }
}
