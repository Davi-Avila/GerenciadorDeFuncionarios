package org.example.gerenciadordefuncionarios.repository;

import org.example.gerenciadordefuncionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findBySalarioGreaterThan(Double salario);
    List<Funcionario> findByNomeContainingIgnoreCase(String nome);
    boolean existsByEmail(String email);

}
