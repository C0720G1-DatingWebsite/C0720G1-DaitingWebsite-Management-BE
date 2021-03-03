package c0720g1be.repository;

import c0720g1be.dto.MemberDTO;
import c0720g1be.dto.ReportMemberInterfaceDTO;
import c0720g1be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MemberReportManagementRepo extends JpaRepository<Account, Integer> {
    /*
    * HungDH - hien thi danh sach thanh vien
     */
    @Query(value = "select account.avatar as avatar, account.id as accountId, account.full_name as fullName, account.user_name as userName, " +
            "account.date_register as dateRegister, " +
            "account.date_of_birth as dateOfBirth, count(report.account_target_id) as numberOfViolations from account " +
            "left join report on account.id = report.account_target_id group by account.id", nativeQuery = true)
    List<MemberDTO> findAllMember();
    /*
    * HungDH - tim nhan vien theo id
     */
//    @Query(value = "select account.id as accountId, account.full_name as fullName, account.date_register as dateRegister, " +
//            "account.date_of_birth as dateOfBirth, count(report.account_target_id) as numberOfViolations, account.email as email from account " +
//            "left join report on account.id = report.account_target_id where account.id = ?", nativeQuery = true)
//    Account findMemberById(Integer accountId);
    @Query(value = "select * from account where account.id = ?", nativeQuery = true)
    Account findMemberById(Integer accountId);
    /*
     * HungDH - lich su canh cao thanh vien theo id
     */
    @Query(value = "select report.date_report as dateReport, report_content.name as reportContent, " +
            "(select user_name from account where id = report.account_victim_id) as accountVictim " +
            "from report " +
            "join report_content on report.report_content_id = report_content.id " +
            "join account on account.id = report.account_target_id " +
            "where account.id = ?", nativeQuery = true)
    List<ReportMemberInterfaceDTO> reportMemberList(Integer accountId);
    /*
    * HungDH - canh bao thanh vien
     */
//    @Query(value = "insert into report(date_report, account_target_id, account_victim_id, report_content_id) " +
//            "values(?1, ?2, 3?, 4?)", nativeQuery = true)
//    Report warningMember(String dateReport, Integer accountTarget, Integer accountVictim, Integer reportContent);


    /*
    * HungDH - khoa tai khoan 1 tuan
     */
    @Transactional
    @Modifying
    @Query(value = "update `account`" +
            "set date_unban = DATE(DATE_ADD(curdate(), INTERVAL 7 day)), `account`.is_enable = false " +
            "where `account`.id = ?1", nativeQuery = true)
    void lockAccountOneWeek(Integer accountId);
    /*
     * HungDH - khoa tai khoan 1 thang
     */
    @Transactional
    @Modifying
    @Query(value = "update `account`" +
            "set date_unban = DATE(DATE_ADD(curdate(), INTERVAL 1 month)), `account`.is_enable = false " +
            "where `account`.id = ?1", nativeQuery = true)
    void lockAccountOneMonth(Integer accountId);
    /*
     * HungDH - khoa tai khoan 1 thang
     */
    @Transactional
    @Modifying
    @Query(value = "update `account`" +
            "set date_unban = DATE(DATE_ADD(curdate(), INTERVAL 1000 year)), `account`.is_enable = false " +
            "where `account`.id = ?1", nativeQuery = true)
    void lockAccountForever(Integer accountId);
    /*
    * HungDH - mo khoa tai khoan
     */
    @Transactional
    @Modifying
    @Query(value = "update `account` set `account`.is_enable = 1 where date_unban = DATE(now())", nativeQuery = true)
    void unlockAccount();
    /*
     * HungDH - list report content
     */
//    @Query(value = "select report_content.name from report_content", nativeQuery = true)
//    List<ReportContent> findAllReportContent();
    /*
    * HungDH - gui phan hoi, bao cao lam dung
     */
    @Transactional
    @Modifying
    @Query(value = "insert into report(date_report, account_target_id, account_victim_id, report_content_id) " +
            "values(?1, ?2, ?3 ,?4)", nativeQuery = true)
    void sendFeedbackReport(String dateReport, Integer accountTarget, Integer accountVictim, Integer reportContent);

}
