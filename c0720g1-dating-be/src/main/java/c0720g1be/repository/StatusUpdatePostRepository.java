package c0720g1be.repository;


import c0720g1be.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
@Transactional
public interface StatusUpdatePostRepository extends JpaRepository<Status,Integer> {

    /**
     * Võ Thành Tín
     * Get All Status
     *
     */
    @Query(value = "select * from status",nativeQuery = true)
    List<Status> getAllStatus();
}
