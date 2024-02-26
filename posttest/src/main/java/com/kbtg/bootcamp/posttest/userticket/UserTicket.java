package com.kbtg.bootcamp.posttest.userticket;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private String userId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private Lottery lottery;



}
