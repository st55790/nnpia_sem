package cs.upce.fei.prudkytomas.cookbook.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "app_user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "app_user_id")
    )
    @ToString.Exclude
    @JsonIgnore
    private List<AppUser> users = Collections.emptyList();

    public Role(String name) {
        this.name = name;
    }
}
