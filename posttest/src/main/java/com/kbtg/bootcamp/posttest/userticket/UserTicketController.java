package com.kbtg.bootcamp.posttest.userticket;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@Validated
public class UserTicketController {
    private final UserTicketService userTicketService;

    public UserTicketController(UserTicketService userTicketService) {
        this.userTicketService = userTicketService;
    }

    @PostMapping("/users/{userId}/lotteries/{ticketId}")
    public ResponseEntity<UserTicketResponseDto> buyLotteryTicket(
            @PathVariable(name = "userId")
            @Pattern(regexp = "^[0-9]{10}$")
            @Size(min = 10, max = 10, message = "userId must be 10 digits")
            String userId,
            @PathVariable(name = "ticketId")
            @Pattern(regexp = "^[0-9]{6}$")
            @Size(min = 6, max = 6, message = "ticketId must be 6 digits")
            String ticketId) {
        return new ResponseEntity<>(userTicketService.buyLotteryTicket(userId, ticketId), HttpStatus.OK);
    }
    @GetMapping("/users/{userId}/lotteries")
    public ResponseEntity<UserTicketsResponseDto> getUserLotteries(
            @PathVariable(name = "userId")
            @Pattern(regexp = "^[0-9]{10}$")
            @Size(min = 10, max = 10, message = "userId must be 10 digits")
            String userId) {
        return new ResponseEntity<>(userTicketService.getUserLotteries(userId), HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}/lotteries/{ticketId}")
    public ResponseEntity<UserTicketResponseDto> sellLotteryTicket(
            @PathVariable(name = "userId")
            @Pattern(regexp = "^[0-9]{10}$")
            @Size(min = 10, max = 10, message = "userId must be 10 digits")
            String userId,
            @PathVariable(name = "ticketId")
            @Pattern(regexp = "^[0-9]{6}$")
            @Size(min = 6, max = 6, message = "ticketId must be 6 digits")
            String ticketId) {
        return new ResponseEntity<>(userTicketService.sellLotteryTicket(userId, ticketId), HttpStatus.OK);
    }

}
