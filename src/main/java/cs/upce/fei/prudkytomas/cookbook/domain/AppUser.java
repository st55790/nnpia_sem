package cs.upce.fei.prudkytomas.cookbook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @SequenceGenerator(name = "app_users_id_seq", sequenceName = "app_users_id_seq", allocationSize = 50, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_user_id_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 32, message = "Name must be between 5 and 32 characters long")
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

    @OneToMany(mappedBy = "owner")
    @ToString.Exclude
    private List<Recipe> userRecipes = Collections.emptyList();

    @ManyToMany(mappedBy = "users")
    private List<Recipe> favoriteRecipes = Collections.emptyList();

    @ManyToMany(mappedBy = "users")
    private List<Role> roles = Collections.emptyList();
}
