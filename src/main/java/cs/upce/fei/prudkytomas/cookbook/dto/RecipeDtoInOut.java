package cs.upce.fei.prudkytomas.cookbook.dto;

import cs.upce.fei.prudkytomas.cookbook.domain.AppUser;
import cs.upce.fei.prudkytomas.cookbook.domain.Category;
import cs.upce.fei.prudkytomas.cookbook.domain.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDtoInOut {

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private String procedure;

    private Integer prepareTime;

    private Integer numberOfPortions;

    private double rating;

    private AppUser owner;

    private List<String> linksToImages = Collections.emptyList();

    private List<Ingredient> ingredients = Collections.emptyList();

    private List<Category> categories = Collections.emptyList();
}
