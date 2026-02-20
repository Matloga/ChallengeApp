package com.matloga.ChallengeApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    //private List<Challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;

    @Autowired
    ChallengeRepository challengeRepository;

    public ChallengeService(){
    }

    public List<Object> getChallenges(){
        JpaRepository<Object, Object> challengesRepository = null;
        return challengesRepository.findAll();
    }

    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challengeRepository.save(challenge);
            return true;
        }else {
            return false;
        }

    }

    public Challenge getChallenge(String month) {
        Optional<Challenge> Challenge = challengeRepository.findByMonthIgnoreCase(month);
            return Challenge.orElse(null);
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent()) {
            Challenge challengeToUpdate = challenge.get();
            challengeToUpdate.setMonth(updatedChallenge.getMonth());
            challengeToUpdate.setDescription(updatedChallenge.getDescription());
            challengeRepository.save(challengeToUpdate);
            return true;
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent()) {
             challengeRepository.deleteById(id);
             return true;
        }
        return false;
    }

    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }
}
