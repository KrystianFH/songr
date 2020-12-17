package com.krystianfh.songr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    public AlbumRepository albumRepository;

    @PostMapping("/albums")
    public RedirectView addAlbum(long id, String title, String author, int songCount, int length, String imageUrl){
        Album newAlbum = new Album(
                id,
                title,
                author,
                songCount,
                length,
                imageUrl
        );

        albumRepository.save(newAlbum);
        return new RedirectView("/albums");

    }

    @GetMapping("/albums")
    public String showAlbums(Model m){

        Album album1 = new Album(
                546454,
                "some name",
                "some artist",
                19,
                600,
                "http://www.someurl.com"
        );

        this.albumRepository.save(album1);

        Album album2 = new Album(
                64564687,
                "some other name",
                "some other artist",
                14,
                400,
                "http://www.someotherurl.com"
        );

        this.albumRepository.save(album2);


        Album album3 = new Album(
                564687,
                "another title",
                "another artist",
                18,
                741,
                "http://www.anotherurl.com"
        );

        this.albumRepository.save(album3);

        Iterable <Album> albums = this.albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "albums";
    }

    @PostMapping("/{id}")
    public Album updateAlbum (@PathVariable Long id, @PathVariable Album album){
        Optional<Album> repoAlbum = this.albumRepository.findById(id);
        if(repoAlbum.isPresent()){
            Album editedAlbum = repoAlbum.get();
            editedAlbum.setTitle(album.getTitle());
            editedAlbum.setArtist(album.getArtist());
            editedAlbum.setSongCount(album.getSongCount());
            editedAlbum.setLength(album.getLength());
            editedAlbum.setImageUrl(album.getImageUrl());

            albumRepository.save(editedAlbum);
            return editedAlbum;
        }
        throw new AlbumNotFoundException();
    }



}
