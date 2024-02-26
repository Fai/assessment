package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.lottery.LotteryRequestDto;
import com.kbtg.bootcamp.posttest.lottery.LotteryResponseDto;
import com.kbtg.bootcamp.posttest.lottery.LotteryService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/")
public class LotteryController {
    private final LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("/lotteries")
    public ResponseEntity<LotteriesResponseDto> getLotteries() {
        return new ResponseEntity<>(lotteryService.getLotteries(), HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/lotteries")
    public ResponseEntity<LotteryResponseDto> createLottery(@Valid @RequestBody LotteryRequestDto requestDto) throws Exception {
        return new ResponseEntity<>(lotteryService.createLottery(requestDto), HttpStatus.CREATED);
    }
}
