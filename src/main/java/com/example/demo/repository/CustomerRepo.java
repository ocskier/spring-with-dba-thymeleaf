package com.example.demo.repository;

import com.example.demo.models.Customer;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.Repository;
//import java.io.Serializable;

//interface BaseRepo<T, ID extends Serializable>
//        extends Repository<T, ID> {
//
//            <S extends T> S save(S entity);
//
//            T findOne(ID primaryKey);
//
//            Iterable<T> findAll();
//
//            Long count();
//
//            void delete(T entity);
//
//            boolean exists(ID primaryKey);
//
//            // … more functionality omitted.
//}

public interface CustomerRepo extends CrudRepository<Customer, Long> {

//    Customer findBySalary(int salary);
}


