package it.academy.demo.rapository;

import it.academy.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Post, Long> {

}
