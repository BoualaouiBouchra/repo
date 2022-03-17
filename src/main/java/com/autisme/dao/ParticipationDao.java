package com.autisme.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.autisme.modal.Participation;
import com.autisme.modal.ParticipationKey;


public interface ParticipationDao extends JpaRepository<Participation, ParticipationKey> {

	
}


