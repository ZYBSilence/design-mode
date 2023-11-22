package work;


import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import sun.security.rsa.RSASignature;
import work.entity.AAABBB;
import work.entity.TestEntity;
import work.entity.WithdrawOrderVO;
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
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
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
//        for (int i = 0; i < 100; i++) {
//            // 获取随机数
//            int randomNum = rand.nextInt(10000);
//            if (randomNum>=0 && randomNum<100){
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

//        List<Integer> list = new ArrayList<>();
////        list.add(1);
////        list.add(2);
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//            iterator.remove();
//        }
//        System.out.println(list);

//        int a = 10, b = 4, c= 20, d= 6;
//        System.out.println(a++*b);
//        List<Integer> list = Arrays.asList(1, 2, 3);

//        ArrayList<TestEntity> entities = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            TestEntity entity = new TestEntity(i);
//            entities.add(entity);
//        }
//        Map<Integer, TestEntity> entityMap = entities.stream().collect(Collectors.toMap(TestEntity::getUserId, v -> v));
//        long beforeTime = System.currentTimeMillis();
//        for (int i = 0; i < 100; i++) {
//            System.out.print(entityMap.get(i));
//        }
////        for (int i = 0; i < 100; i++) {
////            Integer finalI = i;
////            System.out.print( entities.stream().filter(v -> v.getUserId().equals(finalI)).findFirst().get());
////        }
//        long afterTime = System.currentTimeMillis() - beforeTime;
//        System.out.println("\n" + afterTime);

//        List<String> read = FileRead.read("E:\\download\\新建文件夹\\order.txt");
//        List<String> read = FileRead.read("E:\\download\\新建文件夹\\orderNumber.txt");
//        List<String> read = FileRead.read("E:\\download\\新建文件夹\\mainOrderNumber.txt");
//        List<String> read2 = FileRead.read("E:\\download\\新建文件夹\\mainOrderId.txt");
////        List<String> read = FileRead.read("E:\\download\\新建文件夹\\haveOrderId.txt");
//        List<String> read = FileRead.read("E:\\download\\数据导出.txt");
//        List<String> read = FileRead.read("E:\\download\\orderNumbers.txt");
//        StringBuilder str = new StringBuilder("(");
////
////        StringBuilder str1 = new StringBuilder("(");
//        for (String s : read) {
//            if (!StringUtils.isEmpty(s)){str.append("'").append(s).append("'").append(",");}
//            str.append(s.split(" ")[1]).append(",");
//            str.append("'").append(s).append("'").append(",");
//            str.append(s).append(",");
//            StringBuilder str = new StringBuilder("INSERT INTO `chaohaobo`.`market_activity_lottery_chance` ( `activity_id`, `user_id`, `order_id`, `order_number`, `gain_chance_num`, `remain_chance_num`, `validity_date` )\n" +
//                    "VALUES\n" +
//                    "\t( 26,");
//            String[] split = s.split("\t");
//            str.append(split[1]).append(",").append(split[0]).append(",").append("'").append(split[2]).append("'").append(", 1, 1, '2021-11-21 23:59:59' );");
//            System.out.println(str.toString());

//            str1.append(split[0]).append(",");
//        }
//        str1.append(")");
//        System.out.println(str1);

