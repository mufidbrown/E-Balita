package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.ERole;
import com.magang.plnicon.entity.Role;
import com.magang.plnicon.repository.RoleRepository;
import com.magang.plnicon.service.IRoleService;
//import com.refreshtokenjwt.app.modal.ERole;
//import com.refreshtokenjwt.app.modal.Role;
//import com.refreshtokenjwt.app.repository.RoleRepository;
//import com.refreshtokenjwt.app.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class RoleService implements IRoleService {

    RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByName(ERole name) {
        return roleRepository.findByName(name);
    }

    public void saveRole(Role role){
        roleRepository.save(role);
    }

    public void saveRoles(Set<Role> roles){
        roleRepository.saveAll(roles);
    }
}
