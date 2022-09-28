package com.example.ClinicaOdontologica.entity;

import com.example.ClinicaOdontologica.enums.Roles;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_paciente")
public class Paciente implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String nome;
    private String sobrenome;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


    @Column(unique = true)
    private String rg;

    @Column(name = "Data_de_Alta")
    private Date dataDeAlta;

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


    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private Integer id;
        private String nome;
        private String sobrenome;
        private Endereco endereco;
        private String rg;
        private Date dataDeAlta;
        private String email;
        private String senha;
        private Roles roles;

        public Paciente.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Paciente.Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Paciente.Builder sobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public Paciente.Builder endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Paciente.Builder rg(String rg) {
            this.rg = rg;
            return this;
        }

        public Paciente.Builder dataDeAlta(Date dataDeAlta) {
            this.dataDeAlta = dataDeAlta;
            return this;
        }

        public Paciente.Builder email(String email) {
            this.email = email;
            return this;
        }

        public Paciente.Builder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public Paciente.Builder roles(Roles roles) {
            this.roles = roles;
            return this;
        }

        public Paciente build() {
            Paciente builder = new Paciente();
            builder.setId(this.id);
            builder.setNome(this.nome);
            builder.setSobrenome(this.sobrenome);
            builder.setEndereco(this.endereco);
            builder.setRg(this.rg);
            builder.setDataDeAlta(this.dataDeAlta);
            builder.setEmail(this.email);
            builder.setSenha(this.senha);
            builder.setRoles(this.roles);
            return builder;
        }
    }
}
