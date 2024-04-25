package com.soldierankita.movieticket.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.soldierankita.movieticket.entity.TicketInfo;
public interface TicketinfoRepo extends JpaRepository<TicketInfo, String> {

}