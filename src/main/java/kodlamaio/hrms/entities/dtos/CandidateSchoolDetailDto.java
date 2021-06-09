package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateSchoolDetailDto {
    private int id;
    private int candidateId;
    private String candidateName;
    private String candidateLastName;
    private String candidateUniversityName;
    private String candidateFacultyName;
    private String candidateDepartmentName;
    private LocalDate startingDate;
    private LocalDate endingDate;
}
