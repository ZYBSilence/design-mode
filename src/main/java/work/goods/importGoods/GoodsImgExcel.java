package work.goods.importGoods;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.io.Serializable;

/**
 * @description: 导出条形码和对应商品图片实体
 * @author: zyb
 * @date: 2020/10/13 17:47
 */
public class GoodsImgExcel extends BaseRowModel implements Serializable {
    private static final long serialVersionUID = 8838958399566303983L;

    @ExcelProperty(value = "条形码", index = 0)
    private String barcode;
    @ExcelProperty(value = "商品列表图", index = 1)
    private String listPicUrl;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }

    @Override
    public String toString() {
        return "GoodsImgExcel{" +
                "barcode='" + barcode + '\'' +
                ", listPicUrl='" + listPicUrl + '\'' +
                '}';
    }
}
