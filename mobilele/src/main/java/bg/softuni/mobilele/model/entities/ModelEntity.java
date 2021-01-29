package bg.softuni.mobilele.model.entities;

import bg.softuni.mobilele.model.entities.enums.ModelCategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

//  name – a model name.
//  category – an enumeration (Car, Buss, Truck, Motorcycle)
//  imageUrl – the url of image with size between 8 and 512 characters.
//  startYear – a number.
//  endYear – a number.
//  brand – a model brand.


    private String name;

    @Enumerated(EnumType.STRING)
    private ModelCategoryEnum category;

    @Column(length = 512)
    private String imageUrl;

    private int startYear;

    private Integer endYear;

    @ManyToOne
    private BrandEntity brand;

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public ModelCategoryEnum getCategory() {
        return category;
    }

    public ModelEntity setCategory(ModelCategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public String toString() {
        return "ModelEntity{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", brand=" + brand +
                '}';
    }
}
