package c0720g1be.repository;

import c0720g1be.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoleRegisterRepository extends JpaRepository<Role, Integer> {
    /**
     * Nguyen Bao Phuc
     * @param accountId
     * @param roleId
     */

    @Modifying
    @Query(value = "insert into account_role(account_id, role_id) values(?1,?2)", nativeQuery = true)
    void setDefaultRole(Integer accountId, Integer roleId);
}
