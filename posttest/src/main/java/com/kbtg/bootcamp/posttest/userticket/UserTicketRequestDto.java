package com.kbtg.bootcamp.posttest.userticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTicketRequestDto {
    private String userId;
    private String ticketId;

}
