package markov.hidden;

import util.io.IOUtils;
import util.math.Matrix;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by unlimited on 2014/5/14.
 *
 * 隐马尔可夫模型使用的模型
 *
 */
public class Model {

    /**
     * 混淆矩阵：包含了给定隐马尔科夫模型的某一个特殊的隐藏状态，观察到的某个观察状态的概率。
     */
    public List<String> S;

    /**
     * 观察状态：在这个过程中‘可视’的状态（例如，海藻的湿度）。
     */
    public List<String> V;

    /**
     * pi向量：包含了（隐）模型在时间t=1时一个特殊的隐藏状态的概率（初始概率）。
     */
    public List<Double> pi;

    /**
     * 状态转移矩阵：包含了一个隐藏状态到另一个隐藏状态的概率
     */
    public List<List<Double>> A;

    /**
     * 混淆矩阵：包含了给定隐马尔科夫模型的某一个特殊的隐藏状态，观察到的某个观察状态的概率。
     */
    public List<List<Double>> B;

    /**
     * 从控制台读取参数
     * @throws IOException
     */
    public void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        S = IOUtils.readSequence("请输入隐藏状态：", reader);
        V = IOUtils.readSequence("请输入观察状态：", reader);

        A = Matrix.transposition(IOUtils.readData("请输入转移矩阵（以空行结尾）：", reader));
        B = Matrix.transposition(IOUtils.readData("请输入混淆矩阵（以空行结尾）：", reader));
        pi = IOUtils.readData("请输入初始参数（以空行结尾）：", reader).get(0);

        reader.close();
    }

    /**
     * 从文件中读取参数
     * @param file
     * @throws IOException
     */
    public void read(String file) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file)));

        S = IOUtils.readSequence("读取隐藏状态：", reader);
        V = IOUtils.readSequence("读取观察状态：", reader);

        A = Matrix.transposition(IOUtils.readData("读取转移矩阵（以空行结尾）：", reader));
        B = Matrix.transposition(IOUtils.readData("读取混淆矩阵（以空行结尾）：", reader));
        pi = IOUtils.readData("读取初始参数（以空行结尾）：", reader).get(0);

        reader.close();
    }

}
