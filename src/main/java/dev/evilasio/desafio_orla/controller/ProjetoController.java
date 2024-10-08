package dev.evilasio.desafio_orla.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.evilasio.desafio_orla.model.dto.ProjetoDto;
import dev.evilasio.desafio_orla.model.form.CriarProjetoForm;
import dev.evilasio.desafio_orla.service.projeto.ProjetoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projeto")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<Page<ProjetoDto>> buscarProjetos(
            @ParameterObject @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.ok(ProjetoDto.toDto(projetoService.buscarProjetos(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDto> getMethodName(@PathVariable Long id) {
        return ResponseEntity.ok(ProjetoDto.toDto(projetoService.buscarProjeto(id)));
    }

    @PostMapping
    public ResponseEntity<ProjetoDto> criarProjeto(@RequestBody CriarProjetoForm form) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProjetoDto.toDto(projetoService.criarProjeto(form)));
    }
}
