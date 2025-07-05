package  com.example.project.auth.repository;

import com.example.project.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRepository extends JpaRepository<User ,Long>
{
	Optional<User> findByUsername(String name);
	boolean existsByUsername(String username); 
}