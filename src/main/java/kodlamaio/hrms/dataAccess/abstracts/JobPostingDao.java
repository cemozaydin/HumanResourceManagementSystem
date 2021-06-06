package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {

    @Query(value = "SELECT new kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto" +
            "(jp.id, em.companyName,jt.title, jp.postingTitle, jp.postingDescription, ct.cityName, jp.numberOfOpenPositions, jp.postingReleaseDate, jp.postingDeadline, jp.isActive) " +
            "FROM JobPosting jp " +
            "INNER JOIN jp.employer em " +
            "INNER JOIN jp.jobTitle jt " +
            "INNER JOIN jp.city ct WHERE jp.isActive=:isActive")
    List<JobPostingWithEmployerAndJobTitleDto> getJobPostingWithEmployerAndJobTitleByisActive(boolean isActive);


    @Query(value = "SELECT new kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto" +
            "(jp.id, em.companyName,jt.title, jp.postingTitle, jp.postingDescription, ct.cityName, jp.numberOfOpenPositions, jp.postingReleaseDate, jp.postingDeadline, jp.isActive) " +
            "FROM JobPosting jp " +
            "INNER JOIN jp.employer em " +
            "INNER JOIN jp.jobTitle jt " +
            "INNER JOIN jp.city ct WHERE jp.isActive=:isActive")
    List<JobPostingWithEmployerAndJobTitleDto> getJobPostingWithEmployerAndJobTitleByisActive(boolean isActive, Sort sort);

    @Query(value = "SELECT new kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto" +
            "(jp.id, em.companyName,jt.title, jp.postingTitle, jp.postingDescription, ct.cityName, jp.numberOfOpenPositions, jp.postingReleaseDate, jp.postingDeadline, jp.isActive) " +
            "FROM JobPosting jp " +
            "INNER JOIN jp.employer em " +
            "INNER JOIN jp.jobTitle jt " +
            "INNER JOIN jp.city ct WHERE jp.isActive=:isActive AND jp.employer.id=:employerId")
    List<JobPostingWithEmployerAndJobTitleDto> getJobPostingWithEmployerAndJobTitleByisActive(boolean isActive, int employerId);



}
