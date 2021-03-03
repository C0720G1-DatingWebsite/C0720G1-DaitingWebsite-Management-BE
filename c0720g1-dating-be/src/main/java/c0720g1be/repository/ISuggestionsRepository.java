package c0720g1be.repository;

import c0720g1be.dto.AccountDTO;
import c0720g1be.dto.SuggestionToMakeFriendsDTO;
import c0720g1be.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ISuggestionsRepository extends JpaRepository<Account, Integer> {

    /**
     * TuNH
     **/
    @Query(value = "select account.id as accountId, account.avatar as avatar," +
            "account.full_name as fullName, account.gender as gender," +
            "hobbies.name as hobbiesName,city.name as cityName," +
            "account.marital_status_id as maritalStatusId " +
            "from account " +
            "join personal_hobbies on account.id = personal_hobbies.account_id " +
            "join hobbies on personal_hobbies.hobbies_id = hobbies.id " +
            "join city on account.city_id = city.id " +
            "where account.id = ?1", nativeQuery = true)
    AccountDTO getAccountInformation(Integer accountId);

    /**
     * TuNH
     **/
    @Query(value = "select account.avatar as avatar,account.full_name as fullName, account.id as friendID , (select count(account.id) \n" +
            "from account \n" +
            "where account.id in ( select friend.friend_id from friend where friend.account_id = friendID) \n" +
            "and account.id in ( select friend.friend_id from friend where friend.account_id = ?3)) as mutualFriends\n" +
            "from account \n" +
            "join personal_hobbies on account.id = personal_hobbies.account_id \n" +
            "join hobbies on personal_hobbies.hobbies_id = hobbies.id \n" +
            "join city on account.city_id = city.id \n" +
            "where (hobbies.name = ?1 or city.name = ?2) and account.id != ?3 LIMIT ?4 " , nativeQuery = true)
    List<SuggestionToMakeFriendsDTO> suggestionToMakeFriends(String hobbiesName, String cityName , Integer accountId,Integer size);

    /**
     * TuNH
     **/
    @Query(value = "select account.avatar as avatar,\n" +
            "account.full_name as fullName , account.id as friendID , (select count(account.id) \n" +
            "from account \n" +
            "where account.id in ( select friend.friend_id from friend where friend.account_id = friendID) \n" +
            "and account.id in ( select friend.friend_id from friend where friend.account_id = ?5) ) as mutualFriends\n" +
            "from account \n" +
            "join personal_hobbies on account.id = personal_hobbies.account_id \n" +
            "join hobbies on    personal_hobbies.hobbies_id = hobbies.id \n" +
            "join city on account.city_id = city.id\n" +
            "join marital_status on account.marital_status_id = marital_status.id\n" +
            "where (hobbies.name = ?1 or city.name = ?2) and account.gender = ?3 \n" +
            "and account.marital_status_id = ?4 and account.id != ?5 LIMIT ?6" , nativeQuery = true)
    List<SuggestionToMakeFriendsDTO> datingSuggestion(String hobbiesName, String cityName, boolean gender, Integer maritalStatusId , Integer accountId,Integer size);
}

