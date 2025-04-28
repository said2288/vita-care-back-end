package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.entity.DevelopmentDataEntity;

/**
 *
 * @author mohamad
 */

@Repository
public interface DevelopmentDataRepository extends JpaRepository<DevelopmentDataEntity, Long> {

}
