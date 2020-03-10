package com.app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ManagementUserDaoImpl implements IManagementUser {

	@Override
	public Boolean validateUser(String username, String password) {

		return null;
	}

}
