package com.example.myproject.services;

import com.example.myproject.entities.admin;
import com.example.myproject.repositories.adminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class adminService {

    private final adminRepository adminRepository;

    public  adminService(adminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<admin> getAlladmin() {
        return adminRepository.findAll();
    }

    public Optional<admin> getadminiById(Long id) {
        return adminRepository.findById(id);
    }

    public admin createAdministratorProfile(admin admin) {
        return adminRepository.save(admin);
    }

    public admin updateAdministratorProfile(Long id, admin profileDetails) {
        return adminRepository.findById(id)
                .map(profile -> {
                    profile.setPhoto(profileDetails.getPhoto());
                    profile.setDepartment(profileDetails.getDepartment());
                    return adminRepository.save(profile);
                }).orElseThrow(() -> new RuntimeException("Administrator profile not found"));
    }

    public void deleteAdministratorProfile(Long id) {
        adminRepository.deleteById(id);
    }
}

