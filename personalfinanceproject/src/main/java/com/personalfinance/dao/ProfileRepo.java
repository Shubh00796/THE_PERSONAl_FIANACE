package com.personalfinance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalfinance.entites.Profile;

public interface ProfileRepo extends JpaRepository<Profile,Long>{

}
