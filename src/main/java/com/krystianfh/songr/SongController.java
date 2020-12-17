package com.krystianfh.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    public SongRepository songRepository;

    @Autowired
    public AlbumRepository albumRepository;

    @GetMapping("/create")
    public void createSongs(Model m){

        Optional<Album> foundAlbum = albumRepository.findById(1L);

        if(foundAlbum.isPresent()){
            Album album = foundAlbum.get();

            Song song1 = new Song(
                    "a song title",
                    56,
                    8,
                    album
            );

            this.songRepository.save(song1);

            Song song2 = new Song(
                    "another song title",
                    41,
                    7,
                    album
            );

            this.songRepository.save(song2);

        }
    }

    @GetMapping("/")
    public String showAllSongs(Model m){
        List<Song> songList = songRepository.findAll();
        m.addAttribute("songs", songList);
        return "songs";
    }
}
