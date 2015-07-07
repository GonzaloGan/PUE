package demo.repository;

import demo.model.Review;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Gonzalo on 06/07/2015.
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {
    Review findByProjectIdAndSpecialityIdAndDeveloperId(@Param("idProject")Long idProject,
                                                       @Param("idSpeciality")Long idSpeciality,
                                                             @Param("idDeveloper")Long idDeveloper );
}
