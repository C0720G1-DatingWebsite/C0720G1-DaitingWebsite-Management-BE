package c0720g1be.service;

import c0720g1be.dto.SearchAccountDTO;
import c0720g1be.dto.SearchDataDTO;
import c0720g1be.entity.City;
import c0720g1be.entity.Hobbies;

import java.util.List;

/**
 * KhoaTA
 */
public interface ISearchService {
    List<City> findCityList();
    List<Hobbies> findAllHobbies();

    List<SearchAccountDTO> findCustomMember(SearchDataDTO searchData);
}
