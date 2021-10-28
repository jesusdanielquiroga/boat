/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.service;

import com.boat.model.Admin;
import com.boat.repository.AdminRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jquiroga
 */
@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepository;

    public List<Admin> getAll() {
        return (List<Admin>) adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int idAdmin) {
        return adminRepository.getAdmin(idAdmin);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> evt = adminRepository.getAdmin(admin.getIdAdmin());
            if (evt.isEmpty()) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }

    public boolean deleteAdmin(int id) {
        Optional<Admin> admin = adminRepository.getAdmin(id);
        if (admin.isEmpty()) {
            return false;
        } else {
            adminRepository.delete(admin.get());
            return true;
        }
    }

    public Admin updateAdmin(Admin admin) {
        if (admin.getIdAdmin() != null) {
            Optional<Admin> user = adminRepository.getAdmin(admin.getIdAdmin());

            if (!user.isEmpty()) {
                if (admin.getName() != null) {
                    user.get().setName(admin.getName());
                }
                if (admin.getEmail() != null) {
                    user.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null) {
                    user.get().setPassword(admin.getPassword());
                }

                return adminRepository.save(user.get());
            } else {
                return admin;
            }
        }
        return admin;
    }

}
