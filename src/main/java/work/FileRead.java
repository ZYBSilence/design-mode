package work;

import com.alibaba.excel.ExcelReader;
import org.springframework.util.StringUtils;
import work.entity.DataTableCEntity;
import work.entity.DataTableEntity;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
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
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));

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
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

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
//        getHandler();
        // 获取方差相关
//        getFangCha();
        // 拼接id集合
//        exportIdList();


//        List<Object> returnList = ExcelUtils.readFolder("E:\\work\\线上bug处理\\商编\\商编\\");
//        StringBuilder stringBuilder = new StringBuilder("(");
//        int size = 0;
//        for (int i = 0; i < returnList.size(); i++) {
//            List<Map<String, String>> maps = (List<Map<String, String>>) returnList.get(i);
//            for (int j = 0; j < maps.size(); j++) {
//                String s = maps.get(j).toString();
//                String replace = s.split("=")[1].replace("}", "");
//                stringBuilder.append(replace).append(",");
//                size++;
//            }
//        }
//        stringBuilder.append(")");
//        System.out.println(stringBuilder.toString());
//
//        System.out.println(size);

        // 2022-02-24处理线上订单问题
//        handlerOnlineOrder02_24();

        List<String> read = read("C:\\Users\\Silence\\Desktop\\新建 文本文档 (4).txt");
        StringBuilder stringBuilder = new StringBuilder("");


        //======================生成json数据===============================
//        for (int i = 0; i < read.size(); i++) {
//            String[] split = read.get(i).split("\t");
//            stringBuilder.append("\"").append(split[1]).append("\"").append(":").append("\"").append(split[0]).append("\"");
//            if (i != read.size() - 1) {
//                stringBuilder.append(",");
//            }
//        }
//        stringBuilder.append("}");

        //======================拼接字符串===============================
//        for (String s : read) {
//            String[] split = s.split(",");
//            for (String s1 : split) {
//                stringBuilder.append("'").append(s1).append("'").append(",");
//            }
//        }

        for (String s : read) {
            stringBuilder.append(s).append(",");
        }

        //======================拼接sql===============================
