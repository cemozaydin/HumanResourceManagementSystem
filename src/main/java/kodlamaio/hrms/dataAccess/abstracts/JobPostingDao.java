package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {

    JobPosting findJobPostingById(int id);  // ID ye göre bir ilan getiren sorgu

    List<JobPosting> findAll(); //Onaylı-Onaysız Tüm İlanlar

    @Query(value = "FROM JobPosting WHERE isActive=true AND isConfirmByAdmin=false")
    List<JobPosting> findAllByIsActiveAndPendingApproval(); // İşverenlerin aktif ettiği ama Admin onayını bekleyen Tüm İlanlar.

    @Query(value = "FROM JobPosting WHERE isActive=true ORDER BY postingDeadline DESC")
    List<JobPosting> findAllByIsActiveAndPendingApprovalOrderByDeadlineDesc(); // İşveren tarafından aktif edilmiş, Admin onaysız, Tarih sıralamalı

    @Query(value = "FROM JobPosting WHERE isActive=true AND isConfirmByAdmin=true ")
    List<JobPosting> findAllByIsActiveAndAdminApproved();  // İşverenlerin aktif ettiği ve Admin Onayından geçmiş, Yayındaki Tüm ilanlar.

    @Query(value = "FROM JobPosting WHERE isActive=false")
    List<JobPosting> findAllByIsActiveFalse(); // İşverenler tarafından pasif edilmiş Tüm ilanlar.

    @Query(value = "FROM JobPosting WHERE isActive=true AND isConfirmByAdmin=true AND employer.id=:employerId ORDER BY postingDeadline DESC")
    List<JobPosting> findAllByIsActiveAndAdminConfirmAndEmployerId(int employerId); // Bir işverene ait Aktif ilanlar, Admin onayından geçmiş,tarih sırasına göre.

    @Query(value = "FROM JobPosting WHERE isActive=true AND isConfirmByAdmin=false AND employer.id=:employerId ORDER BY postingDeadline DESC")
    List<JobPosting> findAllByIsActiveAndPendingApprovalAndEmployerId(int employerId); // Bir işverene ait Aktif edilmiş ama Admin onaysız.


}
