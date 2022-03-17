package com.autisme.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.autisme.dao.*;
import com.autisme.modal.*;
import com.autisme.modal.Formation;
import com.autisme.service.FormationService;

@Transactional
@Component
public class FormationServiceImpl implements FormationService {

	@Autowired
	private FormationDao formationDao;

	@Autowired
	private UserDao formateurDao;


	@Override
	public Formation addFormationToFormateur(Formation formation, long idFormateur) {
		User formateur = formateurDao.findById(idFormateur).orElse(null);
		formateur.addFormationToFormateur(formation);
		return formationDao.save(formation);
	}



	

	@Override
	public Formation findFormationById(long id) {
		return formationDao.findById(id).orElse(null);
	}

	@Override
	public void deleteFormation(long id) {
		formationDao.deleteById(id);
	}

	@Override
	public List<Formation> findAllFormations() {
		
		return formationDao.findAll();
	}

	@Override
	public List<Formation> findFormationsForFormateur(long idCategory) {
		User category = formateurDao.findById(idCategory).orElse(null);
		return category.getFormation();
	}





	@Override
	public Formation editFormation(Formation formation, long id) {
		Formation formationExist=formationDao.findById(id).orElse(null);
		if(formationExist!=null) {
			formationExist.setEtat(formation.getEtat());
			formationExist.setDate(formation.getDate());
			formationExist.setDescription_arab(formation.getDescription_arab());
			formationExist.setTitre_arab(formation.getTitre_arab());
			formationExist.setTitre(formation.getTitre());
			formationExist.setDescription(formation.getDescription());
		}
		return formationDao.save(formationExist);
	}





	@Override
	public List<Formation> findAllFormationsByEtat(int etat) {
		
		return formationDao.findByetat(etat);
	}





	@Override
	public User findFormateurforFormation(long idformation) {
		
	
			Formation f=	formationDao.findById(idformation).orElse(null);
			if(f!=null)
				return f.getFormateur();
			else
				return null;
	}

	

}

