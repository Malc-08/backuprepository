package com.olgafranco.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olgafranco.app.model.Privilege;
import com.olgafranco.app.repository.PrivilegeRepository;

@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeRepository privilegeRepository;
    
    public List<Privilege> findAll() {
        return privilegeRepository.findAll();
    }
    
    public Optional<Privilege> findById(Long id) {
        return privilegeRepository.findById(id);
    }
    
    public Privilege save(Privilege privilege) {
        return privilegeRepository.save(privilege);
    }
    
    public void deleteById(Long id) {
        privilegeRepository.deleteById(id);
    }
}
