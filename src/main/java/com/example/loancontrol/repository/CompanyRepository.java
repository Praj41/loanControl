package com.example.loancontrol.repository;

import com.example.loancontrol.model.Company;
import com.example.loancontrol.model.DigitalAccount;
import com.example.loancontrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {


}
