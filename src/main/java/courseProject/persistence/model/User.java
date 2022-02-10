package courseProject.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "users")
public class User /*implements UserDetails*/ {
    @Id
    @Column(name = "username")
    private String userName;
    private String password;
    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
    @ManyToMany(fetch = FetchType.EAGER)
    @Transient
    private List<Role> roles;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_journal",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "journal_id"))
    private List<Journal> journals = new ArrayList<>();

    public User() {
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles;
//    }
//
//    @Override
//    public String getUsername() {
//        return getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
