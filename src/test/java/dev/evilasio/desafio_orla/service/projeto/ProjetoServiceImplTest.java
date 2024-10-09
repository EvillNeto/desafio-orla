package dev.evilasio.desafio_orla.service.projeto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import dev.evilasio.desafio_orla.model.entity.Projeto;
import dev.evilasio.desafio_orla.model.form.CriarProjetoForm;
import dev.evilasio.desafio_orla.repository.FuncionarioRepository;
import dev.evilasio.desafio_orla.repository.ProjetoRepository;

@ExtendWith(MockitoExtension.class)
class ProjetoServiceImplTest {

    @Mock
    private ProjetoRepository pRepository;

    @Mock
    private FuncionarioRepository fRepository;

    private ProjetoServiceImpl underTest;

    @BeforeEach
    void setup() {
        underTest = new ProjetoServiceImpl(pRepository, fRepository);
    }

    private Page<Projeto> getPage() {
        List<Projeto> list = new ArrayList<>();
        Projeto projeto = Projeto.builder().build();
        list.add(projeto);
        return new PageImpl<>(list);
    }

    @Test
    void testBuscarProjetos() {
        // given
        Pageable pageable = Pageable.ofSize(1);
        // when
        Mockito.doReturn(getPage()).when(pRepository).findAll(any(Pageable.class));
        underTest.buscarProjetos(pageable);
        // then
        verify(pRepository).findAll(any(Pageable.class));
    }

    @Test
    void shouldCallSave() {
        // give
        CriarProjetoForm form = CriarProjetoForm.builder().idFuncionarios(Set.of(1L, 2L, 3L)).build();
        // when
        Mockito.doReturn(Optional.of(Funcionario.builder().build())).when(fRepository).findById(anyLong());
        underTest.criarProjeto(form);
        // then
        verify(fRepository, times(3)).findById(anyLong());
        verify(pRepository).save(any());
    }

    @Test
    void ShouldThrowNotFindingFuncionario() {
        // give
        CriarProjetoForm form = CriarProjetoForm.builder().idFuncionarios(Set.of(1L, 2L, 3L)).build();
        // when
        Mockito.doReturn(Optional.empty()).when(fRepository).findById(anyLong());
        // then
        assertThatThrownBy(() -> underTest.criarProjeto(form))
                .hasMessageContaining("Funcionario não encontrado para o id:");
    }

    @Test
    void ShoudFindProject() {
        // when
        Mockito.doReturn(Optional.of(Projeto.builder().build())).when(pRepository).findById(1L);
        underTest.buscarProjeto(1L);
        // then
        verify(pRepository).findById(1L);

    }

    @Test
    void ShouldThrowNotFindingProjeto() {
        // when
        Mockito.doReturn(Optional.empty()).when(pRepository).findById(1L);
        // then
        assertThatThrownBy(() -> underTest.buscarProjeto(1L))
                .hasMessageContaining("Projeto não encontrado");

    }

}
