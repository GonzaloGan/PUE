package demo.service;

import demo.repository.DeveloperRepository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gonzalo on 02/07/2015.
 */
@Service
public class ReviewService {

	@Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DeveloperRepository developerRepository;
}
