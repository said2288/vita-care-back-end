package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.entity.UnfurlEntity;

/**
 *
 * @author mohamad
 */

@Repository
public interface UnfurlRepository extends JpaRepository<UnfurlEntity, Long> {

}
