package c0720g1be.service.impl;

import c0720g1be.dto.AccountDTO;
import c0720g1be.dto.SuggestionToMakeFriendsDTO;
import c0720g1be.repository.ISuggestionsRepository;
import c0720g1be.service.ISuggestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISuggestionsServiceImpl implements ISuggestionsService {

    @Autowired
    private ISuggestionsRepository iSuggestionsRepository;

    /**
     * TuNH
     **/
    @Override
    public AccountDTO getAccountInformation(Integer accountId) {
        return this.iSuggestionsRepository.getAccountInformation(accountId);
    }

    /**
     * TuNH
     **/
    @Override
    public List<SuggestionToMakeFriendsDTO> suggestionToMakeFriends(String hobbiesName, String cityName, Integer accountId, Integer size) {
        return this.iSuggestionsRepository.suggestionToMakeFriends(hobbiesName,cityName,accountId,size);
    }

    /**
     * TuNH
     **/
    @Override
    public List<SuggestionToMakeFriendsDTO> datingSuggestion(String hobbiesName, String cityName, boolean gender, Integer maritalStatusId, Integer accountId,Integer size) {
        if (gender == true){
            return this.iSuggestionsRepository.datingSuggestion(hobbiesName, cityName, false , maritalStatusId, accountId,size);
        }else {
            return this.iSuggestionsRepository.datingSuggestion(hobbiesName, cityName, true, maritalStatusId, accountId,size);
        }
    }

}
