Features:
	- Add candidate with name and vote count.
	- Increment(Assign) vote count of the given candidate name as a parameter.
	- Return the latest vote count of the given candidate name as a parameter.
	- Return All candidates with name and vote count.
	- Return Winner Candidate name who got the largest number of votes.

Methods and Endpoints:
	- POST : http://localhost:8080/entercandidate/ram
	- GET  : http://localhost:8080/castvote/ram
	- GET  : http://localhost:8080/countvote/max
	- GET  : http://localhost:8080/listVote
	- GET  : http://localhost:8080/getwinner