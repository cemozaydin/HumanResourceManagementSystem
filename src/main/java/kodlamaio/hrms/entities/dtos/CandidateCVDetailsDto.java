package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.*;
import lombok.Data;

import java.util.List;

@Data
public class CandidateCVDetailsDto {
    private Candidate candidate;
    private List<CandidateSchool> candidateSchools;
    private List<CandidateExperience> candidateExperiences;
    private List<CandidateLanguage> candidateLanguages;
    private List<ComputerAndTechnologySkill> computerAndTechnologySkills;
    private List<CoverLetter> coverLetters;
    private List<Image> images;
    private List<SocialMediaAccount> socialMediaAccounts;

    public CandidateCVDetailsDto(Candidate candidate) {
        this.candidate = candidate;
        this.candidateSchools = candidate.getCandidateSchools();
        this.candidateExperiences=candidate.getCandidateExperiences();
        this.candidateLanguages=candidate.getCandidateLanguages();
        this.computerAndTechnologySkills=candidate.getComputerAndTechnologySkills();
        this.coverLetters=candidate.getCoverLetters();
        this.socialMediaAccounts = candidate.getSocialMediaAccounts();
        this.images = candidate.getImages();
    }

}
