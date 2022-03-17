package com.autisme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autisme.dao.FormationDao;
import com.autisme.modal.*;
import com.autisme.modal.Formation;
import com.autisme.service.FormationService;


@RestController
@RequestMapping(value = "/api/public")
@CrossOrigin(origins = "http://localhost:4200/")
public class FormationController {
	
	@Autowired
	private FormationService formationService;

	@PostMapping("/addFormationToFormateur/{idFormateur}")
	Formation addFormationToFormateur(@RequestBody Formation formation, @PathVariable long idFormateur) {
		return formationService.addFormationToFormateur(formation, idFormateur);
	}

	@PutMapping("/editFormation/{id}")
	Formation editFormation(@RequestBody Formation formation, @PathVariable long id) {
		 return formationService.editFormation(formation, id);
	}
	
	@GetMapping("/findFormationById/{id}")
	Formation findFormationById(@PathVariable long id) {
		System.out.println(id+"hada");
		return formationService.findFormationById(id);
	}

	@DeleteMapping("/deleteFormation/{id}")
	void deleteFormation(@PathVariable long id) {
		formationService.deleteFormation(id);
	}
 
	@GetMapping("/findAllFormations")
	List<Formation> findAllFormations() {
		return formationService.findAllFormations();
	}

	@GetMapping("/findAllFormationsByEtat/{etat}")
	List<Formation> findAllFormationsByetat(@PathVariable int etat) {
	
		return formationService.findAllFormationsByEtat(etat);
	}
	
	@GetMapping("/findFormateurofFormation/{idFormation}")
	User findFormateurofFormation(@PathVariable long idFormation) {
	
		return formationService.findFormateurforFormation(idFormation);
	}
	@GetMapping("/findFormationsForFormateur/{idFormateur}")
	List<Formation> findFormationsForFormateur(@PathVariable long idFormateur) {
		return formationService.findFormationsForFormateur(idFormateur);
	}
	
}

