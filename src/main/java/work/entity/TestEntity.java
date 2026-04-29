package work.entity;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zyb
 * @date: 2021/1/5 18:35
 */
@Data
public class TestEntity {
    @JSONField(name = "group_id")
    private Integer groupId;
    private Integer userId;
    private Integer day;
    private Integer num;
    private String name;

    private Date datetime;

    private List<AAABBB> aaabbbList;

    public TestEntity() {
    }

    public TestEntity(Integer userId) {
        this.userId = userId;
    }

    public TestEntity(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public TestEntity(Integer userId, Integer num, String name) {
        this.userId = userId;
        this.num = num;
        this.name = name;
    }

    public TestEntity(Integer groupId, Integer userId, Integer day, Integer num, String name) {
        this.groupId = groupId;
        this.userId = userId;
        this.day = day;
        this.num = num;
        this.name = name;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public List<AAABBB> getAaabbbList() {
        return aaabbbList;
    }

    public void setAaabbbList(List<AAABBB> aaabbbList) {
        this.aaabbbList = aaabbbList;
    }

    public TestEntity(String name) {
        this.name = name;
    }
}
