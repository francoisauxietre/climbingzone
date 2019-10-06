package repository;

import com.escalade.demo.domain.Climber;
import org.springframework.data.repository.CrudRepository;

public interface ClimberRepository extends CrudRepository<Climber, Long> {
    void deleteAll();
}

