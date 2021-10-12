package work;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pengzhihao
 * @title: FileRead
 * @projectName kafka-demo
 * @description: TODO
 * @date 2020/3/2015:52
 */
public class FileRead {

    public static List<String> read(String filePath) {
        FileInputStream inputStream = null;
        BufferedReader bufferedReader = null;
        List<String> data = new ArrayList<>();

        try {
            inputStream = new FileInputStream(filePath);
            //设置inputStreamReader的构造方法并创建对象设置编码方式为gbk(编码格式可自行切换)
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "gbk"));

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                data.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }


    public static void main(String[] args) {
        String filePath = "文件所在路径/文件名";
        List<String> list = FileRead.read(filePath);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
