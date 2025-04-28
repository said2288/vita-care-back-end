package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.entity.FoodEntity;

/**
 *
 * @author mohamad
 */

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

}
