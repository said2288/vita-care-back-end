package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import backend.entity.PersonalDataEntity;

/**
 *
 * @author mohamad
 */

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalDataEntity, Long> {

    public List<PersonalDataEntity> findAllByOrderByChildsNameAsc();

    @Query("SELECT COUNT(p) > 0 FROM PersonalDataEntity p WHERE p.childsName = :childsName")
    public boolean existsByName(@Param("childsName") String childsName);
}
