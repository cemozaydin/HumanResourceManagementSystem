package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Candidate extends User {


    @Column(name = "first_name")
    @NotNull
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @NotBlank
    private String lastName;

    @Column(name = "identity_number")
    @NotNull
    @NotBlank
    private String identityNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;


    public Candidate(String email, String password, String firstName, String lastName, String identityNumber, LocalDate birthDate) {
        super(email,password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.birthDate = birthDate;
    }
}