//        str.append(")");
//        System.out.println(str);
//        System.out.println(read.size());
//        System.out.println(read2.size());
//        System.out.println(read2.containsAll(read));
//        for (String s : read) {
//            String[] split = s.split("\t");
//            StringBuilder str = new StringBuilder("INSERT INTO `market_activity_lottery_chance` (`activity_id`, `user_id`, `order_id`, `order_number`, `gain_chance_num`, `remain_chance_num`, `validity_date`, `create_time`, `update_time` ) VALUES (26," );
//            str.append(split[1]).append(",").append(split[0]).append(",").append("'").append(split[2]).append("'").append(",").append(" 1, 1, '2021-11-19 23:59:59', now(), now());");
//            System.out.println(str.toString());
//        }
//
//        LocalDateTime now = LocalDateTime.now();
//        if (now.getYear() == 2021 && now.getMonth().equals(Month.NOVEMBER) && (now.getDayOfMonth() == 13 || now.getDayOfMonth() == 18)){
//            LocalDateTime createTime = LocalDateTime.of(2021, 11, 13, 14, 36);
//            LocalDateTime plusMinutes = createTime.plusMinutes(5);
//            if (plusMinutes.isAfter(now)){
//                System.out.println(createTime);
//                System.out.println(plusMinutes);
//            }
//        }
//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        System.out.println(i);
//        switch (i){
//            case 1:
//            case 2:
//                System.out.println(111);
//                break;
//            case 3:
//                System.out.println(333);
//                break;
//            default:
//                break;
//        }

//        BigDecimal bigDecimal = new BigDecimal(10);
//        bigDecimal = bigDecimal.add(BigDecimal.valueOf(20));
//        System.out.println(bigDecimal);

        // 算法（集合元素右移）
//        test();
        // 集合排序
//        test2();

//        List<TestEntity> list = new ArrayList<>();
//        Calendar instance = Calendar.getInstance();
//        for (int i = 0; i < 10; i++) {
//            TestEntity testEntity1 = new TestEntity();
//            testEntity1.setGroupId(1);
//            testEntity1.setDay(i);
//            testEntity1.setDatetime(instance.getTime());
//            list.add(testEntity1);
//            instance.add(Calendar.MINUTE, 30);
//        }
////        Map<Integer, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(TestEntity::getGroupId, Collectors.mapping(TestEntity::getDay, Collectors.toList())));
//        Map<String, List<TestEntity>> collect = list.stream()
//                .collect(Collectors.groupingBy(v -> TimeUtils.formatDateHour(v.getDatetime())));
//        List<Map.Entry<String, List<TestEntity>>> collect1 = collect.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
////        System.out.println(collect);
//        for (Map.Entry<String, List<TestEntity>> stringListEntry : collect.entrySet()) {
//            System.out.println(stringListEntry);
//        }
//
//        System.out.println("===========================");
//        for (Map.Entry<String, List<TestEntity>> stringListEntry : collect1) {
//            System.out.println(stringListEntry.getKey());
//            List<TestEntity> value = stringListEntry.getValue();
//            System.out.println(value);
//            for (TestEntity testEntity : value) {
//                System.out.println(testEntity);
//            }
//        }
//
//        Calendar cal = Calendar.getInstance();
//        Date time = cal.getTime();
//        System.out.println(time);
//        cal.add(Calendar.HOUR_OF_DAY, -2);
//        Date time1 = cal.getTime();
//        System.out.println(time1.getTime() - time.getTime());

//        LocalDateTime now = LocalDateTime.now();
//        for (int i = 0; i < 100; i++) {
//            System.out.println(now);
//            now = now.plusHours(1);
//        }
//        TimeUtils.
//        List<TestEntity> testEntities = list.subList(0, 2);
//        System.out.println(list.subList(0,2));


//        WithdrawOrderVO testEntity = JSON.parseObject("{\"withdrawal_id\":\"3705960408792445806\",\"business_type\":\"1\",\"balance_acct_id\":\"2005949036501861036\",\"amount\":1,\"status\":\"succeeded\",\"out_order_no\":\"a8cec8611bfe47e0aaf7aaacef5cb968\",\"created_at\":\"2022-04-18T15:30:20.49+08:00\",\"finished_at\":\"2022-04-18T15:41:00.334+08:00\",\"reason\":null,\"service_fee\":0,\"bank_memo\":null}", WithdrawOrderVO.class);
//        String s = JSON.toJSONString(testEntity);
//        System.out.println(testEntity.toString());
//        System.out.println(s);

