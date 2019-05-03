package edu.mum.cs490.shoppingcart.repository;

import edu.mum.cs490.shoppingcart.domain.Address;
import edu.mum.cs490.shoppingcart.domain.Status;
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
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByUser_idAndStatus(Integer userId, Status status);

    @Query("update Address a set a.status = 'DISABLED' where a.id = :addressId")
    @Modifying
    void disableAddress(@Param("addressId") Integer addressId);
}
