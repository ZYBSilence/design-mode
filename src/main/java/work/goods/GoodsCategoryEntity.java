package work.goods;

import java.util.List;

/**
 * @description: 商品分类
 * @author: zyb
 * @date: 2020/9/18 11:55
 */
public class GoodsCategoryEntity {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 父级id
     */
    private Integer parentId;
    /**
     * 分类图片
     */
    private String categoryPic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCategoryPic() {
        return categoryPic;
    }

    public void setCategoryPic(String categoryPic) {
        this.categoryPic = categoryPic;
    }

    @Override
    public String toString() {
        return "GoodsCategoryEntity{" +
                "id=" + id +
                ", categoryName=" + categoryName +
                ", parentId=" + parentId +
                ", categoryPic='" + categoryPic + '\'' +
                '}';
    }
}
