package com.pedroarapua.cleanarchitecturejava.entrypoints.rest.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedroarapua.cleanarchitecturejava.core.entity.student.Student;
import com.pedroarapua.cleanarchitecturejava.core.usecase.student.FindStudentByNameUseCase;
import com.pedroarapua.cleanarchitecturejava.entrypoints.rest.student.dto.StudentDto;
import com.pedroarapua.cleanarchitecturejava.entrypoints.rest.student.mapper.StudentMapper;

@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private FindStudentByNameUseCase findStudentByNameUseCase;

  @GetMapping("/find")
  public ResponseEntity<StudentDto> findByName(@RequestParam String name) {
    Student student = findStudentByNameUseCase.find(name);

    return new ResponseEntity<>(StudentMapper.toDto(student), HttpStatus.OK);
  }

}
