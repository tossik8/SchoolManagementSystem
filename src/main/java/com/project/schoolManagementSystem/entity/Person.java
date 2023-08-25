package com.project.schoolManagementSystem.entity;

import com.project.schoolManagementSystem.enumeration.Role;
import com.project.schoolManagementSystem.model.RegistrationRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String username;
    private String password;
    private LocalDate birthdate;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    protected Person(RegistrationRequest request) {
        name = request.getName();
        surname = request.getSurname();
        username = request.getUsername();
        password = request.getPassword();
        birthdate = request.getBirthdate();
        role = request.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public abstract boolean isEnabled();
}
