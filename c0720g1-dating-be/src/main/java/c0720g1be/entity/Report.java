package c0720g1be.entity;

import javax.persistence.*;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
        @JoinColumn(name = "report_content_id")
    ReportContent reportContent;

    @ManyToOne
        @JoinColumn(name = "account_target_id")
    Account accountTarget;

    @ManyToOne
        @JoinColumn(name = "account_victim_id")
    Account accountVictim;

    @ManyToOne
        @JoinColumn(name = "group_id")
    UserGroup userGroup;

    @Column(name = "date_report",columnDefinition = "DATETIME")
    String dateReport;

    public Report() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ReportContent getReportContent() {
        return reportContent;
    }

    public void setReportContent(ReportContent reportContent) {
        this.reportContent = reportContent;
    }

    public Account getAccountTarget() {
        return accountTarget;
    }

    public void setAccountTarget(Account accountTarget) {
        this.accountTarget = accountTarget;
    }

    public Account getAccountVictim() {
        return accountVictim;
    }

    public void setAccountVictim(Account accountVictim) {
        this.accountVictim = accountVictim;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public String getDateReport() {
        return dateReport;
    }

    public void setDateReport(String dateReport) {
        this.dateReport = dateReport;
    }
}
