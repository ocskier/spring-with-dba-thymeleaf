package com.example.demo.repository;

import com.example.demo.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

    //    Customer findBySalary(int salary);

}

//interface CrudRepository<T, ID extends Serializable>
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


