package kindergarten;

public class Groups {
    private Integer id;
    private String group_name;
    private String headEducatorFio;
    private Integer kindergartenId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getHeadEducatorFio() {
        return headEducatorFio;
    }

    public void setHeadEducatorFio(String headEducatorFio) {
        this.headEducatorFio = headEducatorFio;
    }

    public Integer getKindergartenId() {
        return kindergartenId;
    }

    public void setKindergartenId(Integer kindergartenId) {
        this.kindergartenId = kindergartenId;
    }
}
