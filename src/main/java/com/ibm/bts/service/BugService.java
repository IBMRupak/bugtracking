package com.ibm.bts.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.ibm.bts.entity.Bug;
import com.ibm.bug.repo.BugRepository;


@Service
public class BugService {

	@Autowired
	BugRepository bugRepository;
	
	public String createBug(Bug bug) {
		Bug savedBug = bugRepository.save(bug);
		return savedBug.getId();
	}
	
	public List<Bug> getBugs(){
		return bugRepository.findAll();
	}
	
	public void updateBug(Bug bug) {
		bugRepository.save(bug);
	}
	
	public void deleteBug(String bugId) {
		bugRepository.deleteById(bugId);
	}
	public Optional<Bug> getBug(String bugId) {

		return bugRepository.findById(bugId);
	}
	
}
