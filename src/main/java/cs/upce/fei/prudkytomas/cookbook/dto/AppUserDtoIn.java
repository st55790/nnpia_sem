package cs.upce.fei.prudkytomas.cookbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDtoIn {

    private Long id;

    @NotBlank
    @Size(min = 5, max = 32, message = "Username must be between 5 and 32 characters long")
    @Column
    private String username;

    @NotBlank
    @Size(min = 6)
    @Column
    private String password;

    @NotBlank
    @Email
    @Column
    private String email;
}