//        AAABBB aaabbb = new AAABBB();
//        aaabbb.setAaabbb(111);
//
////        aaa.setAaa(222);
//        System.out.println(aaabbb.toString());

//        String[] strings = StringUtils.substringsBetween("aa:${a:123},bc:${b},cdd", "${", "}");
//        for (String string : strings) {
//            System.out.println(string);
//        }

//        Map<String, Object> map = new HashMap<>(2);
////        System.out.println(map.);
//        System.out.println(1 << 4);
//        System.out.println(tableSizeFor(7800));

//        System.out.println("aaa" + "\n" + "bbb");

//        AtomicInteger giftCanChooseSum = new AtomicInteger(5);
//        integerAdd(giftCanChooseSum);
//
//        System.out.println(giftCanChooseSum);
//        System.out.println(giftCanChooseSum.get());

//        calculateAmount();

//        String str = "B_SO20220701165800693070154";
//        List<String> split = StrUtil.split(str, StrUtil.C_COMMA);
//        System.out.println(split.size());
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        System.out.println(classLoader);
//        TestEntity testEntity = new TestEntity();
//        Optional.empty().ifPresent(x -> {
//            System.out.println(x);
//            System.out.println(testEntity);
//        });

//        String s = StringUtils.joinWith("#", "shopId", "brandId");
//        System.out.println(s);
//Set<Long> sets = new HashSet<>();
//        sets.add(null);
//        System.out.println(sets);
//        List<String> read = FileRead.read("C:\\Users\\Silence\\Desktop\\新建 文本文档 (9).txt");
//        for (String s : read) {
//////            String[] s1 = s.split("_");
//////            String str = "";
//////            if (s1.length > 1) {
//////                str = s1[1];
//////            } else {
//////                str = s1[0];
//////            }
//////            str = str.split("-")[0];
//////            System.out.println("'" + str.replace("B", "") + "',");
//////            String[] split = s.split("\t");
//////            System.out.println("update new_goods_sku set sku_code = '" + split[2].toUpperCase() + "' where spu_id = " + split[1] + " and id = " + split[0] + " and sku_code = '" + split[2] + "';");
//////            System.out.println("update tz_order_item set goods_code = '" + split[2].toUpperCase() + "' where prod_id = " + split[1] + " and sku_id = " + split[0] + " and goods_code = '" + split[2] + "';");
////            String[] split = s.split("\t");
//////            if (StringUtils.isNotBlank(split[0])) {
//////                System.out.println("update new_goods_sku set sku_code = '" + split[0] + "' where id = " + split[1] + ";");
//////            }
////            System.out.println("INSERT INTO `temp_mrj_department`(`department`, `user_name`, `live_num`, `sender_live_num`, `overseas_id_card`, `user_type`, `create_time`) VALUES ('" + split[0].trim() + "', '" + split[1].trim() + "', "+split[2].trim()+", "+split[3].trim()+", '', 1, now());");
//            String[] s1 = s.split(" ");
//            if (s1.length > 0) {
//                System.out.println("'" + s1[0] +"',");
//            }
//        }
////
////        System.out.println("=====================");
////        List<String> read1 = FileRead.read("C:\\Users\\Silence\\Desktop\\新建 文本文档 (4).txt");
////        for (String s : read1) {
////            String[] split = s.split("\t");
////            System.out.println("INSERT INTO `temp_mrj_department`(`department`, `user_name`, `live_num`, `sender_live_num`, `overseas_id_card`, `user_type`, `create_time`) VALUES ('" + split[0].trim() + "', '" + split[1].trim() + "', "+split[2].trim()+", "+split[2].trim()+", '"+split[3].trim()+"', 2, now());");
////        }
////
////        Random random = new Random();
////        for (int i1 = 0; i1 < 10; i1++) {
////            System.out.println(random.nextInt(0));
////        }
//
////        HashMap<BigDecimal, String> map1 = new HashMap<>();
////        map1.put(new BigDecimal("111.000"), "111");
////        System.out.println(map1.get(new BigDecimal("111")));
//        int[] aa = new int[127];
//        String str = "2341234";
//        char c = str.charAt(1);
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime of = LocalDateTime.of(2023, 4, 10, 15, 21, 22);
//        Duration between = Duration.between(of, now);
//        System.out.println(between.toDays());
//        System.out.println(between.toMinutes());

