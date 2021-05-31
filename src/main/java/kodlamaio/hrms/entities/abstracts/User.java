package kodlamaio.hrms.entities.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.SystemUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "isActive")
    private boolean isActive;

//    @OneToOne(mappedBy = "user")
//    private SystemUser systemUser;
//
//    @OneToOne(mappedBy = "user")
//    private Candidate candidate;

}
