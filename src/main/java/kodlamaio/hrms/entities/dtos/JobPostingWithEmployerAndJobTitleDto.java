package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingWithEmployerAndJobTitleDto {
    private int id;
    private String companyName;
    private String jobTitle;
    private String postingTitle;
    private String postingDescription;
    private String cityName;
    private int numberOfOpenPositions;
    private LocalDate postingReleaseDate;
    private LocalDate postingDeadline;
    private boolean isActive;
}
