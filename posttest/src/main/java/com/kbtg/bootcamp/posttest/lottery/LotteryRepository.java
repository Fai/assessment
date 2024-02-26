package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, String>{

    @Query(value = "SELECT l FROM lotteries WHERE amount > 0",
            nativeQuery = true)
    List<Lottery> getLotteries();

    @Query(value = "INSERT INTO lotteries (id, price, amount) VALUES (:id, :price, :amount)",
            nativeQuery = true)
    void saveLottery(String id, Integer price, Integer amount);

    @Query (value = "DELETE FROM lotteries WHERE id = :id",
            nativeQuery = true)
    void deleteLottery(String id);

    @Modifying
    @Query (value = "UPDATE loterries SET amount = :amount WHERE id = :id",
            nativeQuery = true)
    void updateLottery(String id, Integer amount);
}
