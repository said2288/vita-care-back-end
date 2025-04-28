package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.entity.DailyLivingActivitiesEntity;

/**
 *
 * @author mohamad
 */

@Repository
public interface DailyLivingActivitiesRepository extends JpaRepository<DailyLivingActivitiesEntity, Long> {

}
