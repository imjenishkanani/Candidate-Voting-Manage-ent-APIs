package com.example.NchangeCandidateVotingAPIs.serviceImpl;

import com.example.NchangeCandidateVotingAPIs.entity.Candidate;
import com.example.NchangeCandidateVotingAPIs.service.CandidateService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CandidateServiceImpl implements CandidateService {

    private static Map<String, Candidate> candidates = new HashMap<>();

    static {
        Candidate candidate1 = new Candidate("max", 0);
        Candidate candidate2 = new Candidate("jenish", 0);
        candidates.put("max", candidate1);
        candidates.put("jenish", candidate2);
    }
    @Override
    public Map<String, String> createCandidate(String name, Candidate candidate) {
        Map<String, String> messageMap = new HashMap<>();
        if(name.equals(candidate.getName())) {
            candidates.put(candidate.getName(), candidate);
            messageMap.put("message", "Candidate added successfully.");
            return messageMap;
        }
        messageMap.put("message","Invalid data entered in parameter.");
        return messageMap;
    }

    @Override
    public List<Candidate> castCandidateVote(String name) {
        if(candidates.containsKey(name)) {
            int voteCount = candidates.get(name).getVoteCount();
            voteCount++;
            candidates.get(name).setVoteCount(voteCount);
            Candidate candidateToBeReplace = candidates.get(name);
            candidates.replace(name, candidateToBeReplace);
        } else {
            return new ArrayList<>();
        }
        return new ArrayList<>(candidates.values());
    }

    @Override
    public Map<String, Integer> countCandidateVotes(String name) {
        Map<String, Integer> voteCountMap = new HashMap<>();
        if(candidates.containsKey(name)) {
            voteCountMap.put("voteCount", candidates.get(name).getVoteCount());
        } else {
            return new HashMap<>();
        }
        return voteCountMap;
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return new ArrayList<>(candidates.values());
    }

    @Override
    public Map.Entry<String, Integer> getLargetVotedCandidate() {
        Map<String, Integer> candidateMap = new HashMap<>();
        Map.Entry<String, Integer> winnerMap = null;
        for(Map.Entry<String, Candidate> entry : candidates.entrySet()) {
            candidateMap.put(entry.getValue().getName(), entry.getValue().getVoteCount());
        }

        int maxCndidateVotes = Collections.max(candidateMap.values());
        for(Map.Entry<String, Integer> entry : candidateMap.entrySet()) {
            if(entry.getValue() == maxCndidateVotes) {
                winnerMap = entry;
            }
        }

        if(winnerMap != null) {
            return winnerMap;
        }
        return winnerMap;
    }
}
