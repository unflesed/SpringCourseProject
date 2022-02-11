package courseProject.persistence.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity(name = "user_roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Long id;
    private String role;
    private String username;
    @ManyToOne
    @Transient
    private User user;

    public Role() {
    }

    public Role(String role, String username) {
        this.role = role;
        this.username = username;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}