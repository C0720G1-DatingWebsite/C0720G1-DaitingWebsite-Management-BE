package c0720g1be.service.impl;

import c0720g1be.entity.UserGroup;
import c0720g1be.repository.UserGroupRepository;
import c0720g1be.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserGroupImpl implements UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Override
    public Page<UserGroup> findAll(Pageable pageable) {
        return this.userGroupRepository.findAll(pageable);
    }

    @Override
    public UserGroup findGroupById(Integer id) {
        return this.userGroupRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteGroup(Integer id) {
        this.userGroupRepository.deleteById(id);
    }

    @Override
    public Page<UserGroup> findByNameContaining(String name, Pageable pageable) {
        return this.userGroupRepository.findAllByNameContaining(name, pageable);
    }
}
