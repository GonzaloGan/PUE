package demo.repository;

import demo.model.Review;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by poo2 on 06/07/2015.
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {
  //  public List<Review> findByProjectIdAndSpecialityId(@Param())
}
