package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "faculty_id")
    private int facultyId;

    @Column(name = "university_id")
    private int universityId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "is_active")
    private boolean isActive;
}
