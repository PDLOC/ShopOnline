package com.ps20054.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps20054.entity.Account;
import com.ps20054.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

}
