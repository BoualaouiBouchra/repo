package com.autisme.service;

import java.util.List;

import com.autisme.modal.*;



public interface FormationService {
	
Formation addFormationToFormateur(Formation formation, long idFormateur);
	
	
	
	Formation findFormationById(long id);
	
	void deleteFormation(long id);
	
	List<Formation> findAllFormations();
	User findFormateurforFormation(long idformation);
	
	List<Formation> findFormationsForFormateur(long idFormateur);
	List<Formation>  findAllFormationsByEtat(int etat);


	Formation editFormation(Formation formation, long id);

	

	}



