package demo.repository;

import demo.model.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Gonzalo on 17/06/2015.
 */
public interface ManagerRepository extends PagingAndSortingRepository<Manager,Long> {
    List<Manager> findBySurname(@Param("surname") String surname );

//    List<Manager> findBybonusSuccess(@Param("bonusSuccess") Double bonusSuccess );
}
