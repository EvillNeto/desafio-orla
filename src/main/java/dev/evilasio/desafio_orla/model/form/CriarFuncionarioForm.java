package dev.evilasio.desafio_orla.model.form;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.br.CPF;

import dev.evilasio.desafio_orla.model.entity.Funcionario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriarFuncionarioForm {

    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private BigDecimal salario;

    public Funcionario toEntity() {
        return Funcionario.builder()
                .nome(this.nome)
                .cpf(this.cpf)
                .email(this.email)
                .salario(this.salario)
                .build();
    }
}
