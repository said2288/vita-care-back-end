package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.entity.PregnancyBirthEntity;

/**
 *
 * @author mohamad
 */

@Repository
public interface PregnancyBirthRepository extends JpaRepository<PregnancyBirthEntity, Long> {

}
