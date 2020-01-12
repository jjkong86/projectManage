package task.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import task.model.Supporter;


public interface SupporterRepository extends JpaRepository<Supporter, UUID>{

}
