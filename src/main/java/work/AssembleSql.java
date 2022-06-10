package work;

import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @description: 拼接sql语句
 * @author: zyb
 * @date: 2020/9/8 16:33
 */
public class AssembleSql {
    public static void main(String[] args) {
//        System.out.println("==================== Mybatis3 版本提供的sql语句构造器 ====================");
//        System.out.println("========== 查询sql语句 ==========");
//        String selectSql = select("property1", "property2");
//        System.out.println(selectSql);
//        System.out.println("========== 新增sql语句 ==========");
//        String insertSql = insert("property1", "property2");
//        System.out.println(insertSql);
//        System.out.println("========== 修改sql语句 ==========");
//        String updateSql = update("property1", "property2", 1);
//        System.out.println(updateSql);
//        System.out.println("========== 删除sql语句 ==========");
//        String deleteSql = delete(1);
//        System.out.println(deleteSql);
//
//        System.out.println();
//        System.out.println("==================== Mybatis3.4.2 版本支持可变长度参数 ====================");
//        System.out.println("========== 可变长度参数拼接查询sql语句 ==========");
//        String selectVariableSql = selectVariable("property1");
//        System.out.println(selectVariableSql);
//        System.out.println("========== 可变长度参数拼接新增sql语句 ==========");
//        String insertVariableSql = insertVariable("property1", "property2");
//        System.out.println(insertVariableSql);
//        System.out.println("========== 可变长度参数拼接修改sql语句 ==========");
//        String updateVariableSql = updateVariable("property1", "property2", 1);
//        System.out.println(updateVariableSql);
//
//        System.out.println();
//        System.out.println("==================== Mybatis3.5.2 版本支持构建批量插入语句 ====================");
//        String batchInsertSql = batchInsert();
//        System.out.println(batchInsertSql);
//
//        System.out.println();
//        System.out.println("==================== Mybatis3.5.2 版本支持构建构建限制返回结果数的 SELECT 语句 ====================");
//        System.out.println("========== 限制返回结果数查询sql语句 ==========");
//        String selectWithOffsetLimitSql = selectWithOffsetLimit(100, 10);
//        System.out.println(selectWithOffsetLimitSql);
//        System.out.println("========== 限制返回结果数查询sql语句(sql server 2012 版本以上分页查询sql拼接) ==========");
//        String selectWithFetchFirstSql = selectWithFetchFirst(100, 10);
//        System.out.println(selectWithFetchFirstSql);
        List<String> read = FileRead.read("D:\\silence\\work\\对接项目\\发货订单导入\\无规格商品id.txt");
        for (String s : read) {
            System.out.println(insert(s, "0") + ";");
        }
    }

    /**
     * 拼接查询sql
     * 动态条件（注意参数需要使用 final 修饰，以便匿名内部类对它们进行访问）
     * @param property1 属性1
     * @param property2 属性2
     * @return 查询sql
     */
    public static String select(final String property1, final String property2) {
        return new SQL() {{
            SELECT("t.column_1, t.column_2");
            FROM("table t");
            if (property1 != null) {
                WHERE("t.column_1 = " + property1);
            }
            if (property2 != null) {
                WHERE("t.column_2 like " + "%" + property2 +"%");
            }
            ORDER_BY("t.id");
        }}.toString();
    }

    /**
     * 拼接新增sql
     * @param property1 属性1
     * @param property2 属性2
     * @return 新增sql
     */
    public static String insert(final String property1, final String property2) {
        return new SQL() {{
            INSERT_INTO("new_goods_sku");
            VALUES("spu_id, sell_price, business_amount", property1 + ", " +  property2+ ", " +  property2);
        }}.toString();
    }

    /**
     * 拼接修改sql
     * @param property1 属性1
     * @param property2 属性2
     * @param id 主键
     * @return 修改sql
     */
    public static String update(final String property1, final String property2, final Integer id) {
        return new SQL() {{
            UPDATE("table");
            SET("column_1 = " + property1);
            SET("column_2 = " + property2);
            WHERE("id = " + id);
        }}.toString();
    }

    /**
     * 拼接删除sql
     * @param id 主键
     * @return 删除sql
     */
    public static String delete(final Integer id) {
        return new SQL() {{
            DELETE_FROM("table");
            WHERE("id = " + id);
        }}.toString();
    }

    /**
     * Mybatis3.4.2 版本支持可变长度参数
     * 拼接查询sql
     * @param property1 属性1
     * @return 查询sql
     */
    public static String selectVariable(final String property1) {
        return new SQL()
                .SELECT("a.column_1", "a.column_2", "b.column_1", "b.column_2")
                .FROM("table_A a", "table_B b")
                .INNER_JOIN("table_C c on a.cId = c.id")
                .WHERE("a.bId = b.id", "a.column_1 like " + "%" + property1 + "%")
                .ORDER_BY("a.id", "a.column_1")
                .toString();
    }

    /**
     * Mybatis3.4.2 版本支持可变长度参数
     * 拼接新增sql
     * @param property1 属性1
     * @param property2 属性2
     * @return 新增sql
     */
    public static String insertVariable(final String property1, final String property2) {
        return new SQL()
                .INSERT_INTO("table")
                .INTO_COLUMNS("column_1", "column_2")
                .INTO_VALUES(property1, property2)
                .toString();
    }

    /**
     * Mybatis3.4.2 版本支持可变长度参数
     * 拼接修改sql
     * @param property1 属性1
     * @param property2 属性2
     * @param id 主键
     * @return 修改sql
     */
    public static String updateVariable(final String property1, final String property2, final Integer id) {
        return new SQL()
                .UPDATE("table")
                .SET("column_1 = " + property1, "column_2 = " + property2)
                .WHERE("id = " + id)
                .toString();
    }

    /**
     * Mybatis3.5.2 版本支持构建批量插入语句
     * 拼接新增sql
     * @return 新增sql
     */
    public static String batchInsert() {
        return new SQL()
                .INSERT_INTO("table")
                .INTO_COLUMNS("column_1", "column_2")
                .INTO_VALUES("#{objA.property1}", "#{objA.property2}")
                .ADD_ROW()
                .INTO_VALUES("#{objB.property1}", "#{objB.property2}")
                .toString();
    }

    /**
     * Mybatis3.5.2 版本限制返回结果数查询sql语句（分页查询）
     * 拼接查询sql
     * @param offset 偏移量（起始行）
     * @param limit 限定数（获取数量）
     * @return 查询sql
     */
    public static String selectWithOffsetLimit(Integer offset, Integer limit) {
        return new SQL()
                .SELECT("column_1", "column_2")
                .FROM("table")
                .LIMIT(limit)
                .OFFSET(offset)
                .toString();
    }

    /**
     * sql server 2012 版本以上分页查询sql拼接
     * sql 样例：
     *          SELECT column_1, column_2
     *          FROM table
     *          OFFSET #{offset} ROWS FETCH FIRST #{limit} ROWS ONLY;
     * @param offset 偏移量（起始行）
     * @param limit 限定数（获取数量）
     * @return 查询sql
     */
    public static String selectWithFetchFirst(Integer offset, Integer limit) {
        return new SQL()
                .SELECT("column_1", "column_2")
                .FROM("table")
                .OFFSET_ROWS(offset)
                .FETCH_FIRST_ROWS_ONLY(limit)
                .toString();
    }
}
