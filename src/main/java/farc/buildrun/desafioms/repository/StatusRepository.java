package farc.buildrun.desafioms.repository;

import farc.buildrun.desafioms.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
