package com.krystianfh.songr;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class EmotionController {

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
    public String showEmotions(Model m){
//        ArrayList<Emotion> emotions = (ArrayList<Emotion>) emotionRepository.findAll();
        ArrayList<Emotion> emotions = new ArrayList<>();
        emotions.add(new Emotion(
                "chill",
                true,
                "Jack",
                2,
                "Cause I am learning"
        ));
        emotions.add(new Emotion(
                "Happy",
                false,
                "Matthew",
                9,
                "Wife just got home"
        ));
        emotions.add(new Emotion(
                "Satisfied",
                false,
                "Paul",
                7,
                "Not talking on phone anymore"
        ));

        m.addAttribute("feelings", emotions);
        return "feelings";
    }


}
