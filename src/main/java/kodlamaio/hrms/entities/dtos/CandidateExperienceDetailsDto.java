package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateExperienceDetailsDto {
    private int id;
    private int candidateId;
    private String candidateName;
    private String candidateLastName;
    private String candidateWorkplace;
    private String candidateJobTitle;
    private String workplaceCity;
    private LocalDate startingDate;
    private LocalDate endingDate;
}
