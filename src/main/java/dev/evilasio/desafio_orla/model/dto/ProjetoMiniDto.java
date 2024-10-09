package dev.evilasio.desafio_orla.model.dto;

import java.util.List;

import dev.evilasio.desafio_orla.model.entity.Projeto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoMiniDto {

    private Long id;

    private String nome;

    public ProjetoMiniDto(Projeto p) {
        this.id = p.getId();
        this.nome = p.getNome();
    }

    public static ProjetoMiniDto toDto(Projeto projeto) {
        return projeto == null ? null : new ProjetoMiniDto(projeto);
    }

    public static List<ProjetoMiniDto> toDto(List<Projeto> projetos) {
        return projetos == null ? null : projetos.stream().map(ProjetoMiniDto::new).toList();
    }
}
