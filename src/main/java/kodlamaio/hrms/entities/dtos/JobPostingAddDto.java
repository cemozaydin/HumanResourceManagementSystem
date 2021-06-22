package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingAddDto {

    private int employerId;
    private int JobTitleId;
    private int cityId;
    private String postingTitle;
    private String postingDescription;
    private BigDecimal min_salary;
    private BigDecimal max_salary;
    private int currencyId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate postingDeadline;
    private int jobTypeId;
    private int workplaceTypeId;

}
