package cs.upce.fei.prudkytomas.cookbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDtoOut {

    private String username;
    private String email;

}
