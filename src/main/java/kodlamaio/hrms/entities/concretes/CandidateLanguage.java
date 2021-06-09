package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_languages")
public class CandidateLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language_id")
    private int languageId;

    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "level")
    private int level;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
