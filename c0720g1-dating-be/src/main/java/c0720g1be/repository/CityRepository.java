package c0720g1be.repository;

import c0720g1be.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
@Query(value = "SELECT * FROM dating_application.city ", nativeQuery = true)
    List<City> listCity();
}
