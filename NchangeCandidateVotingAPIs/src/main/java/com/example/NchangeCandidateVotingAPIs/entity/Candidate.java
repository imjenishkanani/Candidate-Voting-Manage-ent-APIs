package com.example.NchangeCandidateVotingAPIs.entity;

public class Candidate {
    private String name;
    private Integer voteCount;

    public Candidate() {}

    public Candidate(String name, Integer voteCount) {
        this.name = name;
        this.voteCount = voteCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}
