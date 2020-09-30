package com.krystianfh.songr;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AlbumController {

//    @Autowired
//    public EmotionRepository emotionRepository;
//
//    @PostMapping("/emotion")
//    public RedirectView addEmotion(String feeling, boolean causesUsToLaugh, String personHavingIt, int level, String reason){
//        Emotion newEmotion = newEmotion(
//                feeling,
//                causesUsToLaugh,
//                personHavingIt,
//                level,
//                reason
//        );
//
//        emotionRepository.save(newEmotion);
//        return new RedirectView("/emotions");
//
//    }

    @GetMapping("/emotions")
    public String showAlbums(Model m){
//        ArrayList<Album> albums = (ArrayList<Album>) albumRepository.findAll();
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album(
                "some name",
                "some artist",
                19,
                600,
                "http://www.someurl.com"
        ));
        albums.add(new Album(
                "some other name",
                "some other artist",
                14,
                400,
                "http://www.someotherurl.com"
        ));
        albums.add(new Album(
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
