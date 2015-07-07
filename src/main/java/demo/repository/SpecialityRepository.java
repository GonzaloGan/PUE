package demo.repository;

import demo.model.Speciality;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Gonzalo on 25/06/2015.
 */
public interface SpecialityRepository extends PagingAndSortingRepository<Speciality,Long> {
    List<Speciality> findByName(@Param("name") String name);
}
