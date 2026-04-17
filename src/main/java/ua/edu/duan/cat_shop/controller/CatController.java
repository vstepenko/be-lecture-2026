package ua.edu.duan.cat_shop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.duan.cat_shop.controller.dto.CatDto;
import ua.edu.duan.cat_shop.service.CatService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping("/cats")
    public List<CatDto> getAllCats()  {
        return catService.getAllCats();
    }

    @GetMapping("/cat")
    public CatDto getCatById(@RequestParam String catId)  {
        return catService.getCatById(catId);
    }

    @GetMapping("/cat-by-type")
    public List<CatDto> getCatByType(@RequestParam String type)  {
        return catService.getCatByType(type);
    }

    @PostMapping("/cat")
    public void addCat(@RequestBody CatDto catDto) {
       catService.addCat(catDto);
    }

    @PutMapping("/cat")
    public String updateCat(@RequestParam(required = true) String catId, @RequestBody CatDto catDto) {
        return catService.editCat(catId, catDto);

    }

    @DeleteMapping("/cat")
    public String deleteCat(@RequestParam String catId) {
        return catService.deleteCat(catId);
    }
}
