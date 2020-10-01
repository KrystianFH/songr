package com.krystianfh.songr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class AlbumController {

    @Autowired
    public AlbumRepository albumRepository;

    @PostMapping("/album")
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
//        ArrayList<Album> albums = (ArrayList<Album>) albumRepository.findAll();
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album(
                546454,
                "some name",
                "some artist",
                19,
                600,
                "http://www.someurl.com"
        ));
        albums.add(new Album(
                64564687,
                "some other name",
                "some other artist",
                14,
                400,
                "http://www.someotherurl.com"
        ));
        albums.add(new Album(
                564687,
                "another title",
                "another artist",
                18,
                741,
                "http://www.anotherurl.com"
        ));

        m.addAttribute("title", albums);
        return "title";
    }


}
