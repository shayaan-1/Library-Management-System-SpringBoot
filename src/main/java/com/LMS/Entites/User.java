package com.LMS.Entites;

import com.LMS.Constants.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "buser")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BorrowingRecord> borrowingHistory;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        // Customize this if you need to implement account expiration logic
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Customize this if you need to implement account locking logic
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Customize this if you need to implement credentials expiration logic
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Customize this if you need to implement user enabling/disabling logic
        return true;
    }
}
