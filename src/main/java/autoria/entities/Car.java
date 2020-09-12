package autoria.entities;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="vendor")
    private String vendor;

    @Column(name="model_car")
    private String model;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="color_id")
    private Color color;

    @Column(name="image_1")
    private String image_1;
    @Column(name="image_2")
    private String image_2;

    @Column(name="image_3")
    private String image_3;

    @Column(name="image_4")
    private String image_4;

    @Column(name="image_5")
    private String image_5;

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getImage_1() { return image_1; }

    public void setImage_1(String image_1) { this.image_1 = image_1; }

    public String getImage_2() {
        return image_2;
    }

    public void setImage_2(String image_2) {
        this.image_2 = image_2;
    }

    public String getImage_3() {
        return image_3;
    }

    public void setImage_3(String image_3) {
        this.image_3 = image_3;
    }

    public String getImage_4() {
        return image_4;
    }

    public void setImage_4(String image_4) {
        this.image_4 = image_4;
    }

    public String getImage_5() {
        return image_5;
    }

    public void setImage_5(String image_5) {
        this.image_5 = image_5;
    }
}
