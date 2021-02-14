package com.pedroarapua.cleanarchitecturejava.core.usecase.student;

import com.pedroarapua.cleanarchitecturejava.core.entity.student.Student;

public interface StudentAdapter {

  Student findByName(String name);
}
