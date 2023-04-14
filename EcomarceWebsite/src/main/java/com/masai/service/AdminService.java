package com.masai.service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;

public interface AdminService {
	public Admin AddAdmin(Admin admin)throws AdminException;
	public String changeAdminPassword(String oldp, String newp)throws AdminException;
	
}
