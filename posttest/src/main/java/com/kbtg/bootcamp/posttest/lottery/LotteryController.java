package com.kbtg.bootcamp.posttest.lottery;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
public class LotteryController {
    private final LotteryService lotteryService;

    @Autowired
    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("/lotteries")
    public ResponseEntity<List<LotteryResponseDto>> getLotteries() {
        return ResponseEntity<>(new LotteryResponseDto(lotteryService.getLotteries()), HttpStatus.OK));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/lottery")
    public ResponseEntity<LotteryResponseDto> createLottery(@RequestBody LotteryRequestDto request) {
        return new ResponseEntity<>(new LotteryResponseDto(lotteryService.createLottery(request), HttpStatus.CREATED));
    }
}
