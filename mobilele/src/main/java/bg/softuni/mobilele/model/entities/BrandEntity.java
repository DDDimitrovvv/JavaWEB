package bg.softuni.mobilele.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

//        •	id – a uuid or number
//        •	name – a name of brand
//        •	created – a date and time
//        •	modified – a date and time

    @Column(unique = true, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BrandEntity{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", name='" + name + '\'' +
                '}';
    }
}
