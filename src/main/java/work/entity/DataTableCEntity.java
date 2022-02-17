package work.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: zyb
 * @date: 2022/1/21 13:24
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataTableCEntity extends BaseRowModel implements Serializable {
    private static final long serialVersionUID = 1114030241296574500L;
    @ExcelProperty(value = "LogIndex", index = 0)
    private String a;
    @ExcelProperty(value = "MEActFOCons", index = 1)
    private String b;
    @ExcelProperty(value = "DGActFOCons", index = 2)
    private String c;
    @ExcelProperty(value = "BlrActFOCons", index = 3)
    private String d;
    @ExcelProperty(value = "MEActMGOCons", index = 4)
    private String e;
    @ExcelProperty(value = "DGActMGOCons", index = 5)
    private String f;
    @ExcelProperty(value = "DG1Power", index = 6)
    private String g;
    @ExcelProperty(value = "DG2Power", index = 7)
    private String h;
    @ExcelProperty(value = "DG3Power", index = 8)
    private String i;
    @ExcelProperty(value = "MESFOC_kw", index = 9)
    private String j;

    @ExcelProperty(value = "MESFOC_nmile", index = 10)
    private String k;
    @ExcelProperty(value = "MEShaftPow", index = 11)
    private String l;
    @ExcelProperty(value = "ShipSpdToWater", index = 12)
    private String m;
    @ExcelProperty(value = "ShipHeel", index = 13)
    private String n;
    @ExcelProperty(value = "ShipTrim", index = 14)
    private String o;
    @ExcelProperty(value = "WindSpd", index = 15)
    private String p;
    @ExcelProperty(value = "WindDir", index = 16)
    private String q;
    @ExcelProperty(value = "ShipDraughtBow", index = 17)
    private String r;
    @ExcelProperty(value = "ShipDraughtAstern", index = 18)
    private String s;
    @ExcelProperty(value = "ShipDraughtMidLft", index = 19)
    private String t;
    @ExcelProperty(value = "ShipDraughtMidRgt", index = 20)
    private String u;
}
