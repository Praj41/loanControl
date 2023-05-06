package com.example.loancontrol.repository;

import com.example.loancontrol.model.DigitalAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DigitalAccRepository extends JpaRepository<DigitalAccount, Long> {

}
