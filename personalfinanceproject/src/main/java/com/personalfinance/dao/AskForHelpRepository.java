package com.personalfinance.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.personalfinance.entites.AskForHelp;

public interface AskForHelpRepository extends JpaRepository<AskForHelp, Long> {
}
