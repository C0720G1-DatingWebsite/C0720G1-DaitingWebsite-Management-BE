package c0720g1be.repository;

import c0720g1be.entity.ReportContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportContentRepo extends JpaRepository<ReportContent, Integer> {
    /*
     * HungDH - hien thi list noi dung report
     */
    @Query(value = "select report_content.id, report_content.name from report_content", nativeQuery = true)
    List<ReportContent> findAllReportContent();
}
