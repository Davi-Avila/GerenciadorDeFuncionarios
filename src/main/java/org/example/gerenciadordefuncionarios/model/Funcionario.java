package org.example.gerenciadordefuncionarios.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"email"}) })
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencha com um nome válido")
    private String nome;

    @NotBlank(message = "Preencha com um cargo válido")
    private String cargo;

    @Email(message = "Insira um email")
    @NotBlank(message = "Preencha com um email válido")
    private String email;

    @NotNull(message = "Preencha com um salário váilido")
    @Positive(message = "Insira um salário maior que 0")
    private Double salario;

    public Funcionario(){}
}
