package dev.evilasio.desafio_orla.model.dto;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoDto {

    private Long id;

    private String nome;

    private List<FuncionarioMiniDto> funcionarios;
}
