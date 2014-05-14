package util.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by unlimited on 2014/5/14.
 */
public class IOUtils {


    public static List<String> readSequence(String option,  BufferedReader reader) throws IOException {
        List<String> list = new ArrayList<String>();

        System.out.println(option);
        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }

        return list;
    }

    /**
     * 读取训练元组
     * @return 训练元组集合
     * @throws IOException
     */
    public static List<List<Double>> readData(String option,  BufferedReader reader) throws IOException {
        List<List<Double>> datas = new ArrayList<List<Double>>();


        System.out.println(option);
        String str = "";
        while (!(str = reader.readLine()).equals("")) {
            StringTokenizer tokenizer = new StringTokenizer(str);
            ArrayList<Double> s = new ArrayList<Double>();
            while (tokenizer.hasMoreTokens()) {
                s.add(Double.valueOf(tokenizer.nextToken()));
            }
            datas.add(s);
        }
        return datas;
    }
}
