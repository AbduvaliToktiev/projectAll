package family;

import sql.Datable;
import sql.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Children extends Connect implements Datable {
    private Integer id;
    private String FIO;
    private Date birthday;
    private Integer inn;
    private String address;
    private Integer parentId;
    private Integer classId;
    private Integer groupId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getInn() {
        return inn;
    }

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void insertChildren(Children children) {
        String sqlChildren = "insert into \"project\".children (fio, birthday, inn, address, parent_id, class_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlChildren)) {
            preparedStatement.setString(1, children.getFIO());
            preparedStatement.setDate(2, children.readDate());
            preparedStatement.setInt(3, children.getInn());
            preparedStatement.setString(4, children.getAddress());
            preparedStatement.setInt(5, children.getParentId());
            preparedStatement.setInt(6, children.getClassId());
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
