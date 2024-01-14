package com.batch.persistence;

import org.springframework.data.repository.CrudRepository;

import com.batch.entities.Person;

public interface IPersonDAO extends CrudRepository<Person, Long>{

}
