package com.olgafranco.app.controller;

import com.olgafranco.app.model.Privilege;
import com.olgafranco.app.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/privileges")
public class PrivilegeController {

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @GetMapping
    public Iterable<Privilege> getAllPrivileges() {
        return privilegeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Privilege> getPrivilegeById(@PathVariable Long id) {
        return privilegeRepository.findById(id);
    }

    @PostMapping
    public Privilege createPrivilege(@RequestBody Privilege privilege) {
        return privilegeRepository.save(privilege);
    }

    @PutMapping("/{id}")
    public Privilege updatePrivilege(@PathVariable Long id, @RequestBody Privilege privilege) {
        privilege.setId(id);
        return privilegeRepository.save(privilege);
    }

    @DeleteMapping("/{id}")
    public void deletePrivilege(@PathVariable Long id) {
        privilegeRepository.deleteById(id);
    }
}