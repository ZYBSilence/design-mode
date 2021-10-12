package work;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import work.entity.TestEntity;
import work.goods.importGoods.A;
import work.thread.ThreadTest;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zyb
 * @date: 2020/10/16 14:48
 */
public class Test {
    public static void main(String[] args) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar c = Calendar.getInstance();
//        Date startDate = null;
//        Date endDate = null;
//
//        try {
//            startDate = format.parse("2020-10-01");
//            endDate = format.parse("2020-12-12");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        if (startDate != null && endDate != null){
//            Date startDateFlag = startDate;
//            while (startDateFlag.compareTo(endDate) <= 0){
//                String startDateString = format.format(startDateFlag);
//                System.out.println(startDateString);
//                c.setTime(startDateFlag);
//                // 当前日期加一天
//                c.add(Calendar.DATE, 1);
//                startDateFlag = c.getTime();
//                System.out.println(startDateFlag);
//            }
//        }
//
//        TestEntity entity1 = new TestEntity(1, 1, 1, 1);
//        TestEntity entity2 = new TestEntity(1, 1, 2, 2);
//        TestEntity entity3 = new TestEntity(2, 1, 1, 3);
//        TestEntity entity4 = new TestEntity(2, 2, 2, 4);
//        List<TestEntity> list = new ArrayList<>();
//        list.add(entity1);
//        list.add(entity2);
//        list.add(entity3);
//        list.add(entity4);
//        Map<Integer, Map<Integer, Integer>> mapMap = list.stream().collect(Collectors.groupingBy(TestEntity::getGroupId,
//                Collectors.toMap(TestEntity::getUserId, TestEntity::getNum,
//                        (k1, k2) -> k1 + k2)));
//        Map<Integer, Integer> aMap = mapMap.get(1);
//        System.out.println(aMap.get(1));
//        ArrayList<A> list = new ArrayList<>();
//        A a = new A();
//        a.setA(1);
//        List<Long> collect = list.stream().map(A::getB).collect(Collectors.toList());
//        long sum = list.stream().mapToLong(A::getB).sum();
//        System.out.println(collect);
//        System.out.println(sum);

//        System.out.println("set_no_speaking".toUpperCase());
//        System.out.println(String.format("%s%s?sdkappid=%s&identifier=%s&usersig=%s&random=%s&contenttype=json",
//                "http", "service", "appId", "admin", "sig", "random"));
//
//        String a = "eJwtzM8LgjAcBfD-ZeeQ-WjmhA5eKio6pDTsNtiKb7G55hAp*t8z9fg*7-E*qDqWSWcCyhFNMFqMGbRxEW4wstIWHLQxqNiEedDqp-IeNMrJEmNOV4TxqTG9h2AG55xTjPGkEezfUkqJYBkl8wvch-*DqMvysq30xoHYOVbI7l33nRE*pPL6kM2ZnfbCvrjJ1uj7A1jvNPw_";
//        String b = "eJwtzEELgjAcBfDvsmsh22zZhG6SFSmYXeo22tQ-po25xIy*e6Ye3*893gddTqnTKoN8RB2MlmMGqWoLGYwsZAU1NNYI*zTzoJGl0Bok8skKY0Y94rKpUZ0GowZnjFGM8aQWqr*tKSXc5Xwzv0A*-C-uGdsfg9cjJ3HUBtEu5l6si6Douz5MmvRc3kQWXg-FO9mi7w9VEDU7";

//        System.out.println("TIMTextElem".toUpperCase());
//        System.out.println("TIMLocationElem".toUpperCase());
//        System.out.println("TIMFaceElem".toUpperCase());
//        System.out.println("TIMCustomElem".toUpperCase());
//        System.out.println("TIMSoundElem".toUpperCase());
//        System.out.println("TIMImageElem".toUpperCase());
//        System.out.println("TIMFileElem".toUpperCase());
//        System.out.println("TIMVideoFileElem".toUpperCase());
//        countActivityFunds();

//        List<TestEntity> list = new ArrayList<>();
//        TestEntity testEntity1 = new TestEntity();
//        TestEntity testEntity2 = new TestEntity();
//        TestEntity testEntity3 = new TestEntity();
//        testEntity1.setNum(2);
//        testEntity2.setNum(3);
//        testEntity3.setNum(1);
//        list.add(testEntity1);
//        list.add(testEntity2);
//        list.add(testEntity3);
//        List<TestEntity> collect = list.stream().sorted(Comparator.comparing(TestEntity::getNum).reversed()).collect(Collectors.toCollection(LinkedList::new));
////        Set<TestEntity> collect = list.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(TestEntity::getNum))));
//        System.out.println(collect);
//        try {
//            sengWeChatMsg();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }

//        TestEntity aaa = new TestEntity(1, 1, 1, 1, "aaa");
//        TestEntity bbb = new TestEntity(1, 2, 1, 1, "bbb");
//        TestEntity ccc = new TestEntity(2, null, 1, 1, "ccc");
//        TestEntity ddd = new TestEntity(3, null, 1, 1, "ddd");
//        List<TestEntity> testEntities = new ArrayList<>();
//        testEntities.add(aaa);
//        testEntities.add(bbb);
//        testEntities.add(ccc);
//        testEntities.add(ddd);
//        Map<Integer, Map<Integer, String>> collect = testEntities.stream().collect(Collectors.groupingBy(TestEntity::getGroupId, Collectors.toMap(TestEntity::getUserId, TestEntity::getName)));
//        System.out.println(collect.get(2).get(null));
//
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put(null, null);
//        System.out.println(map.containsKey(null));
//        System.out.println(map.get(null));

//        List<TestEntity> list = new ArrayList<>();
//        Set<Integer> collect = list.stream().map(TestEntity::getUserId).collect(Collectors.toSet());
//        System.out.println(collect);
//        HashSet<Integer> set1 = new HashSet<>();
//        set1.add(1);
//        HashSet<Integer> set2 = new HashSet<>();
//        System.out.println(set1);
//        System.out.println(set1.retainAll(set2));
//        System.out.println(set1);
//        System.out.println(set2);

//        ArrayList<TestEntity> list = new ArrayList<>();
//        list.add(new TestEntity(1, 1, "a"));
//        list.add(new TestEntity(1, 2, "a"));
//        list.add(new TestEntity(2, 2, "b"));
//        list.add(new TestEntity(3, 3, "c"));
//        ArrayList<TestEntity> result = new ArrayList<>();
//        list.parallelStream().collect(Collectors.groupingBy(v -> String.format("%s%s", v.getUserId(), v.getName()))).forEach((id, entityList) -> {
//            entityList.stream().reduce((a, b) -> new TestEntity(a.getUserId(), a.getNum() + b.getNum(), a.getName())).ifPresent(result::add);
//        });
//
//        System.out.println(result);


