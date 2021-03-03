package c0720g1be.controller;

import c0720g1be.dto.SearchAccountDTO;
import c0720g1be.dto.SearchDataDTO;
import c0720g1be.entity.City;
import c0720g1be.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * KhoaTA
 * Controller for searching members and groups
 */

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/public/search-total")
public class SearchController {

    @Autowired
    private ISearchService searchService;
    @GetMapping("/city-list")
    public ResponseEntity<List<City>> findAllCity() {
        List<City> cityList = this.searchService.findCityList();
        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }
    /**KhoaTA
     *get the search periodical vaccination result
     */
    @PostMapping("/get-member-list")
    public ResponseEntity<List<SearchAccountDTO>> findCustomMemberList(@RequestBody SearchDataDTO searchData) {
        List<SearchAccountDTO> customMemberList = this.searchService.findCustomMember(searchData);
        if (customMemberList.size() == 0) {
            return new ResponseEntity<>(customMemberList,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customMemberList, HttpStatus.OK);
    }

}
