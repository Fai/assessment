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

    public LotteryListResponseDto getLotteries() {
        List<Lottery> lotteryList = lotteryRepository.findAll();
        return new LotteryListResponseDto(lotteryRepository.findAll()
                .stream()
                .map(Lottery::getTicketId)
                .collect(Collectors.toList()));
    }

    public LotteryResponseDto createLottery(LotteryRequestDto request) {
        Optional<Lottery> optionalTicket = lotteryRepository.findByTicketId(request.getTicketId());
        if (optionalTicket.isPresent()) {
            throw new IllegalArgumentException("TicketId already exists");
        }
        Lottery lottery = new Lottery(request.getTicketId());
        lotteryRepository.save(lottery);
        return new LotteryResponseDto(lottery.getTicketId());
    }
}
