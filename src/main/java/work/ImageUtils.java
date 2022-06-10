package work;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @description: 图片工具类
 * @author: zyb
 * @date: 2022/5/18 14:29
 */
public class ImageUtils {

    /**
     * 根据url获取图片信息
     *
     * @param imgUrl 图片链接
     * @return 图片信息
     */
    public static BufferedImage getBufferedImage(String imgUrl) {
        URL url = null;
        InputStream is = null;
        BufferedImage img = null;
        try {
            url = new URL(imgUrl);
            is = url.openStream();
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert is != null;
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }

    public static void main(String[] args) {
        BufferedImage bufferedImage = getBufferedImage("http://livefile-1300828364.cos.ap-shanghai.myqcloud.com/f2cd099b-6f8a-4db3-9599-0f6c49538105.jpeg");
        System.out.println(bufferedImage);

    }
}
