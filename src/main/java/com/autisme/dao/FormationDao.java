package com.autisme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.autisme.modal.Formation;


public interface FormationDao extends JpaRepository<Formation, Long>{

	@Query("SELECT p FROM Formation p WHERE p.etat = :etat ")
    List<Formation> findByetat(@Param("etat") int etat);
}

