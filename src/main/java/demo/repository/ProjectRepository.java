package demo.repository;

import demo.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Gonzalo on 17/06/2015.
 */
public interface ProjectRepository extends PagingAndSortingRepository<Project,Long> {

}
