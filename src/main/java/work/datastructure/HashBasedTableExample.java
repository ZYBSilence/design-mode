package work.datastructure;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class HashBasedTableExample {
    public static void main(String[] args) {
        // 创建一个以String为行键，String为列键，Integer为值的HashBasedTable
        Table<String, String, Integer> hashBasedTable = HashBasedTable.create();

        // 将值放入表中
        hashBasedTable.put("行1", "列1", 1);
        hashBasedTable.put("行1", "列2", 2);
        hashBasedTable.put("行2", "列1", 3);
        hashBasedTable.put("行2", "列2", 4);

        // 从表中获取值
        System.out.println("行1，列1的值：" + hashBasedTable.get("行1", "列1"));
        System.out.println("行2，列2的值：" + hashBasedTable.get("行2", "列2"));

        // 遍历表中的条目
        for (Table.Cell<String, String, Integer> cell : hashBasedTable.cellSet()) {
            System.out.println("行：" + cell.getRowKey() + "，列：" + cell.getColumnKey() + "，值：" + cell.getValue());
        }
    }
}

