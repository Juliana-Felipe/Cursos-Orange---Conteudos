package br.com.alura.springdata.repository;

import br.com.alura.springdata.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Scanner;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {
}
