package com.example.NchangeCandidateVotingAPIs.service;

import com.example.NchangeCandidateVotingAPIs.entity.Candidate;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface CandidateService {
    public Map<String, String> createCandidate(String name, Candidate candidate);

    public List<Candidate> castCandidateVote(String name);

    public Map<String, Integer> countCandidateVotes(String name);

    public List<Candidate> getAllCandidates();

    public Map.Entry<String, Integer> getLargetVotedCandidate();
}
