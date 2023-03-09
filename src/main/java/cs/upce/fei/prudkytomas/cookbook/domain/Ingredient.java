package cs.upce.fei.prudkytomas.cookbook.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @SequenceGenerator(name = "ingredient_id_seq", sequenceName = "ingredient_id_seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_id_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    @JsonIgnore
    private List<Recipe> recipes = Collections.emptyList();
}
