package c0720g1be.repository;

import c0720g1be.entity.City;
import c0720g1be.entity.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchHobbiesRepository extends JpaRepository<Hobbies, Integer> {
    /**
     * KhoaTA
     * Get list of all hobbies
     */
    @Query(value = "select id, name from hobbies", nativeQuery = true)
    List<Hobbies> getHobbiesList();
}
