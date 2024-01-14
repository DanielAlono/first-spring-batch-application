package com.batch.service;

import java.util.List;

import com.batch.entities.Person;

public interface IPersonService {

    void saveAll(List<Person> personList);
}
