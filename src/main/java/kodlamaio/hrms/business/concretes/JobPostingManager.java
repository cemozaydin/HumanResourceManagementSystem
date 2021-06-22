package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class JobPostingManager implements JobPostingService {
    private JobPostingDao jobPostingDao;

    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao) {
        this.jobPostingDao = jobPostingDao;
    }

    @Override
    public Result add(JobPosting jobPosting) {
        this.jobPostingDao.save(jobPosting);
        return new SuccessResult();
    }

    @Override
    public Result updateJobPostingIsActiveStatus(int jobPostingId, boolean status) {
        JobPosting jobPosting = this.jobPostingDao.findJobPostingById(jobPostingId);

        if(Objects.isNull(jobPosting)){
            return new ErrorResult("Böyle bir ilan kaydı yok!");
        }else if(status==false){
            jobPosting.setConfirmByAdmin(false);
        }
        jobPosting.setActive(status);
        this.jobPostingDao.save(jobPosting);
        return new SuccessResult("İlan durumu güncellendi.");
    }

    @Override
    public Result updateJobPostingAdminConfirmStatus(int jobPostingId, boolean isAdminConfirm) {
        JobPosting jobPosting = this.jobPostingDao.findJobPostingById(jobPostingId);

        if (Objects.isNull(jobPosting)) {
            return new ErrorResult("Böyle bir ilan kaydı yok!");
        }

        if (jobPosting.isActive() == true && jobPosting.isConfirmByAdmin() == false) {

            if (isAdminConfirm == true) {
                jobPosting.setConfirmByAdmin(isAdminConfirm);
                this.jobPostingDao.save(jobPosting);
                return new SuccessResult("İlan Admin tarafından onaylanmıştır.");
            } else {

                return new SuccessResult("İlan henüz Admin Onayından geçmemiştir.");
            }
        }
        else if(jobPosting.isActive() == true && jobPosting.isConfirmByAdmin() == true)
        {
            if (isAdminConfirm == false) {
                jobPosting.setConfirmByAdmin(isAdminConfirm);
                jobPosting.setActive(false);
                this.jobPostingDao.save(jobPosting);
                return new SuccessResult("İlanınız Admin tarafından pasif hale getirilmiştir, ilanı düzenleyip tekrar onaya sunabilirsiniz.");
            }
        }
        return null;
    }

    @Override
    public DataResult<JobPosting> getJobPostingById(int id) {
        return new SuccessDataResult<JobPosting>(this.jobPostingDao.findJobPostingById(id));
    }

    @Override
    public DataResult<List<JobPosting>> getAll() {
        return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll());
    }

    @Override
    public DataResult<List<JobPosting>> getAllByIsActiveAndPendingApproval(){
        return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByIsActiveAndPendingApproval());
    }

    @Override
    public DataResult<List<JobPosting>> getAllByIsActiveAndAdminApproved() {
        return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByIsActiveAndAdminApproved());
    }

    @Override
    public DataResult<List<JobPosting>> getAllByIsActiveFalse() {
        return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByIsActiveFalse());
    }

    @Override
    public DataResult<List<JobPosting>> getAllByIsActiveAndPendingApprovalOrderByDeadlineDesc() {
        return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByIsActiveAndPendingApprovalOrderByDeadlineDesc());
    }

    @Override
    public DataResult<List<JobPosting>> getAllByIsActiveAndAdminConfirmAndEmployerId(int employerId) {
        return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByIsActiveAndAdminConfirmAndEmployerId(employerId));
    }

    @Override
    public DataResult<List<JobPosting>> getAllByIsActiveAndPendingApprovalAndEmployerId(int employerId) {
        return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByIsActiveAndPendingApprovalAndEmployerId(employerId));
    }


}
