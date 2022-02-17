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
 * @date: 2021/10/22 13:11
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataTableEntity extends BaseRowModel implements Serializable {
    private static final long serialVersionUID = 1764706991772348892L;

    @ExcelProperty(value = "index", index = 0)
    private Integer a;
    @ExcelProperty(value = "MEActFOCons", index = 1)
    private Double b;
    @ExcelProperty(value = "MESFOC_nmile", index = 2)
    private Double c;
    @ExcelProperty(value = "MEShaftPow", index = 3)
    private Double d;
    @ExcelProperty(value = "ShipSpdToWater", index = 4)
    private Double e;
    @ExcelProperty(value = "ShipSlip", index = 5)
    private Double f;
    @ExcelProperty(value = "WindSpd", index = 6)
    private Double g;
    @ExcelProperty(value = "ShipHeel", index = 7)
    private Double h;
    @ExcelProperty(value = "ShipTrim", index = 8)
    private Double i;

    @ExcelProperty(value = "std1", index = 9)
    private Double j;
    @ExcelProperty(value = "std2", index = 10)
    private Double k;
    @ExcelProperty(value = "std3", index = 11)
    private Double l;
    @ExcelProperty(value = "wavehight", index = 12)
    private Double m;

    public DataTableEntity(Integer a, Double b, Double c, Double d, Double e, Double f, Double g, Double h, Double i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
}
