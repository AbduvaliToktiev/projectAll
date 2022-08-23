package school;

import mainPackage.Administrators;
import mainPackage.Rayons;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class School extends Administrators {
    private Integer id;
    private String address;
    private String nameSchool;
    private String description;
    private Integer rayonId;
    private Integer administratorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRayonId() {
        return rayonId;
    }

    public void setRayonId(Integer rayonId) {
        this.rayonId = rayonId;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public List<School> getSchoolsFromDataBase() {
        List<School> schoolList = new ArrayList<>();
        String sqlSchool = "select s.id, " +
                "       s.address, " +
                "       s.name_school, " +
                "       s.description, " +
                "       r.name_rayon, " +
                "       a.fio " +
                "from project.schools s " +
                "         inner join project.rayons r on r.id = s.rayon_id " +
                "         inner join project.administrators a on s.administrator_id = a.id";

        try (PreparedStatement preparedStatement = connection().prepareStatement(sqlSchool);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                School school = new School();
                school.setId(resultSet.getInt("ID"));
                school.setNameSchool(resultSet.getString("NAME_SCHOOL"));
                school.setAddress(resultSet.getString("ADDRESS"));
                school.setDescription(resultSet.getString("DESCRIPTION"));
                school.setNameRayon(resultSet.getString("NAME_RAYON"));
                school.setFio(resultSet.getString("FIO"));
                schoolList.add(school);
            }
        } catch (SQLException e) {
                 throw new RuntimeException();
        }
        return schoolList;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " \n" +
                "ADDRESS: " + this.address + " \n" +
                "DESCRIPTION: " + this.description + " \n" +
                "NAME_RAYON: " + getNameRayon() + " \n" +
                "ADMINISTRATOR FIO: " + getFio();
    }
}
