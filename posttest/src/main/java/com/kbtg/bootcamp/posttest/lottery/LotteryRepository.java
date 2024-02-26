package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, String>{
    @Query("SELECT l FROM lotteries")
    List<Lottery> findAllLottery();

    @Query("INSERT INTO lotteries (id, price, amount) VALUES (:id, :price, :amount)")
    void saveLottery(String id, Integer price, Integer amount);

    @Query ("DELETE FROM lotteries WHERE id = :id")
    void deleteLottery(String id);

    @Modifying
    @Query ("UPDATE loterries SET amount = :amount WHERE id = :id")
    void updateLottery(String id, Integer amount);
}
