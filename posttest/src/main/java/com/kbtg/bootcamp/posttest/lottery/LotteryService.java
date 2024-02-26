package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LotteryService {

    private final LotteryRepository lotteryRepository;

    public LotteryService(LotteryRepository lotteryRepository) {
        this.lotteryRepository = lotteryRepository;
    }

    public List<String> findAllLottery() {
        return this.lotteryRepository.findAll()
            .stream()
            .map(Lottery::getId)
            .collect(Collectors.toList());
    }

    public Lottery createLottery(LotteryRequestDto requestDto) {
        Lottery lottery = new Lottery();
        lottery.setId(requestDto.getId());
        lottery.setPrice(requestDto.getPrice());
        lottery.setAmount(requestDto.getAmount());
        lotteryRepository.save(lottery);
        return lottery;
    }
}
