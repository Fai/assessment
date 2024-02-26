package com.kbtg.bootcamp.posttest.userticket;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@Service
public class UserTicketService {
    private UserTicketRepository userTicketRepository;

    public UserTicketsResponseDto getUserLotteries(String userId) {
        UserTicketsResponseDto userTicketsResponseDto = new UserTicketsResponseDto();

        List<UserTicket> userTickets = userTicketRepository.findUserTicketsByUserId(userId);
        List<String> tickets = userTickets.stream().map(e -> String.valueOf(e.getLottery())).toList();

        userTicketsResponseDto.setTickets(tickets);
        userTicketsResponseDto.setCount((long) userTickets.size());
        userTickets.stream()
                .map(UserTicket::getLottery)
                .map(Lottery::getPrice)
                .reduce(0, Integer::sum);

        return userTicketsResponseDto;
    }

    public UserTicketResponseDto buyLotteryTicket(String userId, String ticketId) {
        if (this.userTicketRepository.findUserTicketsByUserId(userId).contains(ticketId)) {
            throw new RuntimeException("User already has the ticket");
        }
        this.userTicketRepository.buyLotteryTicket(userId, ticketId);
        return new UserTicketResponseDto(ticketId);
    }

    public UserTicketResponseDto sellLotteryTicket(String userId, String ticketId) {
        if (!this.userTicketRepository.findUserTicketsByUserId(userId).contains(ticketId)) {
            throw new RuntimeException("User does not have the ticket");
        }
        return new UserTicketResponseDto(ticketId);
    }
}
