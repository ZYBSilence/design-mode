package work.entity;

/**
 * @description:
 * @author: zyb
 * @date: 2021/1/5 18:35
 */
public class TestEntity {
    private Integer groupId;
    private Integer userId;
    private Integer day;
    private Integer num;
    private String name;

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

    public TestEntity(String name) {
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

    @Override
    public String toString() {
        return "TestEntity{" +
                "groupId=" + groupId +
                ", userId=" + userId +
                ", day=" + day +
                ", num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
