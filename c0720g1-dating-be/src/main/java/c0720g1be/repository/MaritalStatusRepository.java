package c0720g1be.repository;

import c0720g1be.entity.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public interface MaritalStatusRepository extends JpaRepository<MaritalStatus, Integer> {
    @Query(value = "SELECT * FROM dating_application.marital_status", nativeQuery = true)
    List<MaritalStatus> listMaritalStatus();
}
