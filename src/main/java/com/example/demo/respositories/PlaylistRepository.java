package com.example.demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer>  {

	
	
}
