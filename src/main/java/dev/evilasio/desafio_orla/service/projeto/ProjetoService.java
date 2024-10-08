package dev.evilasio.desafio_orla.service.projeto;


import org.springframework.data.domain.Page;

import dev.evilasio.desafio_orla.model.entity.Projeto;
import dev.evilasio.desafio_orla.model.form.CriarProjetoForm;

public interface ProjetoService {
    
    public Projeto criarProjeto(CriarProjetoForm form);

    public Page<Projeto> buscarProjetos();
}
