package work;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: aerCool
 * @description: 用户没有更新到最新版
 * @since: 2020-04-23 16：39
 * @version: v1.0.0
 */
public class UserNotUpdateNew {
    /**
     * 通过磁盘挂载自己的磁盘
     *
     * 1. 问运营要到版本号,比如 435,找到统计库的query_not_update语句调整修改
     * 2. 查找出的数据放到一个txt.比如:lt427.txt
     * 3. 执行如下的getIds(); 先注释handlerData()
     * 4. 复制导出的id. 然后到game_center库执行query_not_update.
     * 5. 拿到查询结果.然后执行下面的handlerData();
     */
    public static void main(String[] args) throws IOException {

//        getIds();

       handlerData();

    }

    private static void handlerData() throws IOException {
        //没更新的用户
        List<String> notUp = FileRead.read("E:\\数据导出相关\\notUp.txt");

        //409所有
        List<String> lt426 = FileRead.read("E:\\数据导出相关\\lt427.txt");


        Map<String, String> map = new HashMap<>(notUp.size());
        //FileWriter fw=new FileWriter(new File("C:\\Users\\86180\\Desktop\\111\\409在22号未更新到417的用户设备信息.txt"));

        //BufferedWriter bw=new BufferedWriter(fw);

        for (String u : notUp) {
            String[] split = u.split("-");

            map.put(split[0], split[1]);
        }

        for(String s : lt426) {

            String[] s1 = s.split(",");

            String id = s1[1];

            if (s1[2].length() > 16 || map.get(id) == null) {
                continue;
            }


            System.out.println(s + "," + map.get(id));
//            if (map.get(s1[1]) != null) {
//                String one = s.replace("_", ",") + "," + map.get(s1[1]);
//
//                System.out.println(one);
//            }
        }
    }

    private static void getIds() {

        List<String> user426 = FileRead.read("E:\\数据导出相关\\lt427.txt");
        System.out.println("427所有数量 ： " + user426.size());
        StringBuilder uids = new StringBuilder("(");
        int x = 0;
        for (String u : user426) {
            String[] split = u.split(",");
            if (split[2].length() > 16) {
                continue;
            }
            uids.append(",").append(split[1]);
//            uids.append(",").append(u);
        }

        System.out.println(uids.toString().replaceFirst(",", "") + ")");

    }
}
