package ua.edu.duan.cat_shop.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cat")
public class CatEntity {

    @Id
    private String id;

    @Column(name = "name")
    private String catName;

    private String weight;

    private String type;

}
