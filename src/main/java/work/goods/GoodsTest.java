package work.goods;

import work.FileRead;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 商品分类表初始化
 * @author: zyb
 * @date: 2020/9/18 12:00
 */
public class GoodsTest {

    public static void main(String[] args) {
        List<String> stringList = FileRead.read("E:\\数据导出相关\\线上数据相关\\测试更新商品分类表\\新建文本文档 (3).txt");
        List<GoodsCategoryEntity> allList = new ArrayList<>();
        List<GoodsCategoryEntity> firstList = new ArrayList<>();
        List<GoodsCategoryEntity> secondList = new ArrayList<>();
        List<GoodsCategoryEntity> thirdList = new ArrayList<>();
        //id - 模拟数据库中主键
        int id = 0;
        //一级分类标记
        String firstFlag = null;
        int firstId = 0;
        //二级分类标记
        String secondFlag = null;
        int secondId = 0;
        for (String s : stringList) {
            String[] split = s.split("\\s+");
            List<String> list = Arrays.asList(split);
            GoodsCategoryEntity firstCategory = new GoodsCategoryEntity();

            if (firstFlag == null || "".equals(firstFlag.trim()) || !firstFlag.equals(list.get(0))){
                //当进入下一个新的一级分类时，插入一级分类
                id++;
                firstCategory.setId(id);
                firstCategory.setParentId(0);
                firstCategory.setCategoryName(list.get(0));
                firstCategory.setCategoryPic(list.get(1));
                //firstId = dao.insert();
                firstId = id;
                firstFlag = list.get(0);
                allList.add(firstCategory);
                firstList.add(firstCategory);
            }

            GoodsCategoryEntity secondCategory = new GoodsCategoryEntity();
            if (secondFlag == null || "".equals(secondFlag.trim()) || !secondFlag.equals(list.get(2))){
                id++;
                secondCategory.setId(id);
                secondCategory.setParentId(firstId);
                secondCategory.setCategoryName(list.get(2));
                secondCategory.setCategoryPic(list.get(3));
                //secondId = dao.insert();
                secondId = id;
                secondFlag = list.get(2);
                allList.add(secondCategory);
                secondList.add(secondCategory);
            }
            id++;
            GoodsCategoryEntity thirdCategory = new GoodsCategoryEntity();
            thirdCategory.setId(id);
            thirdCategory.setParentId(secondId);
            thirdCategory.setCategoryName(list.get(4));
            thirdCategory.setCategoryPic(list.get(5));
            allList.add(thirdCategory);
            thirdList.add(thirdCategory);


        }
        System.out.println("集合大小" + allList.size());
        System.out.println("总分类列表为：");
        for (GoodsCategoryEntity categoryEntity : allList) {
            System.out.println(categoryEntity);
        }
        System.out.println("一级分类列表为：");
        for (GoodsCategoryEntity firstCategory : firstList) {
            System.out.println(firstCategory);
        }
        System.out.println("二级分类列表为：");
        for (GoodsCategoryEntity secondCategory : secondList) {
            System.out.println(secondCategory);
        }
        System.out.println("三级分类列表为：");
        for (GoodsCategoryEntity thirdCategory : thirdList) {
            System.out.println(thirdCategory);
        }
    }
}
