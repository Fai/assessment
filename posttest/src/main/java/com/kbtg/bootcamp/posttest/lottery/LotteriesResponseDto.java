package com.kbtg.bootcamp.posttest.lottery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LotteriesResponseDto {
    private List<String> id;
}
