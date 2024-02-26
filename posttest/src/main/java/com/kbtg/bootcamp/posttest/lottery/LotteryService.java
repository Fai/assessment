package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LotteryService {

    private final LotteryRepository lotteryRepository;

    public LotteryService(LotteryRepository lotteryRepository) {
        this.lotteryRepository = lotteryRepository;
    }

    public LotteriesResponseDto getLotteries() {
        return new LotteriesResponseDto(this.lotteryRepository.findAll()
            .stream()
            .map(Lottery::getId)
            .collect(Collectors.toList()));
    }

    public LotteryResponseDto createLottery(LotteryRequestDto requestDto) {
        Optional<Lottery> optionalLottery = this.lotteryRepository.findById(requestDto.getId());
        if (optionalLottery.isPresent()) {
            throw new RuntimeException("Lottery already exists");
        } else {
            return new LotteryResponseDto(lotteryRepository.save(Lottery.builder()
                    .id(requestDto.getId())
                    .amount(requestDto.getAmount())
                    .price(requestDto.getPrice())
                    .build()
            ).getId());

        }
    }
}
