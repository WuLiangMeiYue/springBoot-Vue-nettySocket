package com.test.repository;

import com.test.entity.Scrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScrapDao extends JpaRepository<Scrap,Long>{
    List<Scrap> getOneByScrapCreator(String creator);
}
