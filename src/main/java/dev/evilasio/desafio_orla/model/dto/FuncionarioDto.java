package dev.evilasio.desafio_orla.model.dto;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;

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
public class FuncionarioDto {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private BigDecimal salario;

    private List<ProjetoMiniDto> projetos;

    public FuncionarioDto(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.email = funcionario.getEmail();
        this.salario = funcionario.getSalario();
        this.projetos = ProjetoMiniDto.toDto(funcionario.getProjetos());
    }

    public static FuncionarioDto toDto(Funcionario funcionario) {
        return new FuncionarioDto(funcionario);
    }

    public static List<FuncionarioDto> toDto(List<Funcionario> funcionarios) {
        return funcionarios.stream().map(FuncionarioDto::new).toList();
    }

    public static Page<FuncionarioDto> toDto(Page<Funcionario> funcionarios) {
        return funcionarios.map(FuncionarioDto::new);
    }
}
