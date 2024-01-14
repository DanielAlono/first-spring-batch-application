package com.batch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.batch.entities.Person;
import com.batch.persistence.IPersonDAO;

@Service
public class PersonServiceImpl implements IPersonService{

    @Autowired
    private IPersonDAO personDAO;

    @Override
    @Transactional
    public void saveAll(List<Person> personList) {
        personDAO.saveAll(personList);
    }

}
