package task.repositories;

import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import task.model.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, UUID>{
	
	@Transactional(readOnly = true)
    @Cacheable("projects")
	Page<Project> findByIsOpenTrue(Pageable pr) throws DataAccessException;
}
