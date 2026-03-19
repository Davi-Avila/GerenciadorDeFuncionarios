package org.example.gerenciadordefuncionarios.controller;


import jakarta.validation.Valid;
import org.example.gerenciadordefuncionarios.model.Funcionario;
import org.example.gerenciadordefuncionarios.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service){
        this.service = service;
    }

    @GetMapping
    public List<Funcionario> listar(){
        return service.listar();
    }

    @PostMapping
    public Funcionario criar(@RequestBody @Valid Funcionario funcionario){
        return service.salvar(funcionario);
    }

    @GetMapping("/{id}")
    public Funcionario buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario){
        funcionario.setId(id);
        return service.salvar(funcionario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @GetMapping("/buscarNome")
    public List<Funcionario> buscarPorNome(@RequestParam String nome){
        return service.buscarPorNome(nome);
    }

    @GetMapping("/buscarSalario")
    public List<Funcionario> buscarPorSalario(@RequestParam Double salario){
        return service.buscarPorSalario(salario);
    }

}
