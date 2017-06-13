package com.proiect.tw.repository;

import com.proiect.tw.model.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by JACK on 6/13/2017.
 */
public interface RankingRepository extends JpaRepository<Ranking, Integer> {

    @Query("select r from Ranking r where r.teacher_id = ?1")
    Ranking findByTeacherid(Integer teacher_id);

    @Query("select r from Ranking r where r.teacher_id = ?1 and r.id_user = ?2")
    Ranking getIdByUser(Integer teacher_id, String id_user);

    @Query("select count(r.id) from Ranking r where r.teacher_id = ?1")
    Integer getTotalRating(Integer teacher_id);

    @Query("select sum(r.grade) from Ranking r where r.teacher_id in (?1)")
    Integer getSumRating(Integer teacher_id);

    @Query("select r from Ranking r where r.id_user = ?1")
    Ranking findByIdUser(String id);
}
