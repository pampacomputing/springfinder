package com.pampa.springfinder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "cpf")
public class UserModel implements Serializable {

    @Id
    private String cpf;

    @Column(name = "nome")
    private String name;

    @Column(name = "sexo")
    private String gender;

    @Column(name = "nasc")
    private String date;

}
