package com.kbtg.bootcamp.posttest.lottery;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lottery")
public class Lottery {

    @Id
    @Column(name = "ticket_id")
    @Size(min = 6, max = 6, message = "ticketId must be 6 characters")
    private String ticketId;

    @NotNull
    private Integer price;

    @NotNull
    private Integer amount;
}
