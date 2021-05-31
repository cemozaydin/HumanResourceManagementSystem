package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Candidate extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

//    @OneToOne()
//    @JoinColumn(name = "user_id",referencedColumnName = "id")
//    private User user;
}
