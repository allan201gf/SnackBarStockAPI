package br.com.allangf.SnackBarStockAPI.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "email")
    private String email;

}
