package c0720g1be.controller;

import c0720g1be.dto.AccountDTO;
import c0720g1be.dto.SuggestionToMakeFriendsDTO;
import c0720g1be.entity.SuggestedPairing;
import c0720g1be.entity.SuggestionToMakeFriends;
import c0720g1be.service.ISuggestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/api/public")
public class SuggestionsController {

    @Autowired
    private ISuggestionsService iSuggestionsService;

    /**
     * TuNH getAccountInformation
     **/
    @RequestMapping(value = "/getAccountInformation/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<AccountDTO> getAccountInformation(@PathVariable Integer accountId) {
        AccountDTO accountDTO = this.iSuggestionsService.getAccountInformation(accountId);
        if (accountDTO == null) {
            return new ResponseEntity<AccountDTO>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<AccountDTO>(accountDTO, HttpStatus.OK);
    }

    /**
     * TuNH suggestionToMakeFriends
     **/
    @RequestMapping(value = "/suggestionToMakeFriends", method = RequestMethod.POST)
    public ResponseEntity<List<SuggestionToMakeFriendsDTO>> suggestionToMakeFriends(@Valid @RequestBody SuggestionToMakeFriends suggestionToMakeFriends) {
        List<SuggestionToMakeFriendsDTO> list = this.iSuggestionsService.suggestionToMakeFriends(suggestionToMakeFriends.getHobbiesName(), suggestionToMakeFriends.getCityName(), suggestionToMakeFriends.getAccountId(), suggestionToMakeFriends.getSize());
        if (list.isEmpty()) {
            return new ResponseEntity<List<SuggestionToMakeFriendsDTO>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<SuggestionToMakeFriendsDTO>>(list, HttpStatus.OK);
    }

    /**
     * TuNH datingSuggestion
     **/
    @RequestMapping(value = "/datingSuggestion", method = RequestMethod.POST)
    public ResponseEntity<List<SuggestionToMakeFriendsDTO>> datingSuggestion(@Valid @RequestBody SuggestedPairing suggestedPairing) {
        List<SuggestionToMakeFriendsDTO> list = this.iSuggestionsService.datingSuggestion(suggestedPairing.getHobbiesName(), suggestedPairing.getCityName(), suggestedPairing.getGender(), suggestedPairing.getMaritalStatusId(), suggestedPairing.getAccountId(),suggestedPairing.getSize());
        if (list.isEmpty()) {
            return new ResponseEntity<List<SuggestionToMakeFriendsDTO>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<SuggestionToMakeFriendsDTO>>(list, HttpStatus.OK);
    }

}

