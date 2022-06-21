package it.academy.demo.rapository;

import it.academy.demo.entity.Curator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuratorRepository extends JpaRepository<Curator, Long> {

}
