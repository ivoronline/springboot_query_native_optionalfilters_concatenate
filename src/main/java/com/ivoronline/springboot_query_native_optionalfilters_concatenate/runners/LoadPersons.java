package com.ivoronline.springboot_query_native_optionalfilters_concatenate.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class LoadPersons implements CommandLineRunner {

  //PROPERTIES
  @PersistenceContext EntityManager entityManager;

  //================================================================
  // RUN
  //================================================================
  @Override
  @Transactional
  public void run(String... args) throws Exception {

    //CREATE QUERY
    String insert = "INSERT INTO PERSON (name, age) VALUES (:name, :age)";
    Query  query  = entityManager.createNativeQuery(insert);

    //INSERT JOHN
    query.setParameter("name", "John");
    query.setParameter("age" , 20);
    query.executeUpdate();

    //INSERT BILL
    query.setParameter("name", "Bill");
    query.setParameter("age" , 30);
    query.executeUpdate();

  }

}
