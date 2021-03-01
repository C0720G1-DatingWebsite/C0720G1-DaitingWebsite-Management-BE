package c0720g1be.service.impl;

import c0720g1be.dto.MemberDTO;
import c0720g1be.dto.ReportMemberInterfaceDTO;
import c0720g1be.entity.Account;
import c0720g1be.entity.ReportContent;
import c0720g1be.repository.MemberReportManagementRepo;
import c0720g1be.repository.ReportContentRepo;
import c0720g1be.service.MemberReportManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberReportManagementServiceImpl implements MemberReportManagementService {
    @Autowired
    private MemberReportManagementRepo memberReportManagementRepo;
    @Autowired
    private ReportContentRepo reportContentRepo;
    @Override
    public List<MemberDTO> findAllMember() {
        return memberReportManagementRepo.findAllMember();
    }

    @Override
    public Account findMemberById(Integer accountId) {
        return memberReportManagementRepo.findMemberById(accountId);
    }

    @Override
    public List<ReportMemberInterfaceDTO> reportMemberList(Integer accountId) {
        return memberReportManagementRepo.reportMemberList(accountId);
    }
//
//    @Override
//    public Report sendReportFeedbackAccount(Report report, Integer accountId) {
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(formatter.format(date));
//        return memberReportManagementRepo.sendFeedbackReport(date.toString(), report.getAccountTarget(), report.getAccountVictim(), report.getReportContent());
//    }


    @Override
    public void warningMember(String dateReport, Integer accountTarget, Integer accountVictim, Integer reportContent) {
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(formatter.format(date));
        memberReportManagementRepo.sendFeedbackReport(dateReport, accountTarget, accountVictim, reportContent);
    }

//    @Override
//    public List<Feedback> findAllFeedback() {
//        return null;
//    }

    @Override
    public void lockAccountOneWeek(Integer accountId) {
        memberReportManagementRepo.lockAccountOneWeek(accountId);
    }

    @Override
    public void lockAccountOnemonth(Integer accountId) {
        memberReportManagementRepo.lockAccountOneMonth(accountId);
    }
    @Override
    public void lockAccountForever(Integer accountId) {
        memberReportManagementRepo.lockAccountForever(accountId);
    }

    @Override
    public void unlockAccount() {
        memberReportManagementRepo.unlockAccount();
    }

    @Override
    public List<ReportContent> findAllByReportContent() {
        return reportContentRepo.findAllReportContent();
    }
}
