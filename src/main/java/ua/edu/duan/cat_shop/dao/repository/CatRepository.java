package ua.edu.duan.cat_shop.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.duan.cat_shop.dao.entity.CatEntity;

import java.util.List;

public interface CatRepository extends JpaRepository<CatEntity, String> {

    List<CatEntity> findByCatName(String name);

}