        // 抽奖算法
//        Random random = new Random();
//        for (int i = 0; i <= 100; i++){
//            double a = random.nextDouble()*100;
//            if (a<0.01){
//                System.out.println("中奖");
//            }
//        }

//        String s = "叶不断\t2\t213666\t20\n" +
//                "好好师长教师゛\t2\t213667\t20\n" +
//                "设身处地\t2\t213668\t20\n" +
//                "染爱欲\t2\t213761\t20\n" +
//                "荒凉i\t2\t213762\t20\n" +
//                "海绵宝宝的派大星\t2\t213763\t20\n" +
//                "命你！\t2\t213764\t20\n" +
//                "誓词很饱满，豪情很骨感\t2\t213765\t20\n" +
//                "浊世狼烟\t2\t213766\t20\n" +
//                "濃煙白襯\t2\t213767\t20\n" +
//                "官方认证我是帅比!\t2\t213768\t20\n" +
//                "乐容不见\t2\t213769\t20\n" +
//                "野性人生\t2\t213770\t20\n" +
//                "这一刻，Love吧！\t2\t213771\t20\n" +
//                "一纸歉岁 Trace。\t2\t213772\t20\n" +
//                "时间是自称包治百病的庸医\t2\t213773\t20\n" +
//                "柳之心\t2\t213774\t20\n" +
//                "未散丶花\t2\t213775\t20\n" +
//                "灬潇尐爺ご\t2\t213776\t20\n" +
//                "乌呜坞污屋巫\t2\t213777\t20\n" +
//                "乐醒\t2\t213778\t20\n" +
//                "浅笑不克抹去内心的忐忑。\t2\t213779\t20\n" +
//                "机械猫\t2\t213780\t20\n" +
//                "雪鬓 〃\t2\t213781\t20\n" +
//                "蓝涩 。\t2\t213782\t20\n" +
//                "一路去解救地球i\t2\t213783\t20\n" +
//                "指尖怒放的繁花\t2\t213784\t20";
//        List<String> a = Arrays.asList(s.split("\n"));
//        for (String s1 : a) {
//            String[] split = s1.split("\t");
//            System.out.println("insert into live_user (account_type, user_name, live_no, tenant_id) values("+split[0] +","+ split[1]+")");
//
//        }
//        long time = new Date().getTime();
//        System.out.println(time);
//        System.out.println(System.currentTimeMillis());

//        TestEntity aa = new TestEntity(1, 1, "aa");
//        System.out.println(JSON.toJSON(aa));
//        System.out.println(JSON.toJSONString(aa));

//        Random rand = new Random();
//        int first = 0;
//        int second = 0;
//        for (int i = 0; i < 12; i++) {
//            // 获取随机数
//            int randomNum = rand.nextInt(10000);
//            if (randomNum>=0 && randomNum<5000){
//                first ++;
//            } else {
//                second ++;
//            }
//        }
//        System.out.println(first);
//        System.out.println(second);

//        List<TestEntity> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            String a = "a";
//            TestEntity testEntity = new TestEntity(i, a);
//            a += "a";
//            list.add(testEntity);
//        }

//        Map<Integer, List<TestEntity>> collect = list.stream().collect(Collectors.groupingBy(TestEntity::getUserId));
//        for (Map.Entry<Integer, List<TestEntity>> integerListEntry : collect.entrySet()) {
//            System.out.println(integerListEntry);
//        }
    }

    public static void sengWeChatMsg() throws AWTException {
        String sentence = "...";// 定义要发送的话
        Robot robot = new Robot();// 创建Robot对象（机器人）
        robot.delay(2000);// 延迟三秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        String[] authors = sentence.split("[,]");// 字符串根据,分割
        for (int j = 0; j < 100; j++) {//循环次数
            for (int i = 0; i < authors.length; i++) {
                String sentencet = authors[i];
                Transferable tText = new StringSelection(sentencet);
                clip.setContents(tText, null);
                // 按下了ctrl+v，完成粘贴功能
                robot.keyPress(KeyEvent.VK_CONTROL);// 按下Control键
                robot.keyPress(KeyEvent.VK_V);// 按下V键
                robot.keyRelease(KeyEvent.VK_CONTROL);// 释放ctrl按键
                robot.delay(300);// 延迟一秒再发送
                robot.keyPress(KeyEvent.VK_ENTER);// 回车
            }
        }
    }

    public static int duplicate(int[] numbers) {
        // write code here
        for (int i = 0; i < numbers.length; i++) {
            int y = i + 1;
            while (y < numbers.length) {
                if (numbers[i] == numbers[y]) {
                    return numbers[i];
                }
                y++;
            }
        }
        return -1;
    }

    public static String checkFileName(String filePath, String fileName) {
        if (!new File(filePath + "/" + fileName).exists()) return fileName;
        int count = 1;
        String newFileName = fileName.substring(0, fileName.lastIndexOf(".")) + "(" + count + ")" + fileName.substring(fileName.lastIndexOf(".", fileName.length() - 1));
        while (new File(filePath + "/" + newFileName).exists()) {
            newFileName = fileName.substring(0, fileName.lastIndexOf(".")) + "(" + count++ + ")" + fileName.substring(fileName.lastIndexOf(".", fileName.length() - 1));
        }
        return newFileName;
    }

    // 1.

    public static String newCheckFileName(String filePath, String fileName) {
        if (!new File(filePath + File.separator + fileName).exists()) {
            // 判断"filePath"路径下的"fileName"文件是否存在，如果不存在，则直接返回"fileName"
            // 另外文件路径拼接最好用"File.separator"，因为windows系统和linux系统之间对文件分割符的解析不一致
            return fileName;
        }
        int count = 1;
        // 重新生成新文件名；
        // 其中没必要每次都要重新获取下"."的索引，可以用个局部变量接收；
        // 另外subString()方法里重写的有传一个索引值的截取方法（传一个索引值代表截取此索引后的字符串），获取文件后缀不需要再传两个参数；
        // 文件后缀同样可以用局部变量接收；
        int subIndex = fileName.lastIndexOf(".");
        // 获取后缀
        String fileSuffix = fileName.substring(subIndex);
        String newFileName = fileName.substring(0, subIndex) + "(" + count + ")" + fileSuffix;
        while (new File(filePath + File.separator + newFileName).exists()) {
            // 判断此文件夹下是否依然存在新生成的文件名，如果存在，则重新生成；
            int newSubIndex = fileName.lastIndexOf(".");
            // 局部变量再作用域内可以自增，不需要放到拼接方法里（影响阅读）
            count++;
            newFileName = fileName.substring(0, newSubIndex) + "(" + count + ")" + fileName.substring(newSubIndex);
        }
        return newFileName;
    }

    public static void countActivityFunds() {
        // 12号
        double retailPrice01Zhang = 6 + 14.8 + 50 + 19 + 20 + 6.58 + 5;
        double retailPrice01Zhao = 360; // 支付宝已转（老赵）
        double personNum01 = 8;
        System.out.println("不算老曹，老沈和宴宾需乘2");
        BigDecimal price01 = BigDecimal.valueOf(retailPrice01Zhang)
                .add(BigDecimal.valueOf(retailPrice01Zhao))
                .divide(BigDecimal.valueOf(personNum01), BigDecimal.ROUND_DOWN);
        System.out.println("12号第一天支出，平均每人：" + price01);
        System.out.println("=============================");

        // 13号
        double retailPrice02YanLei = 55.6; // 微信已转（艳磊）
        double retailPrice02Up = 330 + 630; // 老曹船票多算10块
        double personNum02Up = 9;
        System.out.println("总共九人，老沈和宴宾需乘2");
        BigDecimal price02_1 = BigDecimal.valueOf(retailPrice02YanLei)
                .add(BigDecimal.valueOf(retailPrice02Up))
                .divide(BigDecimal.valueOf(personNum02Up), BigDecimal.ROUND_DOWN);
        System.out.println("13号上午支出，平均每人：" + price02_1);
        System.out.println("=============================");

        System.out.println("不算宴宾和他对象，老沈需乘2");
        double retailPrice02Down = 424; // 美团 318 + 支付宝 106
        double personNum02Down = 7;
        BigDecimal price02_2 = BigDecimal.valueOf(retailPrice02Down)
                .divide(BigDecimal.valueOf(personNum02Down), BigDecimal.ROUND_DOWN);
        System.out.println("13号下午支出，平均每人：" + price02_2);
        System.out.println("=============================");

        // 14号
        System.out.println("老沈需乘2");
        double retailPrice03 = 62 + 4.3 + 7.5 + 5 + 12.5 + 12.8 + 37 + 14.4;
        double personNum03 = 7;
        BigDecimal price03 = BigDecimal.valueOf(retailPrice03)
                .divide(BigDecimal.valueOf(personNum03), BigDecimal.ROUND_DOWN);
        System.out.println("14号平均每人：" + price03);

        System.out.println("==========================================================");
        System.out.println("汇总如下：");
        double priceSum = retailPrice01Zhang + retailPrice01Zhao + retailPrice02YanLei + retailPrice02Up + retailPrice02Down + retailPrice03;
        System.out.println("共消费：" + BigDecimal.valueOf(priceSum));
        System.out.println("扣除多加老曹10块后消费：" + BigDecimal.valueOf(priceSum).subtract(BigDecimal.TEN));
        BigDecimal priceAvg = price01.add(price02_1).add(price02_2).add(price03);
        System.out.println("张亚博、老赵、老艾、艳磊，每人：" + priceAvg);
        System.out.println("老曹：" + price02_1.add(price02_2).add(price03).subtract(BigDecimal.TEN));
        System.out.println("宴宾：" + price01.add(price02_1).multiply(BigDecimal.valueOf(2)));
        System.out.println("老沈：" + priceAvg.multiply(BigDecimal.valueOf(2)));
    }
}
