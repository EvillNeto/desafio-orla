package dev.evilasio.desafio_orla.service.projeto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.evilasio.desafio_orla.exception.StandardException;
import dev.evilasio.desafio_orla.model.entity.Funcionario;
import dev.evilasio.desafio_orla.model.entity.Projeto;
import dev.evilasio.desafio_orla.model.form.CriarProjetoForm;
import dev.evilasio.desafio_orla.repository.FuncionarioRepository;
import dev.evilasio.desafio_orla.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoServiceImpl implements ProjetoService {

    private final ProjetoRepository projetoRepository;

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public Projeto criarProjeto(CriarProjetoForm form) {

        List<Funcionario> funcionarios = form.getIdFuncionarios().stream().map(this::getFuncionario).toList();

        return projetoRepository.save(Projeto.builder()
                .nome(form.getNome())
                .funcionarios(funcionarios)
                .build());
    }

    @Override
    public Page<Projeto> buscarProjetos(Pageable pageable) {
        return projetoRepository.findAll(pageable);
    }

    private Funcionario getFuncionario(Long idFuncionario) {
        return funcionarioRepository.findById(idFuncionario).orElseThrow(
                () -> new StandardException("FUNCIONARIO_NOT_FOUND","Funcionario não encontrado para o id:" + idFuncionario.toString(),HttpStatus.BAD_REQUEST));
    }

    @Override
    public Projeto buscarProjeto(Long id) {
        return projetoRepository.findById(id).orElseThrow(()->new StandardException("PROJETO_NOT_FOUND","Projeto não encontrado",HttpStatus.BAD_REQUEST));
    }
}
