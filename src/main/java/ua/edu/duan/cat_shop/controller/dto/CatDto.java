package ua.edu.duan.cat_shop.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;


    private String name;

}
