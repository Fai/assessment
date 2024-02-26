package com.kbtg.bootcamp.posttest.lottery;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class LotteryController {
    private final LotteryService lotteryService;

    @Autowired
    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("/lotteries")
    public List<String> getLotteryList() {
        // return all available lottery tickets for sale
        return this.lotteryService.findAllLottery();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/lottery")
    public Lottery createLottery(@Valid @RequestBody LotteryRequestDto requestDto) throws Exception {
        // create a new lottery ticket (admin only)
        return this.lotteryService.createLottery(requestDto);
    }
}
