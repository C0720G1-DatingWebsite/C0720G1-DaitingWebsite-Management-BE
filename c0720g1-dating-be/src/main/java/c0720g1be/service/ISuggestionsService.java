package c0720g1be.service;

import c0720g1be.dto.AccountDTO;
import c0720g1be.dto.SuggestionToMakeFriendsDTO;

import java.util.List;

public interface ISuggestionsService {
    /**
     * TuNH
     **/
    AccountDTO getAccountInformation(Integer accountId);

    /**
     * TuNH
     **/
    List<SuggestionToMakeFriendsDTO> suggestionToMakeFriends(String hobbiesName, String cityName, Integer accountId,Integer size);

    /**
     * TuNH
     **/
    List<SuggestionToMakeFriendsDTO> datingSuggestion(String hobbiesName, String cityName, boolean gender, Integer maritalStatusId, Integer accountId,Integer size);
}
