package mainPackage;

import sql.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Rayons extends Connect {
    private Integer id;
    private String nameRayon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameRayon() {
        return nameRayon;
    }

    public void setNameRayon(String nameRayon) {
        this.nameRayon = nameRayon;
    }

    public List<Rayons> getRayonsFromDataBase() {
        List<Rayons> rayonsList = new ArrayList<>();
        String sqlRayons = "select * from \"project\".rayons";

        try (PreparedStatement preparedStatement = connection().prepareStatement(sqlRayons);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
             Rayons rayons = new Rayons();
             rayons.setId(resultSet.getInt("ID"));
             rayons.setNameRayon(resultSet.getString("NAME_RAYON"));
             rayonsList.add(rayons);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return rayonsList;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " \n" +
                "NAME_RAYON: " + nameRayon ;
    }
}
