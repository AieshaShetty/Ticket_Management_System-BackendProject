package com.soldierankita.movieticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soldierankita.movieticket.entity.PaymentInfo;

public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, Long> {

}
