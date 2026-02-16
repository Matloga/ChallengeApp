package com.matloga.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;

    public ChallengeService(){
    }

    public List<Challenge> getChallenges(){
        return challenges;
    }

    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }else {
            return false;
        }

    }

    public Challenge getChallenge(String month) {
            for (Challenge challenge : challenges) {
                if (challenge.getMonth().equalsIgnoreCase(month)) {
                    return challenge;
                }
            }
            return null;
    }

    public List<Challenge> getAllChallenges() {
        return challenges;
    }
}
