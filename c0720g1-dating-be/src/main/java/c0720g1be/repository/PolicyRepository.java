package c0720g1be.repository;


import c0720g1be.dto.IPolicyDTO;
import c0720g1be.entity.Policy;
import c0720g1be.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
@Transactional
public interface PolicyRepository extends JpaRepository<Status,Integer> {

    /**
     * Võ Thành Tín
     * Get All Policy
     *
     */
    @Query(value = "select policy.id as idPolicy, policy.name as namePolicy from policy",nativeQuery = true)
    List<IPolicyDTO> getAllPolicy();
}
