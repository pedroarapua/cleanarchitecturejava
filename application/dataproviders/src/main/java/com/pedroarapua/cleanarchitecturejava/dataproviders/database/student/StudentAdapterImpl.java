package com.pedroarapua.cleanarchitecturejava.dataproviders.database.student;

import org.springframework.beans.factory.annotation.Autowired;

import com.pedroarapua.cleanarchitecturejava.core.entity.student.Student;
import com.pedroarapua.cleanarchitecturejava.core.usecase.student.StudentAdapter;
import com.pedroarapua.cleanarchitecturejava.dataproviders.database.student.mapper.StudentMapper;
import com.pedroarapua.cleanarchitecturejava.dataproviders.database.student.model.StudentModel;

public class StudentAdapterImpl implements StudentAdapter {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public Student findByName(String name) {
    StudentModel findByName = studentRepository.findByName(name);

    return StudentMapper.toEntity(findByName);
  }
}
