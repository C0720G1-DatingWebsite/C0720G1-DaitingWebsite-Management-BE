package c0720g1be.service.impl;

import c0720g1be.dto.SearchDataDTO;
import c0720g1be.entity.City;
import c0720g1be.entity.Hobbies;
import c0720g1be.repository.SearchAccountRepository;
import c0720g1be.repository.SearchCityRepository;
import c0720g1be.repository.SearchHobbiesRepository;
import c0720g1be.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * KhoaTA
 */
@Service
public class SearchServiceImpl implements ISearchService {

    @Autowired
    private SearchCityRepository searchCityRepository;
    @Autowired
    private SearchHobbiesRepository searchHobbiesRepository;
    @Autowired
    private SearchAccountRepository searchAccountRepository;
    @Override
    public List<City> findCityList() {
        return this.searchCityRepository.getCityList();
    }

    @Override
    public List<Hobbies> findAllHobbies() {
        return this.searchHobbiesRepository.getHobbiesList();
    }

    @Override
    public List findCustomMember(SearchDataDTO searchData) {
        System.out.println(searchData.toString());
        String query = "select account.id, account.full_name, account.avatar, account.background_image, account.account_describe, " +
                "(select count(post.id) from post where post.account_id = account.id) as post_count, " +
                "(select count(friend.friend_id) from friend where friend.account_id = account.id) as friend_count, " +
                "(select sum(post.like_count) from post where post.account_id = account.id) as like_count " +
                "from account " +
                "left join post on account.id = post.account_id " +
                "left join friend on account.id = friend.account_id " +
                "left join personal_hobbies on account.id = personal_hobbies.account_id " +
                "left join hobbies on personal_hobbies.hobbies_id = hobbies.id " +
                "left join job on account.job_id = job.id " +
                "where job.name like '%"+searchData.getJob()+"%' and hobbies.name like '%"+searchData.getHobbies()+"%' and account.full_name like '%"+searchData.getName()+"%' ";
        if (searchData.getCity() != 0) {
            query = query + "and account.city_id = "+searchData.getCity()+" ";
        }
        if(searchData.getGender() != 3) {
            query = query + "and account.gender = "+searchData.getGender()+" ";
        }
        if (!searchData.getStartYear().equals("")) {
            query = query + "and year(account.date_of_birth) < "+searchData.getEndYear()+" and year(account.date_of_birth) > "+searchData.getStartYear()+" ";
        }
        query = query + "group by account.id";
        return this.searchAccountRepository.searchCustomMembers(query);
    }
}
