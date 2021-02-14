package com.pedroarapua.cleanarchitecturejava.core.usecase.student;

import com.pedroarapua.cleanarchitecturejava.core.entity.student.Student;
import com.pedroarapua.cleanarchitecturejava.core.usecase.student.StudentAdapter;

public class FindStudentByNameUseCase {

  private StudentAdapter adapter;

  public FindStudentByNameUseCase(StudentAdapter adapter) {
    this.adapter = adapter;
  }

  public Student find(String name) {
    return adapter.findByName(name);
  }

}