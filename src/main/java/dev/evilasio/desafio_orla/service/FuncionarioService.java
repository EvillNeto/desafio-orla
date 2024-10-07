package dev.evilasio.desafio_orla.service;

import org.springframework.data.domain.Page;

import dev.evilasio.desafio_orla.model.entity.Funcionario;
import dev.evilasio.desafio_orla.model.form.CriarFuncionarioForm;

public interface FuncionarioService {
    
    public Funcionario criarFuncionario(CriarFuncionarioForm form);

    public Page<Funcionario> buscarFuncionarios();
}
