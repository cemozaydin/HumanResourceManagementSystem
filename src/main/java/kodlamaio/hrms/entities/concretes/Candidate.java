package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.hrms.entities.abstracts.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "candidateSchools","candidateExperiences",
        "candidateLanguages","socialMediaAccounts","computerAndTechnologySkills","coverLetters"})
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

    @OneToMany(mappedBy = "candidate")
    private List<CandidateSchool> candidateSchools;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateExperience> candidateExperiences;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateLanguage> candidateLanguages;

    @OneToMany(mappedBy = "candidate")
    private List<SocialMediaAccount> socialMediaAccounts;

    @OneToMany(mappedBy = "candidate")
    private List<ComputerAndTechnologySkill> computerAndTechnologySkills;

    @OneToMany(mappedBy = "candidate")
    private List<CoverLetter> coverLetters;

    public Candidate(String email, String password, String firstName, String lastName, String identityNumber, LocalDate birthDate) {
        super(email,password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.birthDate = birthDate;
    }
}
