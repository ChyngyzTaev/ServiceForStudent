package it.academy.demo.rapository;

import it.academy.demo.entity.Student;
import it.academy.demo.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(" ")
    Student findByName(@Param("name") String name);

    StudentModel getLessonByName(String name);
}
