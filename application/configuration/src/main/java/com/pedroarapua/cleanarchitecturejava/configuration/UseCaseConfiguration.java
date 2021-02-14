package com.pedroarapua.cleanarchitecturejava.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pedroarapua.cleanarchitecturejava.core.usecase.student.FindStudentByNameUseCase;
import com.pedroarapua.cleanarchitecturejava.core.usecase.student.StudentAdapter;
import com.pedroarapua.cleanarchitecturejava.dataproviders.database.student.StudentAdapterImpl;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public FindStudentByNameUseCase findStudentByNameUseCase(StudentAdapter studentAdapter) {
        return new FindStudentByNameUseCase(studentAdapter);
    }

    @Bean
    public StudentAdapter studentAdapter() {
        return new StudentAdapterImpl();
    }
}