//        String s = "A116303, A135366, A144342, A151414, A171298, A17945, A181308, A207657, A211733, A219106, A220183, A225791, A226390, A24917, A252892, A264307, A275154, A280529, A285258, A303141, A31611, A327066, A327680, A33148, A331676, A33423, A36412, A372544, A38985, A415111 , A417155, A425676, A428819, A430504, A443689, A44638, A455125, A486839, A503993, A530254, A531316, A542948, A551819, A567952, A569615, A570046, A583380, A586574, A604018, A605203, A605636, A606258, A615842, A620324, A624449, A626792, A631223, A631411, A634847, A635993, A637067, A639749, A639764, A639776, A640571, A642661, A643202, A643363, A644630, A644783, A645060, A648457, A652082, A652573, A657834, A658942, A660180, A660500, A663229, A663922, A669248, A670689, A672267, A94208, A95995";
//        String[] split = s.split(",");
//        for (String s1 : split) {
//            System.out.println("INSERT INTO `mrj_shop`.`score_user`(`user_sign`, `user_name`, `channel_no`) VALUES ( 'A107631', '李丽', 1)" + s1.trim() );
//        }


//        List<String> a = Arrays.asList("A","B","C","D");
//        List<String> b = Arrays.asList("A","B");
//        List<String> c = Arrays.asList();
//        System.out.println(a.subList(a.size() - 3, a.size()));
//        System.out.println(b.subList(Math.max(b.size() - 3, 0), b.size()));
//        System.out.println(c.subList(Math.max(c.size() - 3, 0), c.size()));
//        List<String> list = new ArrayList<String>(10);
//        list.add(2, "1");
//        System.out.println(list.get(0));


//        List<TestEntity> testEntities = new ArrayList<>();
//        TestEntity testEntity = new TestEntity();
//        testEntity.setUserId(1);
//        testEntity.setName(null);
//        TestEntity testEntity1 = new TestEntity();
//        testEntity1.setUserId(2);
//        testEntity1.setName("cc");
//        testEntities.add(testEntity1);
//        Map<Integer, List<String>> collect = testEntities.stream()
//                .collect(Collectors.groupingBy(TestEntity::getUserId,
//                        Collectors.mapping(TestEntity::getName,
//                                Collectors.toList())));
//        System.out.println(JSON.toJSONString(collect));
//        System.out.println(JSON.toJSONString(testEntities));
//        List<TestEntity> collect = testEntities.stream().peek(entry -> entry.setNum(1)).collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(testEntities));
//        System.out.println(JSON.toJSONString(collect));
//
//        AtomicInteger dealNum = new AtomicInteger(0);
//        dealNum.getAndAdd(1);
//        dealNum.incrementAndGet();
//        System.out.println(dealNum.get());

//        TestEntity[] array = {new TestEntity(1),new TestEntity(2) };
//        System.out.println(array.length);
//        array[array.length - 1] = null;
//        System.out.println(array.length);

