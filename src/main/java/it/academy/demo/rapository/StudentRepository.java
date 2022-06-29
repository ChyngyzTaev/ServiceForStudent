package it.academy.demo.rapository;

import it.academy.demo.entity.Student;
import it.academy.demo.model.StudentModel;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(" ")
    Student findByName(@Param("id") String id);

    StudentModel getLessonById(String id);

    @Query(nativeQuery = true , value =
            "SELECT * FROM student t WHERE t.request_body = :requestBody AND t.ip = :ip")
    Log getByRequestBodyAndAndIp (@Param("requestBody") String requestBody, String ip);

}
