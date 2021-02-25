package c0720g1be.repository;

import c0720g1be.entity.UserGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroup,Integer> {

    Page<UserGroup> findAllByNameContaining(String name, Pageable pageable);
}
