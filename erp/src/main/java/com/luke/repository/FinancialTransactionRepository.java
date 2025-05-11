package com.luke.repository;

import com.luke.entity.FinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Long>, JpaSpecificationExecutor<FinancialTransaction> {

}
