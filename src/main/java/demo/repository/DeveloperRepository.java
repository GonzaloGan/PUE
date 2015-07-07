package demo.repository;

import demo.model.Category;
import demo.model.Developer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Gonzalo on 17/06/2015.
 */
public interface DeveloperRepository extends PagingAndSortingRepository<Developer,Long> {
        List<Developer> findBySurname(@Param("surname") String surname );
        List<Developer> findByDateIncorporationBetween(@Param("start") Date start,
                                                  @Param("end") Date end );

        List<Developer> findByCategory(@Param("category") Category category );


}
