package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateLanguageDetailDto {
    private int id;
    private int candidateId;
    private String languageName;
    private int level;

}
