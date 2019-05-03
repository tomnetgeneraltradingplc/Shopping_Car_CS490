package edu.mum.cs490.shoppingcart.repository;

import edu.mum.cs490.shoppingcart.domain.Admin;
import edu.mum.cs490.shoppingcart.domain.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public interface AdminRepository extends UserRepository<Admin> {

    @Query("SELECT a FROM Admin a WHERE " +
            "(:username IS NULL OR a.username like %:username%) AND " +
            "(:firstName IS NULL OR a.firstName like %:firstName%) AND " +
            "(:lastName IS NULL OR a.lastName like %:lastName%) AND " +
            "((:status IS NULL AND a.status = 'ENABLED') OR (a.status =:status))")
    List<Admin> find(@Param("username") String username, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("status") Status status);

    @Query("SELECT a FROM Admin a WHERE (:username IS NULL OR a.username like %:username%) AND " +
            "(:firstName IS NULL OR a.firstName like %:firstName%) AND " +
            "(:lastName IS NULL OR a.lastName like %:lastName%) AND " +
            "((:status IS NULL AND a.status = 'ENABLED') OR (a.status =:status))")
    Page<Admin> findPage(@Param("username") String username, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("status") Status status, Pageable pageable);

}
