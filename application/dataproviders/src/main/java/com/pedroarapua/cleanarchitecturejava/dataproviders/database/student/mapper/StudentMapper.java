package com.pedroarapua.cleanarchitecturejava.dataproviders.database.student.mapper;

import com.pedroarapua.cleanarchitecturejava.core.entity.student.Student;
import com.pedroarapua.cleanarchitecturejava.dataproviders.database.student.model.StudentModel;

public class StudentMapper {

  public static Student toEntity(StudentModel model) {
    if (model == null) {
      return null;
    }

    Student student = new Student();
    student.setName(model.getName());
    student.setAge(model.getAge());

    return student;
  }
}
