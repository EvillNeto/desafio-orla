package dev.evilasio.desafio_orla.service.funcionario;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import dev.evilasio.desafio_orla.model.entity.Funcionario;
import dev.evilasio.desafio_orla.model.form.CriarFuncionarioForm;
import dev.evilasio.desafio_orla.repository.FuncionarioRepository;

@ExtendWith(MockitoExtension.class)
class FuncionarioServiceImplTest {

    @Mock
    private FuncionarioRepository repository;

    private FuncionarioServiceImpl underTest;

    @BeforeEach
    void setup(){
        underTest= new FuncionarioServiceImpl(repository);
    }

    private Page<Funcionario> getPage(){
        List<Funcionario>list = new ArrayList<>();
        Funcionario funcionario = Funcionario.builder().build();
        list.add(funcionario);
        return new PageImpl<>(list);
    }

    @Test
    void testBuscarFuncionarios(){
        // given
        Pageable pageable = Pageable.ofSize(1);
        // when
        Mockito.doReturn(getPage()).when(repository).findAll(any(Pageable.class));
        underTest.buscarFuncionarios(pageable);
        // then
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void shouldCallSave(){
        // give
        CriarFuncionarioForm form = CriarFuncionarioForm.builder().build();
        // when
        Mockito.doReturn(Optional.empty()).when(repository).findByCpf(any());
        underTest.criarFuncionario(form);
        // then
        verify(repository).save(any());
    }

    @Test
    void shouldThrowBeforeSave(){
         // give
         CriarFuncionarioForm form = CriarFuncionarioForm.builder().build();
         // when
         Mockito.doReturn(Optional.of(Funcionario.builder().build())).when(repository).findByCpf(any());
        // then
        assertThatThrownBy(() -> underTest.criarFuncionario(form)).hasMessageContaining("Funcionario ja cadastrado com esse cpf");
    }

    @Test
    void shouldThrowNotFindingById(){
        // when
        Mockito.doReturn(Optional.empty()).when(repository).findById(anyLong());
        // then
        assertThatThrownBy(() -> underTest.buscarFuncionario(anyLong())).hasMessageContaining("Funcionario não encontrado");
    }
}
