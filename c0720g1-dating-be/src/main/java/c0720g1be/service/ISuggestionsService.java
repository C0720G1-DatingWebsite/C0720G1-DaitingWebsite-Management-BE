package c0720g1be.service;

import c0720g1be.dto.AccountDTO;
import c0720g1be.dto.SuggestionToMakeFriendsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISuggestionsService {
    AccountDTO getAccountInformation(Integer accountId);

    List<SuggestionToMakeFriendsDTO> suggestionToMakeFriends(String hobbiesName, String cityName, Integer accountId);

    Page<SuggestionToMakeFriendsDTO> datingSuggestion(String hobbiesName, String cityName, boolean gender, Integer maritalStatusId, Integer accountId, Pageable pageable);
}
