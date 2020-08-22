package autoria.entities;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name="peoples")
public class People {
    @Id
    private int id;

    @Column (name="FULL_NAME", nullable = true, length = 255)
    private String fullName;

    @Column (name="Phone", nullable = true, length = 11)
    private String phone;

    @Column (name="GENDER", nullable = true, length = 10)
    private String gender;

    @Column (name="CITY", nullable = true, length = 255)
    private String city;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public People() {
    }

    public People(String fullName, String phone, String gender, String city) {
        this.fullName = fullName;
        this.phone = phone;
        this.gender = gender;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
