package work;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 读取指定文件夹下的所有文件
 * @author: zyb
 * @date: 2020/10/28 18:09
 */
public class FilePathTest {
    public static void main(String[] args) {
//        readFilePath("C:\\Users\\1\\Desktop\\小时代体验店处理商品图片");
        List<File> files = getFileList("C:\\Users\\1\\Desktop\\小时代相关文档", "txt");
        System.out.println("=======================================================");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    /**
     * 通过文件夹路径收集下面的所有的文件（文件夹下的一级目录）
     * @param filePath 文件夹路径
     */
    private static void readFilePath(String filePath) {
        File file = new File(filePath);
        File[] files = file.listFiles();
        if (files != null) {
            for (File file1 : files) {
                //输出文件名（带后缀）
                System.out.println(file1.getName());
                //输出文件名（去后缀）
                System.out.println(file1.getName().split("\\.")[0]);
            }
        }
    }


    /**
     * 通过文件夹路径收集指定类型文件
     * @param filePath 文件夹路径
     * @param fileType 文件类型
     * @return 指定类型文件集合
     */
    private static List<File> getFileList(String filePath, String fileType) {
        List<File> fileList = new ArrayList<>();
        File dir = new File(filePath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();

                // 判断是文件还是文件夹
                if (file.isDirectory()) {
                    // 如果是文件夹，递归获取文件夹下的文件（file.getAbsolutePath():获取文件绝对路径）
                    getFileList(file.getAbsolutePath(), fileType);
                } else if (fileName.endsWith(fileType)) {
                    // 如果是文件，则判断文件名是否以".fileType"结尾
                    fileList.add(file);
                }
            }
        }
        return fileList;
    }
}
