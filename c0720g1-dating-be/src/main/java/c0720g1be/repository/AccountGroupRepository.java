package c0720g1be.repository;

import c0720g1be.entity.AccountGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AccountGroupRepository extends JpaRepository<AccountGroup, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into account_group(account_id,group_id,group_role_id)\n" +
            "value(?1, ?2, ?3);", nativeQuery = true)
    void joinGroup(Integer account_id, Integer group_id, Integer group_role_id);
}
