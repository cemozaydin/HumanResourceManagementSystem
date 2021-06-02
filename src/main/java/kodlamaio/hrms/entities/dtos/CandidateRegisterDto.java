package kodlamaio.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirm;
    private String identityNumber;
    private LocalDate birthDate;
}
