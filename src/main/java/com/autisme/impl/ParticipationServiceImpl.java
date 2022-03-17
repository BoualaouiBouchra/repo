package com.autisme.impl;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autisme.dao.*;
import com.autisme.modal.Participation;
import com.autisme.modal.ParticipationKey;
import com.autisme.service.*;

@Transactional
@Component
public class ParticipationServiceImpl implements ParticipationService {

	@Autowired
	private ParticipationDao pDao;
	
	@Override
	public Participation addParti(Participation p ,ParticipationKey pk) {
		if(pDao.findById(pk).isEmpty() )
			
		{ 
			pDao.save(p);
		return  pDao.save(p);}
		else {
		
			return null;
			}
		
		
	}

}
