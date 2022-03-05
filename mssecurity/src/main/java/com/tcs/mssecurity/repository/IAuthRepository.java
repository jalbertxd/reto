package com.tcs.mssecurity.repository;

import com.tcs.mssecurity.model.AccessModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthRepository extends CrudRepository<AccessModel, Long> {
    
}