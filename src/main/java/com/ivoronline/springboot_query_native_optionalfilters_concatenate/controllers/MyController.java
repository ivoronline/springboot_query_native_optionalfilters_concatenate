package com.ivoronline.springboot_query_native_optionalfilters_concatenate.controllers;

import com.ivoronline.springboot_query_native_optionalfilters_concatenate.entities.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RestController
public class MyController {

  //PROPERTIES
  @PersistenceContext EntityManager entityManager;

  //================================================================
  // GET PERSONS
  //================================================================
  @RequestMapping("GetPersons")
  List<Person> getPersons(@RequestParam(required=false) String name) {

    //CONDITIONAL NAME FILTER
    String nameFilter = " ";
    if(name != null) { nameFilter = " WHERE name = '" + name + "'"; }

    //CREATE QUERY
    String select = "SELECT * FROM PERSON " + nameFilter;
    Query  query  = entityManager.createNativeQuery(select, Person.class);

    //SELECT PERSON
    List<Person> persons = (List<Person>) query.getResultList();

    //RETURN RESULTS
    return persons;

  }

}