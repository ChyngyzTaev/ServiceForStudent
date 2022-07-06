package it.academy.demo.rapository;

import it.academy.demo.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateLessonRepository extends JpaRepository<Lesson, Long> {
}
