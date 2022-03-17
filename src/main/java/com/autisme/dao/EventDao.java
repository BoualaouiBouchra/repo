package com.autisme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.autisme.modal.*;

public interface EventDao  extends JpaRepository<Event, Long> {
    @Query("SELECT p FROM Event p WHERE p.title LIKE :n")
    List<Event> findByTitle(@Param("n") String title);
    
    @Query("SELECT e FROM Event e WHERE e.id_envent IN (SELECT  p.pPK.event.id_envent FROM User u , Participation p  WHERE p.pPK.user.id= u.id)")
    List<Event> findEventParticipationForUser(@Param("id") long idUser);
}