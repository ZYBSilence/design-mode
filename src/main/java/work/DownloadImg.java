package work;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * @description: 根据图片链接地址下载图片
 * @author: zyb
 * @date: 2020/10/13 15:47
 */
public class DownloadImg {
    public static void main(String[] args) {
//        List<String> read = FileRead.read("C:\\Users\\1\\Desktop\\小时代相关文档\\小时代所有条形码对应商品列表图.txt");
//        int i = 1;
//        for (String s : read) {
//            System.out.println(i++);
//            String[] split = s.split("\\s+");
//            downloadFile(split[1], "C:\\Users\\1\\Desktop\\小时代相关文档\\小时代条码对应图片\\"+ split[0] + ".jpg");
//        }
//        downloadFile("图片链接地址", "下载存放图片地址 + 文件名");
        String path = "C:\\Users\\1\\Desktop\\生活\\广告、主题相关表_files\\广告、主题相关图片\\tu";
        int i = 1;
        List<String> read = FileRead.read("C:\\Users\\1\\Desktop\\生活\\广告、主题相关表_files\\广告、主题相关图片\\tu\\图片.txt");
        for (String s : read) {
            download(s, i +".jpg", path);
            i++;
        }
    }

    /**
     * 根据链接地址下载文件
     * @param downloadUrl 文件链接地址
     * @param path        下载存放文件地址 + 文件名
     */
    private static void downloadFile(String downloadUrl, String path) {
        URL url = null;
        DataInputStream dataInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            url = new URL(downloadUrl);
            dataInputStream = new DataInputStream(url.openStream());
            fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param downloadUrl 文件链接地址
     * @param filename    保存文件名
     * @param filePath    保存文件路径
     */
    private static void download(String downloadUrl, String filename, String filePath) {
        URL url = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            url = new URL(downloadUrl);
            // 打开连接
            URLConnection con = url.openConnection();
            // 请求超时:5s
            con.setConnectTimeout(5 * 1000);
            inputStream = con.getInputStream();

            byte[] bytes = new byte[1024];
            // 读取到的数据长度
            int length;
            File savePath = new File(filePath);
            if (!savePath.exists()) {
                // 如果不存在当前文件夹，则创建该文件夹
                boolean mkdir = savePath.mkdirs();
                if (!mkdir) {
                    System.out.println("创建文件夹失败");
                    return;
                }
            }
            outputStream = new FileOutputStream(savePath.getPath() + "\\" + filename);
            // 读取
            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}