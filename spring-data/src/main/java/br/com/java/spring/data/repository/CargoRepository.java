package br.com.java.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.java.spring.data.model.Cargo;

public interface CargoRepository extends CrudRepository<Cargo, Integer> {

}
