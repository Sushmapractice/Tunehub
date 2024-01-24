package com.example.demo.respositories;
import com.example.demo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	public Users findByEmail(String email);

}
