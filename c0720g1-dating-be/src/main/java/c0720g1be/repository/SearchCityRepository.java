package c0720g1be.repository;

import c0720g1be.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchCityRepository extends JpaRepository<City, Integer> {

    /**
     * KhoaTA
     * Get list of all cities
     */
    @Query (value = "select id, name from city", nativeQuery = true)
    List<City> getCityList();
}