//        for (String s : read) {
//            String[] split = s.split("\t");
//            String sss = String.format("INSERT INTO `basic_company`( `name`, `short_name`, `code`, `parent_id`, `status`, `creator`, `modifier`) VALUES ( '%s', '%s', '%s', -1, 0, 'admin', 'admin');",
//                    split[1], split[2], split[0]);
//            System.out.println(sss);
//        }

        System.out.println(stringBuilder.toString());

    }

    /**
     *
     */
    private static void handlerOnlineOrder02_24() {
        List<Object> returnList = ExcelUtils.readFolder("E:\\work\\线上bug处理\\商编\\商编\\");
        List<String> yibaoOrderIds = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < returnList.size(); i++) {
            List<Map<String, String>> maps = (List<Map<String, String>>) returnList.get(i);
            for (int j = 0; j < maps.size(); j++) {
                String s = maps.get(j).toString();
                String replace = s.split("=")[1].replace("}", "");
                yibaoOrderIds.add(replace);
                size++;
            }
        }
        System.out.println(size);

        // 线上已存在订单id
        List<String> read = FileRead.read("E:\\work\\线上bug处理\\商编\\订单号.txt");
        List<String> inOrderIds = new ArrayList<>(read);

        // 保留超好播未成功生成的订单id
        System.out.println(yibaoOrderIds.removeAll(inOrderIds));

        // 其中统一支付的订单id
        List<String> read2 = FileRead.read("E:\\work\\线上bug处理\\商编\\统一支付订单号.txt");
        List<String> tongyiOrderIds = new ArrayList<>(read2);

        // 保留超好播未成功生成的订单id（去除统一支付）
        System.out.println(yibaoOrderIds.removeAll(tongyiOrderIds));
        System.out.println(yibaoOrderIds);
        System.out.println(yibaoOrderIds.size());

        System.out.println("====================");

        StringBuilder stringBuilder2 = new StringBuilder("(");
        for (String yibaoOrderId : yibaoOrderIds) {
            System.out.println(yibaoOrderId);
            stringBuilder2.append(yibaoOrderId).append(",");
        }
        stringBuilder2.append(")");
        System.out.println(stringBuilder2.toString());

        // 已重新生成的订单id
        List<String> read3 = FileRead.read("E:\\work\\线上bug处理\\商编\\重新生成的订单id.txt");
        List<String> huifuOrderIds = new ArrayList<>(read3);

        System.out.println("------------------------------");
        // 未重新生成的订单id
        yibaoOrderIds.removeAll(huifuOrderIds);
        System.out.println(yibaoOrderIds);

        for (String yibaoOrderId : yibaoOrderIds) {
            System.out.println(yibaoOrderId);
        }

        // 红包订单id
        List<String> read4 = FileRead.read("E:\\work\\线上bug处理\\商编\\红包订单id.txt");
        List<String> hongbaoOrderIds = new ArrayList<>(read4);
        yibaoOrderIds.removeAll(hongbaoOrderIds);

        System.out.println("================");
        for (String yibaoOrderId : yibaoOrderIds) {
            System.out.println(yibaoOrderId);
        }
    }

    private static void getHandler() {
        File file = new File("E:\\download\\cao\\12data\\12data\\Batangas\\");
        File[] files = file.listFiles();
        int i = 1;
        for (File file1 : files) {
            List<String> list = FileRead.read(file1);
            int j = 1, k = 0;
            List<DataTableCEntity> entities = new ArrayList<>();
            for (String s : list) {
                String[] split = s.split(",");
                DataTableCEntity entity = null;
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

                if (j == 1) {
//                    entity = new DataTableCEntity(split[0],
//                            split[3], split[4], split[5], split[6], split[7],
//                            split[24], split[25], split[26], split[27], split[28],
//                            split[31], split[32], split[34], split[35], split[38],
//                            split[39], split[42], split[43], split[44], split[45]
//                    );
//                    entities.add(entity);
                    j++;
//                } else if (Double.valueOf(split[3]) > 0){
                } else {
                    entity = new DataTableCEntity(split[0],
                            split[3], split[4], split[5], split[6], split[7],
                            split[24], split[25], split[26], split[27], split[28],
                            split[31], split[32], split[34], split[35], split[38],
                            split[39], split[42], split[43], split[44], split[45]
                    );
                    entities.add(entity);
                }

            }
            ExportExcelUtils.easyWrite(null, entities, "E:\\download\\cao\\12data\\12data\\down\\Batangas\\" + file1.getName());
            System.out.println(i);
            i++;
        }
    }

    private static void getFangCha() {
        File file = new File("E:\\download\\cao\\12data\\12data\\Batangas\\");
        File[] files = file.listFiles();
        int i = 1;
        for (File file1 : files) {
            List<String> list = FileRead.read(file1);
            List<DataTableEntity> entities = new ArrayList<>();
            int x = 1, y = 1;
            for (String s : list) {
                String[] split = s.split(",");
                if (x == 1) {
                    x++;
                    continue;
                }

                DataTableEntity entity = new DataTableEntity(Integer.valueOf(split[0]),
                        getDouble(split[1]), getDouble(split[2]), getDouble(split[3]), getDouble(split[4]),
                        getDouble(split[5]), getDouble(split[6]), getDouble(split[7]), getDouble(split[8])
                );


                Double j = (getDouble(split[4]) - 10) * (getDouble(split[4]) - 10);
                Double k = (getDouble(split[4]) - 13) * (getDouble(split[4]) - 13);
                Double l = (getDouble(split[4]) - 16) * (getDouble(split[4]) - 16);
                Double m = (-1 * 0.00002 * getDouble(split[6])) + (0.0082 * getDouble(split[6])) + (0.1456 * getDouble(split[6])) - 0.1599;
                entity.setJ(Math.sqrt(j));
                entity.setK(Math.sqrt(k));
                entity.setL(Math.sqrt(l));
                entity.setM(m);
                entities.add(entity);
                y++;
            }
            ExportExcelUtils.easyWrite(entities, null, "E:\\download\\cao\\12data\\12data\\down\\Batangas\\" + file1.getName());
            System.out.println(i);
            i++;
        }
    }

    static void exportIdList() {
        List<String> read = FileRead.read("E:\\download\\新建文本文档 (2).txt");
        StringBuilder builder = new StringBuilder("(");

        for (int i = 0; i < read.size(); i++) {
            //            System.out.println("`" + s);
//            String s = read.get(i).trim();

//            String s = read.get(i).split("/M")[1];
//            builder.append("'").append("M");
//            if (i == read.size() - 1) {
//                builder.append(s);
//            } else {
//                builder.append(s).append("'").append(",");
//            }

            builder.append(read.get(i)).append(",");
        }
        builder.append(")");
        System.out.println(builder.toString());
    }

    static Double getDouble(String s) {
        return StringUtils.isEmpty(s) ? Double.valueOf(0) : Double.valueOf(s);
    }
}
