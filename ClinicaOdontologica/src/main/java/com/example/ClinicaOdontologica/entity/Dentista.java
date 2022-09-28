package com.example.ClinicaOdontologica.entity;

import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.enums.Roles;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_dentista")
public class Dentista implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String nome;

    private String sobrenome;

    private String cro;

    private Integer matricula;
    private String email;
    private String senha;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roles.name());
        return Collections.singleton(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
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
    public boolean isEnabled() {
        return true;
    }


    public static Dentista.Builder builder() {
        return new Dentista.Builder();
    }


    public static class Builder {

        private Integer id;
        private String nome;
        private String sobrenome;
        private String cro;
        private Integer matricula;
        private String email;
        private String senha;
        private Roles roles;


        public Dentista.Builder roles(Roles role) {
            this.roles = role;
            return this;
        }

        public Dentista.Builder id(Integer id) {
            this.id = id;
            return this;
        }
        public Dentista.Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Dentista.Builder sobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public Dentista.Builder cro(String cro) {
            this.cro = cro;
            return this;
        }

        public Dentista.Builder matricula(Integer matricula) {
            this.matricula = matricula;
            return this;
        }

        public Dentista.Builder email(String email) {
            this.email = email;
            return this;
        }

        public Dentista.Builder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public Dentista build() {
            Dentista builder = new Dentista();
            builder.setId(this.id);
            builder.setNome(this.nome);
            builder.setSobrenome(this.sobrenome);
            builder.setEmail(this.email);
            builder.setSenha(this.senha);
            builder.setCro(this.cro);
            builder.setMatricula(this.matricula);
            builder.setRoles(this.roles);
            return builder;
        }

    }
}
