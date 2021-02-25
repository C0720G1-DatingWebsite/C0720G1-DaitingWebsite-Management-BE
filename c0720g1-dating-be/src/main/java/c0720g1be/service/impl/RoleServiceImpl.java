package c0720g1be.service.impl;

import c0720g1be.repository.RoleRepository;
import c0720g1be.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    /**
     * Nguyen Bao Phuc
     */

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void setDefaultRole(Integer accountId, Integer roleId) {
    roleRepository.setDefaultRole(accountId, roleId);
    }
}
