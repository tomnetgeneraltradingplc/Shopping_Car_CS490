package edu.mum.cs490.shoppingcart.repository;

import edu.mum.cs490.shoppingcart.domain.CardDetail;
import edu.mum.cs490.shoppingcart.domain.Guest;
import edu.mum.cs490.shoppingcart.domain.Status;
import edu.mum.cs490.shoppingcart.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by Ezequiel Suarez Buitrago, Thomas Tibebu,
 * Innocent Kateba, shuling he, Wenxin He, Tram Ly
 * Date April 20, 2019
 **/
@Repository
public interface CardDetailRepository extends JpaRepository<CardDetail, Integer> {

    CardDetail findByOwner(User owner);

    CardDetail findByGuest(Guest guest);

    List<CardDetail> findByOwner_idAndStatus(Integer ownerId, Status status);

    @Query("update CardDetail c set c.status = 'DISABLED' where c.id = :cardId")
    @Modifying
    void disableCard(@Param("cardId") Integer cardId);

}
