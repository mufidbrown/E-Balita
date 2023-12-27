package com.magang.plnicon.service;

import com.magang.plnicon.entity.ERole;
import com.magang.plnicon.entity.Role;


import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(ERole name);
}
