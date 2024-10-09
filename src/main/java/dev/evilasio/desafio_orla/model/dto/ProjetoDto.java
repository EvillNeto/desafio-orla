package dev.evilasio.desafio_orla.model.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import dev.evilasio.desafio_orla.model.entity.Projeto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoDto {

    private Long id;

    private String nome;

    private List<FuncionarioMiniDto> funcionarios;

    public ProjetoDto(Projeto projeto) {
        this.id = projeto.getId();
        this.nome = projeto.getNome();
        this.funcionarios = FuncionarioMiniDto.toDto(projeto.getFuncionarios());
    }

    public static ProjetoDto toDto(Projeto funcionario) {
        return funcionario == null ? null : new ProjetoDto(funcionario);
    }

    public static List<ProjetoDto> toDto(List<Projeto> funcionarios) {
        return funcionarios == null ? null : funcionarios.stream().map(ProjetoDto::new).toList();
    }

    public static Page<ProjetoDto> toDto(Page<Projeto> funcionarios) {
        return funcionarios == null ? null : funcionarios.map(ProjetoDto::new);
    }
}
