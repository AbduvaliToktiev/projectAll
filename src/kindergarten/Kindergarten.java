package kindergarten;

import mainPackage.Administrators;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Kindergarten extends Administrators {
    private Integer id;
    private String nameKindergarten;
    private String address;
    private String description;
    private Integer rayonId;
    private Integer administratorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameKindergarten() {
        return nameKindergarten;
    }

    public void setNameKindergarten(String nameKindergarten) {
        this.nameKindergarten = nameKindergarten;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<Kindergarten> getKindergartenFromDataBase() {
        List<Kindergarten> kindergartenList = new ArrayList<>();
        String sqlKindergarten = "select k.id, " +
                "       k.name_kindergarten, " +
                "       k.address, " +
                "       k.description, " +
                "       r.name_rayon, " +
                "       a.fio " +
                "from project.kindergarten k " +
                "         inner join project.rayons r on r.id = k.rayon_id " +
                "         inner join project.administrators a on a.id = k.administrator_id";

        try (PreparedStatement preparedStatement = connection().prepareStatement(sqlKindergarten);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Kindergarten kindergarten = new Kindergarten();
                kindergarten.setId(resultSet.getInt("ID"));
                kindergarten.setNameKindergarten(resultSet.getString("NAME_KINDERGARTEN"));
                kindergarten.setAddress(resultSet.getString("ADDRESS"));
                kindergarten.setDescription(resultSet.getString("DESCRIPTION"));
                kindergarten.setNameRayon(resultSet.getString("NAME_RAYON"));
                kindergarten.setFio(resultSet.getString("FIO"));
                kindergartenList.add(kindergarten);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return kindergartenList;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " \n" +
                "NAME_KINDERGARTEN: " + this.nameKindergarten + " \n" +
                "ADDRESS: " + this.address + " \n" +
                "DESCRIPTION: " + this.description + " \n" +
                "NAME_RAYON: " + getNameRayon() + " \n" +
                "FIO: " + getFio();
    }
}
