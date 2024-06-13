package ir.maktabsharif105.jdbc.domain;

public class Province
        extends BaseEntity<Long> {

    public static final String TABLE_NAME = "province";

    private String name;

    public Province() {
    }

    public Province(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Province{" +
               "id=" + getId() +
               ", name='" + name + '\'' +
               '}';
    }
}
