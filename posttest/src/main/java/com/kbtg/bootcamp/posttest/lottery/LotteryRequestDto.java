package com.kbtg.bootcamp.posttest.lottery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LotteryRequestDto {
    private String id;
    private Integer price;
    private Integer amount;
}
