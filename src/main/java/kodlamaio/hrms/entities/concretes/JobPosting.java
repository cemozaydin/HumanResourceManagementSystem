package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_postings")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobType", "workplaceType","employer"})
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "posting_title")
    private String postingTitle;

    @Column(name = "posting_description")
    private String postingDescription;

    @Column(name = "min_salary")
    private BigDecimal min_salary;

    @Column(name = "max_salary")
    private BigDecimal max_salary;

    @Column(name = "posting_release_date")
    private LocalDate postingReleaseDate= LocalDate.now();

    @Column(name = "posting_deadline")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate postingDeadline;

    @Column(name = "number_of_open_positions")
    private int numberOfOpenPositions;

    @Column(name = "is_active",columnDefinition = "boolean default false")
    private boolean isActive;

    @Column(name = "is_confirm_by_admin",columnDefinition = "boolean default false")
    private boolean isConfirmByAdmin;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name="job_title_id")
    private JobTitle jobTitle;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @ManyToOne()
    @JoinColumn(name = "job_type_id")
    private JobType jobType;

    @ManyToOne()
    @JoinColumn(name = "workplace_type_id")
    private WorkplaceType workplaceType;
}
