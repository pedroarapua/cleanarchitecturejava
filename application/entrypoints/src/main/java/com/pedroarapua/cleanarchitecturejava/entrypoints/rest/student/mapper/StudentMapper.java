package com.pedroarapua.cleanarchitecturejava.entrypoints.rest.student.mapper;

import com.pedroarapua.cleanarchitecturejava.core.entity.student.Student;
import com.pedroarapua.cleanarchitecturejava.entrypoints.rest.student.dto.StudentDto;

public class StudentMapper {

  public static StudentDto toDto(Student entity) {
    if (entity == null) {
      return null;
    }

        StudentDto studentDto = new StudentDto();
        studentDto.setName(entity.getName());
        studentDto.setAge(entity.getAge());

        return studentDto;
    }
}
