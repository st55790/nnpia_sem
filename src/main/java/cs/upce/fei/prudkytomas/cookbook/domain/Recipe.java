package cs.upce.fei.prudkytomas.cookbook.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @SequenceGenerator(name = "recipe_id_seq", sequenceName = "recipe_id_seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_id_seq")
    @Column(name = "id", nullable = false)
    private Long id;

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

    @ElementCollection
    @CollectionTable(name = "links_to_images")
    private List<String> linksToImages = Collections.emptyList();

    @ManyToMany(mappedBy = "recipes")
    private List<Ingredient> ingredients = Collections.emptyList();

    @ManyToMany(mappedBy = "recipes")
    private List<Category> categories = Collections.emptyList();

    @ManyToMany
    @JoinTable(
            name = "app_user_recipe",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "app_user_id")
    )
    @JsonIgnore
    private List<AppUser> users = Collections.emptyList();

    @ManyToOne
    private AppUser owner;
}
