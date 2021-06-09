package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_schools")
public class CandidateSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "university_id")
    private int universityId;

    @Column(name = "faculty_id")
    private int facultyId;

    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "graduated_date")
    private LocalDate graduatedDate;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;




}
