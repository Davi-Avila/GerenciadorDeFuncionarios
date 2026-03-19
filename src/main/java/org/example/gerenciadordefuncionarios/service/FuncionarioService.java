package org.example.gerenciadordefuncionarios.service;

import org.example.gerenciadordefuncionarios.model.Funcionario;
import org.example.gerenciadordefuncionarios.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario salvar(Funcionario funcionario){
        if (repository.existsByEmail(funcionario.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        return repository.save(funcionario);
    }

    public Funcionario buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
    }

    public List<Funcionario> listar(){
        return repository.findAll();
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public List<Funcionario> buscarPorNome(String nome){
        return repository.findByNomeContainingIgnoreCase(nome);

    }

    public List<Funcionario> buscarPorSalario(Double salario){
        return repository.findBySalarioGreaterThan(salario);

    }



}
