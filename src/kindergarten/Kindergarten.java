package kindergarten;

public class Kindergarten {
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
}
