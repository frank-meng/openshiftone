package com.sample;

import org.springframework.data.repository.CrudRepository;

import com.sample.model.LoginUser;

public interface UserRepository extends CrudRepository<LoginUser, Integer> {

}
