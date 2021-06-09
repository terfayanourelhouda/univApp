package dz.univbechar.univ.service.repository;

import org.springframework.data.repository.CrudRepository;

import dz.univbechar.univ.service.entity.Students;

public interface UnivRepository extends CrudRepository<Students	, String>{

}
