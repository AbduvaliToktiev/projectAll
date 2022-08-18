package family;

import sql.Datable;
import sql.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Parents extends Connect implements Datable{
    private Integer id;
    private String FIO;
    private Date birthday;
    private Integer inn;
    private String address;
    private String email;
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void insertParents(Parents parents) {
        String sqlParents = "insert into \"project\".parents (fio, birthday, inn, address, email, password) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlParents)) {
            preparedStatement.setString(1, parents.getFIO());
            preparedStatement.setDate(2, parents.readDate());
            preparedStatement.setInt(3, parents.getInn());
            preparedStatement.setString(4, parents.getAddress());
            preparedStatement.setString(5, parents.getEmail());
            preparedStatement.setString(6, parents.getPassword());
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
