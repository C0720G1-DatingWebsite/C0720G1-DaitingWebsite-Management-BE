package com.codegym.service;

import c0720g1be.dto.AccountDTO;
import c0720g1be.dto.SuggestionToMakeFriendsDTO;

import java.util.List;

public interface ISuggestionsService {
    AccountDTO getAccountInformation(Integer accountId);

    List<SuggestionToMakeFriendsDTO> suggestionToMakeFriends(String hobbiesName, String cityName, Integer accountId);

    List<SuggestionToMakeFriendsDTO> datingSuggestion(String hobbiesName, String cityName, boolean gender, Integer maritalStatusId, Integer accountId);
}
