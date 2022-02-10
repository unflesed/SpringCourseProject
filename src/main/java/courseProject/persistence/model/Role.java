package courseProject.persistence.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "user_roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Long id;
    private String role;
    @JoinColumn(name = "username")
    private String login;
//    @ManyToMany(mappedBy = "roles")
//    private List<User> users;

    public Role() {
    }

    public Role(Long id, String role, String login) {
        this.id = id;
        this.role = role;
        this.login = login;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}