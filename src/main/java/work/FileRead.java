package work;

import work.entity.DataTableEntity;

import java.io.*;
import java.math.BigDecimal;
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

    public static List<String> read(File file) {
        FileInputStream inputStream = null;
        BufferedReader bufferedReader = null;
        List<String> data = new ArrayList<>();

        try {
            inputStream = new FileInputStream(file);
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
        File file = new File("E:\\download\\cao\\数据\\数据\\batangas\\");
        File[] files = file.listFiles();
        int i = 1;
        for (File file1 : files) {
            List<String> list = FileRead.read(file1);
            int j = 1, k = 0;
            List<DataTableEntity> entities = new ArrayList<>();
            for (String s : list) {
                String[] split = s.split(",");
                DataTableEntity entity = null;
//                if (i < 6) {
//                    if (j == 1) {
//                        entity = new DataTableEntity(k == 0 ? "LogIndex" : String.valueOf(k),
//                                split[0],
//                                split[1], split[2], split[3], split[4], split[5],
//                                split[6], split[7], split[8], split[9], split[10],
//                                split[11], split[12], split[13], split[14], split[15],
//                                split[16], split[17], split[18], split[19]
//                        );
//                        entities.add(entity);
//                        j++;
//                    } else if (Double.valueOf(split[3]) > 0) {
//                        entity = new DataTableEntity(k == 0 ? "LogIndex" : String.valueOf(k),
//                                split[0],
//                                split[1], split[2], split[3], split[4], split[5],
//                                split[6], split[7], split[8], split[9], split[10],
//                                split[11], split[12], split[13], split[14], split[15],
//                                split[16], split[17], split[18], split[19]
//                        );
//                        entities.add(entity);
//                    }
//                    k++;
//                } else if (i == 6) {
//                    entity = new DataTableEntity(split[0],
//                            split[1], split[2], split[3], split[4], split[5],
//                            split[6], split[7], split[8], split[9], split[10],
//                            split[11], split[12], split[13], split[14], split[15],
//                            split[16], split[17], split[18], split[19], split[20]
//                    );
//                } else {
//
//
//                }

                if (j == 1){
                    entity = new DataTableEntity(split[0],
                            split[3], split[4], split[5], split[6], split[7],
                            split[24], split[25], split[26], split[27], split[28],
                            split[31], split[32], split[34], split[35], split[38],
                            split[39], split[42], split[43], split[44], split[45]
                    );
                    entities.add(entity);
                    j++;
                } else if (Double.valueOf(split[3]) > 0){
                    entity = new DataTableEntity(split[0],
                            split[3], split[4], split[5], split[6], split[7],
                            split[24], split[25], split[26], split[27], split[28],
                            split[31], split[32], split[34], split[35], split[38],
                            split[39], split[42], split[43], split[44], split[45]
                    );
                    entities.add(entity);
                }
            }
            ExportExcelUtils.easyWrite(entities, "E:\\download\\cao\\down\\batangas\\" + file1.getName());
            System.out.println(i);
            i++;
        }
    }
}
