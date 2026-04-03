package ua.edu.duan.cat_shop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.duan.cat_shop.controller.dto.CatDto;
import ua.edu.duan.cat_shop.dao.entity.CatEntity;
import ua.edu.duan.cat_shop.dao.repository.CatRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CatController {


    private final CatRepository catRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/hello-world")
    public String sayHelloWorld() throws JsonProcessingException {


        List<CatEntity> catEntityList =  catRepository.findAll();

        return objectMapper.writeValueAsString(catEntityList);

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
