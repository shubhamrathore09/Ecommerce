package com.masai.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.repository.AdminRepo;
import com.masai.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public Admin AddAdmin(Admin admin) throws AdminException {
		Admin admin2=adminRepo.findByEmail(admin.getEmail());
		if(admin2==null) {
			Admin admin3=adminRepo.findByNumber(admin.getNumber());
			if(admin3==null) {
				return adminRepo.save(admin);
			}
			else {
				throw new AdminException("This number already ragistor");
			}
		}
		else {
			throw new AdminException("This email already exist");
		}
		
	}

	@Override
	public String changeAdminPassword(String oldp, String newp) throws AdminException {
		
		return null;
	}

}
