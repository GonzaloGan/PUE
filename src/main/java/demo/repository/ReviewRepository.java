package demo.repository;

import demo.model.Review;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

/**
 * Created by Gonzalo on 06/07/2015.
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {
    List<Review> findByProjectIdAndSpecialityId(@Param("idProject")Long idProject,
                                                       @Param("idSpeciality")Long idSpeciality );
}
