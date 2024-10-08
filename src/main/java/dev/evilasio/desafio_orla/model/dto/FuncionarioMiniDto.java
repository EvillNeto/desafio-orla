package dev.evilasio.desafio_orla.model.dto;

import java.math.BigDecimal;
import java.util.List;

import dev.evilasio.desafio_orla.model.entity.Funcionario;
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

    public FuncionarioMiniDto(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.salario = funcionario.getSalario();
    }

    public static FuncionarioMiniDto toDto(Funcionario funcionario) {
        return new FuncionarioMiniDto(funcionario);
    }

    public static List<FuncionarioMiniDto> toDto(List<Funcionario> funcionarios) {
        return funcionarios.stream().map(FuncionarioMiniDto::new).toList();
    }
}
