package com.ak.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ak.entity.StudentEntity;

@Component
public interface StudentRepo extends CrudRepository<StudentEntity, Integer> {

}
