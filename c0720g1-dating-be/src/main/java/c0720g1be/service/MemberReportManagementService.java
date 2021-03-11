package c0720g1be.service;

import c0720g1be.dto.AccountTarget;
import c0720g1be.dto.GetFeedbackDTO;
import c0720g1be.dto.MemberDTO;
import c0720g1be.dto.ReportMemberInterfaceDTO;
import c0720g1be.entity.Account;
import c0720g1be.entity.Feedback;
import c0720g1be.entity.ReportContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberReportManagementService {
    List<MemberDTO> findAllMember();
    Account findMemberById(Integer accountId);
    List<MemberDTO> findAccountByUserNameAndDateOfBirthAndDateOfBirth(String userNameSearch, String dateOfBirthSearch,
                                                                      String dateRegisterSearch);
    List<ReportMemberInterfaceDTO> reportMemberList(Integer accountId);
    void warningMember(String dateReport, Integer accountTarget, Integer accountVictim, Integer reportContent);
    void lockAccountOneWeek(Integer accountId);
    void lockAccountOnemonth(Integer accountId);
    void lockAccountForever(Integer accountId);
    void unlockAccount();
    List<ReportContent> findAllByReportContent();
    List<GetFeedbackDTO> findAllFeedback();
    AccountTarget getAccountTarget(String userName);
    void setFeedBack(int idAccount);
}
