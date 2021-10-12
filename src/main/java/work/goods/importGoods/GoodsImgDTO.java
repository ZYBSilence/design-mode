package work.goods.importGoods;

import java.util.Map;

/**
 * @description: 批量导入商品原始转换实体
 * @author: zyb
 * @date: 2020/10/13 14:12
 */
public class GoodsImgDTO {
    /**
     * 用于判断返回正确与否
     */
    private Map<String, String> baseResp;
    /**
     * 条码
     */
    private String sreqkey;
    /**
     * 存放条码对应图片实体
     */
    private TopicPage topicPage;

    public Map<String, String> getBaseResp() {
        return baseResp;
    }

    public void setBaseResp(Map<String, String> baseResp) {
        this.baseResp = baseResp;
    }

    public String getSreqkey() {
        return sreqkey;
    }

    public void setSreqkey(String sreqkey) {
        this.sreqkey = sreqkey;
    }

    public TopicPage getTopicPage() {
        return topicPage;
    }

    public void setTopicPage(TopicPage topicPage) {
        this.topicPage = topicPage;
    }

    @Override
    public String toString() {
        return "GoodsImgDTO{" +
                "baseResp=" + baseResp +
                ", sreqkey='" + sreqkey + '\'' +
                ", topicPage=" + topicPage +
                '}';
    }
}
