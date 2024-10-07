package dev.evilasio.desafio_orla.model.dto;

import java.math.BigDecimal;

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
public class FuncionarioMiniDto {

    private Long id;
    
    private String nome;

    private BigDecimal salario;
}
