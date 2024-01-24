package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entities.Song;

import com.example.demo.services.SongService;

@Controller
public class SongController {
	@Autowired
	SongService service;

	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		boolean songStatus = service.songExists(song.getName());
		if (songStatus == false) {
			service.addSong(song);
			System.out.println("song added successfully");
		} else {
			System.out.println("song already added");
		}

		return "adminhome";
	}

	@GetMapping("/viewSongs")
	public String viewSongs(Model model) {
		List<Song> songList = service.fetchAllSongs();
		model.addAttribute("songs", songList);
		System.out.println(songList);

		return "displaySongs";
	}

	@GetMapping("/playSong")
	public String playSong(Model model) {
		boolean premiumUser = false;
		if (premiumUser == true) {

			List<Song> songList = service.fetchAllSongs();
			model.addAttribute("songs", songList);
			System.out.println(songList);

			return "displaySong";
		} else {
			return "makepayment";
		}
	}
}
