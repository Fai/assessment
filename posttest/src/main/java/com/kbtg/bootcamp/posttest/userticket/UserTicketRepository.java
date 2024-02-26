package com.kbtg.bootcamp.posttest.userticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserTicketRepository extends JpaRepository<UserTicket, String> {

    @Query(value = "SELECT ticket_id FROM user_ticket WHERE user_id = :userId",
            nativeQuery = true)
    List<UserTicket> findUserTicketsByUserId(String userId);

    @Query("INSERT INTO user_ticket (user_id, ticket_id) VALUES (:userId, :ticketId)")
    void buyLotteryTicket(String userId, String ticketId);

    @Query("DELETE FROM user_ticket WHERE user_id = :userId AND ticket_id = :ticketId")
    void sellLotteryTicket(String userId, String ticketId);
}
