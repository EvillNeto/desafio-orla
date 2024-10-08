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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.evilasio.desafio_orla.model.dto.FuncionarioDto;
import dev.evilasio.desafio_orla.model.form.CriarFuncionarioForm;
import dev.evilasio.desafio_orla.service.funcionario.FuncionarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<Page<FuncionarioDto>> buscarFuncionarios(
            @ParameterObject @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.ok(FuncionarioDto.toDto(funcionarioService.buscarFuncionarios(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDto> getMethodName(@PathVariable Long id) {
        return ResponseEntity.ok(FuncionarioDto.toDto(funcionarioService.buscarFuncionario(id)));
    }

    @PostMapping
    public ResponseEntity<FuncionarioDto> criarFuncionario(@RequestBody CriarFuncionarioForm form) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(FuncionarioDto.toDto(funcionarioService.criarFuncionario(form)));
    }

}
