package br.com.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.models.Pessoa;
import br.com.projeto.api.repository.Repositorio;

@RestController
public class Controller {

    @Autowired
    public Repositorio acao;

    @PostMapping("/cadastrar")
    public Pessoa cadastrarPessoa(@RequestBody Pessoa obj){
        return acao.save(obj);
    }
    
    @GetMapping("/pessoas")
    public List<Pessoa> getPessoas(){
        return acao.findAll();
    }

    @GetMapping("/pessoas/{codigo}")
    public Pessoa getPessoaById(@PathVariable int codigo){
        return acao.findByCodigo(codigo);
    }

    @GetMapping("/pessoa/{nome}")
    public List<Pessoa> getPessoaByNome(@PathVariable String nome){
        return acao.findByNome(nome);
    }

    @PutMapping("/update")
    public Pessoa updatePessoa(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    @DeleteMapping("/delete/{codigo}")
    public void deletePerson(@PathVariable int codigo){
        Pessoa obj = getPessoaById(codigo);

        acao.delete(obj);
    }

    @GetMapping("/api/contador")
    public long contador(){
        return acao.count();
    }

    @GetMapping("/api/ordenaByNome")
    public List<Pessoa> ordenaPessoasByNome(){
        return acao.findByOrderByNome();
    }

    @GetMapping("/api/ordenaByNome2")
    public List<Pessoa> ordenarNomesPorIdade(){
        return acao.findByNomeOrderByIdade("Anna");
    }

    @GetMapping("/api/containing")
    public List<Pessoa> getPessoasSeContemTermo(){
        return acao.findByNomeContaining("A");
    }

    @GetMapping("/api/startsWith")
    public List<Pessoa> getPessoasQueComecamComTermo(){
        return acao.findByNomeStartsWith("Jo");
    }

    @GetMapping("/api/endsWith")
    public List<Pessoa> getPessoasQueTerminamComTermo(){
        return acao.findByNomeEndsWith("o");
    }

    @GetMapping("")
    public String message(){
        return "Hello World!";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Be welcome!";
    }

    @GetMapping("/welcome/{nome}")
    public String welcome(@PathVariable String nome){
        return "Be welcome " + nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase() + "!";
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }
}
