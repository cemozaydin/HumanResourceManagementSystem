package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateSocialMediaAddressAddDto {
    private int id;
    private int candidateId;
    private String name;
    private String webAddress;

}
