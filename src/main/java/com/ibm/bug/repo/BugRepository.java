package com.ibm.bug.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.bts.entity.Bug;



public interface BugRepository extends  MongoRepository<Bug, String> {

}
