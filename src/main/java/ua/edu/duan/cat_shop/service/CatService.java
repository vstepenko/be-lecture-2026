package ua.edu.duan.cat_shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.duan.cat_shop.controller.dto.CatDto;
import ua.edu.duan.cat_shop.dao.entity.CatEntity;
import ua.edu.duan.cat_shop.dao.repository.CatRepository;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;

    public List<CatDto> getAllCats(){
        List<CatEntity> catEntityList =  catRepository.findAll();
        /*
        List<CatDto> catDtoList = new ArrayList<>();
        for(CatEntity catEntity : catEntityList){
            CatDto dto = toCatDto(catEntity);
            catDtoList.add(dto);
        }
        return catDtoList;
        */

        return catEntityList.stream().map(this::toCatDto).toList();
    }


    public void addCat(CatDto catDto) {
        CatEntity catEntity = toCatEntity(catDto);
        catRepository.save(catEntity);
    }

    private CatDto toCatDto(CatEntity catEntity) {
        CatDto catDto = new CatDto();
        catDto.setId(catEntity.getId());
        catDto.setName(catEntity.getCatName());
        return catDto;
    }

    private CatEntity toCatEntity(CatDto catDto) {
        CatEntity catEntity = new CatEntity();
        catEntity.setId(UUID.randomUUID().toString());
        catEntity.setCatName(catDto.getName());
        catEntity.setType("unknown");
        catEntity.setWeight("unknown");
        return catEntity;
    }
}
