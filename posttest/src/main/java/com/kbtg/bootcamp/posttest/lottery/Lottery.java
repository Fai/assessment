package com.kbtg.bootcamp.posttest.lottery;

import jakarta.persistence.*;
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
@Table(name = "lotteries")
public class Lottery {

    @Id
    @Column(name = "id")
    @Size(min = 6, max = 6, message = "Lottery ticket id must be 6 characters")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull
    private Integer price;

    @NotNull
    private Integer amount;
}
