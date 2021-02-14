package com.pedroarapua.cleanarchitecturejava.dataproviders.database.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedroarapua.cleanarchitecturejava.dataproviders.database.student.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    StudentModel findByName(String name);
}
