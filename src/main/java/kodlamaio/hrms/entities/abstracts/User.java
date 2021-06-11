package kodlamaio.hrms.entities.abstracts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.hrms.entities.concretes.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "images"})
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "is_active")
    private boolean isActive = false;

    @OneToMany(mappedBy = "user")
    List<Image> images;

    public User(String email, String password, boolean isActive) {
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    public User(String email, String password){
        this.email=email;
        this.password=password;
    }
}
