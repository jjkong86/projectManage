package task.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import task.model.User;


public interface UserRepository extends JpaRepository<User, UUID>{
	User findByName(String name);
}