//        MD5 md5 = MD5.create();
//        String s = md5.digestHex("123456");
//        System.out.println(s);

        StringBuilder stringBuilder = new StringBuilder("admin");
        stringBuilder.append(StrUtil.COLON).append(IdUtil.simpleUUID().replaceAll(StrUtil.DASHED, StrUtil.EMPTY));
        System.out.println(stringBuilder);


        System.out.println(Base64.encode(stringBuilder.toString()));
    }

    private static void calculateAmount() {
        double pCarAmount = 9.46 + 23.45 + 112.7 + 107.6;
        double liuCarAmount = 55;
        double zCarAmount = 47.14 + 89.9 + 10.19 + 12 + 26.39 + 93.7 + (116 + 138) * 5;

        double totalAmount = pCarAmount + liuCarAmount + zCarAmount;
        double personNum = 5;

        BigDecimal price02_1 = BigDecimal.valueOf(totalAmount).divide(BigDecimal.valueOf(personNum), BigDecimal.ROUND_DOWN);
        System.out.println("彭老板打车费用：" + pCarAmount);
        System.out.println("刘总打车费用：" + liuCarAmount);
        System.out.println("张出纳：" + zCarAmount);
        System.out.println("累计：" + totalAmount);
        System.out.println("总共5人平均：" + price02_1);
    }

    static void integerAdd(AtomicInteger a) {
        a.addAndGet(1);
        System.out.println(a);
        a.getAndAdd(1);
        System.out.println(a);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 100000) ? 100000 : n + 1;
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
        BigDecimal price01 = BigDecimal.valueOf(retailPrice01Zhang).add(BigDecimal.valueOf(retailPrice01Zhao)).divide(BigDecimal.valueOf(personNum01), BigDecimal.ROUND_DOWN);
        System.out.println("12号第一天支出，平均每人：" + price01);
        System.out.println("=============================");

        // 13号
        double retailPrice02YanLei = 55.6; // 微信已转（艳磊）
        double retailPrice02Up = 330 + 630; // 老曹船票多算10块
        double personNum02Up = 9;
        System.out.println("总共九人，老沈和宴宾需乘2");
        BigDecimal price02_1 = BigDecimal.valueOf(retailPrice02YanLei).add(BigDecimal.valueOf(retailPrice02Up)).divide(BigDecimal.valueOf(personNum02Up), BigDecimal.ROUND_DOWN);
        System.out.println("13号上午支出，平均每人：" + price02_1);
        System.out.println("=============================");

        System.out.println("不算宴宾和他对象，老沈需乘2");
        double retailPrice02Down = 424; // 美团 318 + 支付宝 106
        double personNum02Down = 7;
        BigDecimal price02_2 = BigDecimal.valueOf(retailPrice02Down).divide(BigDecimal.valueOf(personNum02Down), BigDecimal.ROUND_DOWN);
        System.out.println("13号下午支出，平均每人：" + price02_2);
        System.out.println("=============================");

        // 14号
        System.out.println("老沈需乘2");
        double retailPrice03 = 62 + 4.3 + 7.5 + 5 + 12.5 + 12.8 + 37 + 14.4;
        double personNum03 = 7;
        BigDecimal price03 = BigDecimal.valueOf(retailPrice03).divide(BigDecimal.valueOf(personNum03), BigDecimal.ROUND_DOWN);
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


    public static void test() {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        System.out.println("输入集合元素");
        for (int i = 0; i < 5; i++) {
            int nextInt = scanner.nextInt();
            nums[i] = nextInt;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("右移位数");
        int k = scanner.nextInt();

        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i + k < nums.length) {
                newNums[i + k] = nums[i];
            } else {
                newNums[(i + k) % nums.length] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }

    private static void test2() {
        TestEntity testEntity1 = new TestEntity("70");
        TestEntity testEntity2 = new TestEntity("111");
        TestEntity testEntity3 = new TestEntity("10");

        List<TestEntity> list = Arrays.asList(testEntity1, testEntity2, testEntity3);
        System.out.println(list);
        /*
         * int compare(Student o1, Student o2) 返回一个基本类型的整型，
         * 返回负数表示：o1 小于o2，
         * 返回0 表示：o1和o2相等，
         * 返回正数表示：o1大于o2。
         */
        list.sort((o1, o2) -> -1 * Integer.compare(Integer.valueOf(o1.getName()), Integer.valueOf(o2.getName())));
        System.out.println(list);
    }
}
