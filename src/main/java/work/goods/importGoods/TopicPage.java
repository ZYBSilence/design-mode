package work.goods.importGoods;

import java.util.List;
import java.util.Map;

/**
 * @description: 存放条码对应图片实体
 * @author: zyb
 * @date: 2020/10/13 14:20
 */
public class TopicPage {
    private List<Map<String, String>> img;

    public List<Map<String, String>> getImg() {
        return img;
    }

    public void setImg(List<Map<String, String>> img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "TopicPage{" +
                "img=" + img +
                '}';
    }
}
