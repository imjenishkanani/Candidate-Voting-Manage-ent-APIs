package com.example.NchangeCandidateVotingAPIs.controller;

import com.example.NchangeCandidateVotingAPIs.entity.Candidate;
import com.example.NchangeCandidateVotingAPIs.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping("/entercandidate/{name}")
    public Map<String, String> createCandidate(@PathVariable String name, @RequestBody Candidate candidate) {
        return candidateService.createCandidate(name, candidate);
    }

    @GetMapping("/castvote/{name}")
    public List<Candidate> castCandidateVote(@PathVariable String name) {
        return candidateService.castCandidateVote(name);
    }

    @GetMapping("/countvote/{name}")
    public Map<String, Integer> countCandidateVotes(@PathVariable String name) {
        return candidateService.countCandidateVotes(name);
    }

    @GetMapping("/listVote")
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/getwinner")
    public Map.Entry<String, Integer> getLargetVotedCandidate() {
        return candidateService.getLargetVotedCandidate();
    }
}
