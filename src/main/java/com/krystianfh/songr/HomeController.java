package com.krystianfh.songr;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/greeting/{to}")
    public String sayHello(
            Model mPotato,
            String person,
            Integer lastSeen,
            String message,
            @PathVariable String to
            ){
        System.out.println("To :" + to);
        System.out.println(String.format("Message from %s : its been %d days since I saw you, %s", person, lastSeen, message));

        mPotato.addAttribute("person", person);
        mPotato.addAttribute("daysSinceISawYou", lastSeen);
        mPotato.addAttribute("message", message);

        return "hello";
    }
}
