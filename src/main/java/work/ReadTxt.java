//package work;
//
//import com.alibaba.excel.ExcelWriter;
////import com.alibaba.excel.metadata.Sheet;
//import com.alibaba.excel.support.ExcelTypeEnum;
//import com.alibaba.fastjson.JSON;
//import work.goods.importGoods.GoodsImgDTO;
//import work.goods.importGoods.GoodsImgExcel;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.*;
//
///**
// * @description: 读取txt文件
// * @author: zyb
// * @date: 2020/10/13 15:47
// */
//public class ReadTxt {
//
//
//    public static void main(String[] args) throws IOException {
//        List<String> barcodeList = FileRead.read("C:\\Users\\1\\Desktop\\小时代相关文档\\小时代所有条码.txt");
//        System.out.println("所有数量:" + barcodeList.size());
//        //成功且有图片
//        List<GoodsImgExcel> list = new LinkedList<>();
//        //成功但没图片
//        List<GoodsImgExcel> blankList = new LinkedList<>();
//        //失败且没图片
//        List<GoodsImgExcel> failList = new LinkedList<>();
//
//        int i = 0;
//        for (String barcode : barcodeList) {
//            String json = HttpClientHelper.sendGet("https://mp.weixin.qq.com/cgi-bin/newscanproductinfo?action=GetPage&barcode_type=EAN13&barcode=" + barcode);
//
//            GoodsImgDTO originalDTO = JSON.parseObject(json, GoodsImgDTO.class);
//            if ("ok".equals(originalDTO.getBaseResp().get("err_msg"))) {
//                //请求成功
//                List<Map<String, String>> img = originalDTO.getTopicPage().getImg();
//                if (img != null && !img.isEmpty()) {
//                    //有商品图片
//                    GoodsImgExcel goodsImgExcel = new GoodsImgExcel();
//                    goodsImgExcel.setBarcode(originalDTO.getSreqkey());
//                    goodsImgExcel.setListPicUrl(img.get(0).get("img_url"));
//                    list.add(goodsImgExcel);
//                } else {
//                    //请求成功，但是没图片
//                    GoodsImgExcel blankImg = new GoodsImgExcel();
//                    blankImg.setBarcode(barcode);
//                    blankList.add(blankImg);
//                }
//            } else {
//                //请求失败
//                GoodsImgExcel failImg = new GoodsImgExcel();
//                failImg.setBarcode(barcode);
//                failList.add(failImg);
//            }
//            i++;
//            System.out.println(i);
////            System.out.println(json);
//        }
//        if (!list.isEmpty()) {
//            //导出返回成功并且有图片的条形码和商品图片对应表格
//            easyWrite(list, "C:\\Users\\1\\Desktop\\小时代相关文档\\小时代条形码相关\\小时代所有条形码对应商品列表图.xlsx");
//        }
//        if (!blankList.isEmpty()) {
//            //导出请求成功但没图片的条形码
//            easyWrite(blankList, "C:\\Users\\1\\Desktop\\小时代相关文档\\小时代条形码相关\\小时代所有请求成功但没有图片的条形码.xlsx");
//        }
//        if (!failList.isEmpty()) {
//            //导出请求失败的条形码
//            easyWrite(failList, "C:\\Users\\1\\Desktop\\小时代相关文档\\小时代条形码相关\\小时代所有请求失败的条形码.xlsx");
//        }
//    }
//
//    /**
//     * 使用文件输出流导出excel （可用于单元测试或者主函数中导出excel）
//     * @param list     导出对象集合
//     * @param filePath 导出文件路径+文件名
//     */
//    private static void easyWrite(List<GoodsImgExcel> list, String filePath) {
//        ExcelWriter writer = null;
//        FileOutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream(filePath);
//            //实例化 ExcelWriter
//            writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX, true);
//            //实例化表单
//            Sheet sheet = new Sheet(1, 0, GoodsImgExcel.class);
//            sheet.setSheetName("目录");
//            writer.write(list, sheet);
//            writer.finish();
//            outputStream.flush();
//        } catch (IOException e) {
//            //最好使用日志打印异常
//            e.printStackTrace();
//        } finally {
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    /**
//     * 根据HttpServletResponse对象触发导出excel文件（可用于前端请求触发导出excel文件）
//     * @param response HttpServletResponse对象
//     * @param list     导出对象集合
//     */
//    private static void exportXLSX(HttpServletResponse response, List<GoodsImgExcel> list) {
//        //添加响应头信息
//        //设置文件名
//        response.setHeader("Content-disposition", "attachment; filename=" + "picture.xlsx");
//        //设置类型
//        response.setContentType("application/msexcel;charset=UTF-8");
//        //设置头
//        response.setHeader("Pragma", "No-cache");
//        //设置头
//        response.setHeader("Cache-Control", "no-cache");
//        //设置日期头
//        response.setDateHeader("Expires", 0);
//
//        ExcelWriter writer = null;
//        OutputStream outputStream = null;
//        try {
//            outputStream = response.getOutputStream();
//            //实例化 ExcelWriter
//            writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX, true);
//            //实例化表单
//            Sheet sheet = new Sheet(1, 0, GoodsImgExcel.class);
//            sheet.setSheetName("目录");
//            writer.write(list, sheet);
//            writer.finish();
//            outputStream.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (outputStream != null){
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
