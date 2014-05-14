package markov.hidden;

import org.junit.Test;
import util.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by unlimited on 2014/5/14.
 *
 * 隐马尔可夫模型测试类
 */
public class TestHMM {

    @Test
    public void testForward() throws IOException {
        Model model = new Model();
        model.read("test/markov/hidden/model.in");
//        model.read();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("test/markov/hidden/test.in")));
        List<String> list = IOUtils.readSequence("请输入观察序列：", reader);

        System.out.println(Forward.caculate(model, list));

        reader.close();
    }
}
