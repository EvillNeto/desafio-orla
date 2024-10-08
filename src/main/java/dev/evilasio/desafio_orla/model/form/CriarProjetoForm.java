package dev.evilasio.desafio_orla.model.form;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriarProjetoForm {

    @NotBlank
    private String nome;

    private Set<Long> idFuncionarios;
}
