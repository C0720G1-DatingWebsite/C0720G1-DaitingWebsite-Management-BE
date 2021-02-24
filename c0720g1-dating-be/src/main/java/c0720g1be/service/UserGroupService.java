package c0720g1be.service;

import c0720g1be.entity.UserGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface UserGroupService {

    Page<UserGroup> findAll(Pageable pageable);

    UserGroup findGroupById(Integer id);

    void deleteGroup(Integer id);

    Page<UserGroup> findByNameContaining(String name, Pageable pageable);

}
