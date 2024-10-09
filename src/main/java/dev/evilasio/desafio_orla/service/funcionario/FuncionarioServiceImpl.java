package dev.evilasio.desafio_orla.service.funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.evilasio.desafio_orla.exception.StandardException;
import dev.evilasio.desafio_orla.model.entity.Funcionario;
import dev.evilasio.desafio_orla.model.form.CriarFuncionarioForm;
import dev.evilasio.desafio_orla.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl  implements FuncionarioService{

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario criarFuncionario(CriarFuncionarioForm form) {

        if(funcionarioRepository.findByCpf(form.getCpf()).isPresent()){
            throw new StandardException("FUNCIONARIO_EXISTS","Funcionario ja cadastrado com esse cpf",HttpStatus.BAD_REQUEST);
        }

        Funcionario funcionario = form.toEntity();

        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Page<Funcionario> buscarFuncionarios(Pageable pageable) {
        return funcionarioRepository.findAll(pageable);
    }

    @Override
    public Funcionario buscarFuncionario(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(()->new StandardException("FUNCIONARIO_NOT_FOUND","Funcionario não encontrado",HttpStatus.BAD_REQUEST));
    }
    
}
