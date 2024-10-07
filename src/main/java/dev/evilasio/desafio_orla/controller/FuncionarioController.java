package dev.evilasio.desafio_orla.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.evilasio.desafio_orla.model.dto.FuncionarioDto;
import dev.evilasio.desafio_orla.model.form.CriarFuncionarioForm;
import dev.evilasio.desafio_orla.service.FuncionarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<Page<FuncionarioDto>> buscarFuncionarios() {
        return ResponseEntity.ok(FuncionarioDto.toDto(funcionarioService.buscarFuncionarios()));
    }

    @PostMapping
    public ResponseEntity<FuncionarioDto> criarFuncionario(@RequestBody CriarFuncionarioForm form) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(FuncionarioDto.toDto(funcionarioService.criarFuncionario(form)));
    }

}
