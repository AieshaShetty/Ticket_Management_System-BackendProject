package com.soldierankita.movieticket.service;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soldierankita.movieticket.dto.MovieTicketAcknowledgement;
import com.soldierankita.movieticket.dto.MovieTicketRequest;
import com.soldierankita.movieticket.entity.PaymentInfo;
import com.soldierankita.movieticket.entity.TicketInfo;
import com.soldierankita.movieticket.repository.PaymentInfoRepo;
import com.soldierankita.movieticket.repository.TicketinfoRepo;
import com.soldierankita.movieticket.utility.ValidatePaymentInfo;

@Service
public class MovieTicketService {

    @Autowired
    TicketinfoRepo ticketinfoRepo;

    @Autowired
    PaymentInfoRepo paymentInfoRepo;

    @Transactional
    public MovieTicketAcknowledgement bookMovieTicket(MovieTicketRequest request) {
        TicketInfo ticketInfo = request.getTicketInfo();
        ticketInfo =   ticketinfoRepo.save(ticketInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        ValidatePaymentInfo.validateCreditLimit(paymentInfo.getAccountNo(), ticketInfo.getTicketPrize());

        paymentInfo.setTicketId(ticketInfo.getId());
        paymentInfo.setAmount(ticketInfo.getTicketPrize());

        paymentInfoRepo.save(paymentInfo);

        return new MovieTicketAcknowledgement("SUCCESSS", ticketInfo.getTicketPrize(),UUID.randomUUID().toString().split("-")[0], ticketInfo);
    }

}