package ua.edu.duan.cat_shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.duan.cat_shop.controller.dto.CatDto;

@RestController
@RequestMapping("/api")
public class CatController {

    @GetMapping("/hello-world")
    public String sayHelloWorld(){
        return "Hello World - advanced logic";
    }

    @GetMapping("/say-world")
    public String sayWord(@RequestParam String world){
        return "Yes? of course - " + world;
    }

    @GetMapping("/say-world2/{world}/v1")
    public String sayWord2(@PathVariable String world){
        return "Yes? of course - " + world;
    }

    @PostMapping("/cat")
    public String addCat(@RequestBody CatDto catDto) {

        return catDto.getName() + " is added to the database";

    }
}
