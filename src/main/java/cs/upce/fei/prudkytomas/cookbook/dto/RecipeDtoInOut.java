package cs.upce.fei.prudkytomas.cookbook.dto;

import cs.upce.fei.prudkytomas.cookbook.domain.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDtoInOut {

    @NotBlank
    @Column
    private String name;

    @Column
    private String description;

    @NotBlank
    @Column
    private String procedure;

    @Column
    private Integer prepareTime;

    @Column
    private Integer numberOfPortions;

    @Column
    private double rating;

    private AppUser owner;
}
