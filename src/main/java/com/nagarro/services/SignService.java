package com.nagarro.services;
/*
 * @Author Bhumika_Arora
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.HRManagerDao;
import com.nagarro.model.HRManager;

@Service
public class SignService {

	@Autowired
	private HRManagerDao hrDao;

	public boolean validateHRManager(final String username, final String password) {
		final HRManager obj = hrDao.getHRManager(username);
		return obj != null && obj.getPassword().equals(password);
	}
}
