package work;


import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import work.entity.DataTableEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @description: 导出excel文件相关工具类
 * @author: zyb
 * @date: 2020/10/14 16:05
 */
public class ExportExcelUtils {

    /**
     * 使用文件输出流导出excel （可用于单元测试或者主函数中导出excel）
     * @param list 导出对象集合
     * @param filePath 导出文件路径+文件名
     */
    public static void easyWrite(List<DataTableEntity> list, String filePath){
        ExcelWriter writer = null;
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath);
            //实例化 ExcelWriter
            writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX, true);
            //实例化表单
            Sheet sheet = new Sheet(1, 0, DataTableEntity.class);
            sheet.setSheetName("目录");
            writer.write(list, sheet);
            writer.finish();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据HttpServletResponse对象触发导出excel文件（可用于前端请求触发导出excel文件）
     * @param response HttpServletResponse对象
     * @param list 导出对象集合
     */
    public static void exportXLSX(HttpServletResponse response, List<DataTableEntity> list){
        //添加响应头信息
        //设置文件名
        response.setHeader("Content-disposition", "attachment; filename=" + "文件名.xlsx");
        //设置类型
        response.setContentType("application/msexcel;charset=UTF-8");
        //设置头
        response.setHeader("Pragma", "No-cache");
        //设置头
        response.setHeader("Cache-Control", "no-cache");
        //设置日期头
        response.setDateHeader("Expires", 0);

        ExcelWriter writer = null;
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            //实例化 ExcelWriter
            writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX, true);
            //实例化表单
            Sheet sheet = new Sheet(1, 0, DataTableEntity.class);
            sheet.setSheetName("目录");
            writer.write(list, sheet);
            writer.finish();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
