package rboard.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import rboard.entity.RNumber;

@Repository
public interface RNumberRepository extends ReactiveCrudRepository<RNumber, Long> {

}
