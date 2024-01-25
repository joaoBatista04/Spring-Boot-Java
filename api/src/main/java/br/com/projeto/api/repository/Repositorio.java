package br.com.projeto.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.models.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer>{
    @Override
    List<Pessoa> findAll(); 

    Pessoa findByCodigo(int codigo);

    List<Pessoa> findByNome(String nome);

    //findByOrderByAsc - Ascendente
    //findByOrderByDesc - Descendente
    List<Pessoa> findByOrderByNome();

    List<Pessoa> findByNomeOrderByIdade(String nome);

    List<Pessoa> findByNomeContaining(String termo);

    List<Pessoa> findByNomeStartsWith(String termo);

    List<Pessoa> findByNomeEndsWith(String termo);
}
