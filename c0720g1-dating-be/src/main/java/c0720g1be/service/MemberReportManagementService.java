package c0720g1be.service;

import c0720g1be.dto.MemberDTO;
import c0720g1be.dto.ReportMemberInterfaceDTO;
import c0720g1be.entity.Account;
import c0720g1be.entity.ReportContent;

import java.util.List;

public interface MemberReportManagementService {
    List<MemberDTO> findAllMember();
    Account findMemberById(Integer accountId);
    List<ReportMemberInterfaceDTO> reportMemberList(Integer accountId);
    void warningMember(String dateReport, Integer accountTarget, Integer accountVictim, Integer reportContent);
//    Report sendReportFeedbackAccount(Report report, Integer accountId);
//    List<Feedback> findAllFeedback();
    void lockAccountOneWeek(Integer accountId);
    void lockAccountOnemonth(Integer accountId);
    void lockAccountForever(Integer accountId);
    void unlockAccount();
    List<ReportContent> findAllByReportContent();
}
