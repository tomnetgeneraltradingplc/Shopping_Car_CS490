package edu.mum.cs490.shoppingcart.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.*;

import edu.mum.cs490.shoppingcart.domain.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 * Created by Ezequiel Suarez Buitrago, Thomas Tibebu,
 * Innocent Kateba, shuling he, Wenxin He, Tram Ly
 * Date April 20, 2019
 **/
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{


    @Query("select distinct o from OrderDetail o where o.order.orderDate between :begin_Date and :end_Date " +
            "group by o.product.category.id, o.order.id, o.product.id, o.product.vendor.id " +
            "order by o.product.vendor.id, o.product.category.id ")
    List<OrderDetail> findByDate(@Param("begin_Date") Date begin_Date, @Param("end_Date") Date end_Date);

    @Query("select distinct o from OrderDetail o where o.product.vendor.id in :vendor_Ids and o.order.orderDate between :begin_Date and :end_Date " +
            "group by o.product.category.id, o.order.id, o.product.id, o.product.vendor.id " +
            "order by o.product.vendor.id, o.product.category.id ")
    List<OrderDetail> findByVendor_Id(@Param("vendor_Ids") List<Integer> vendor_Ids, @Param("begin_Date") Date begin_Date, @Param("end_Date") Date end_Date);

    @Query("select distinct o from OrderDetail o where o.product.category.id in :category_Ids and o.order.orderDate between :begin_Date and :end_Date " +
            "group by o.product.category.id, o.order.id, o.product.id, o.product.vendor.id " +
            "order by o.product.vendor.id, o.product.category.id ")
    List<OrderDetail> findByCategory_Id(@Param("category_Ids") List<Integer> category_Ids, @Param("begin_Date") Date begin_Date, @Param("end_Date") Date end_Date);

    @Query("select distinct o from OrderDetail o where o.product.vendor.id in :vendor_Ids and o.product.category.id in :category_Ids and o.order.orderDate between :begin_Date and :end_Date " +
            "group by o.product.category.id, o.order.id, o.product.id, o.product.vendor.id " +
            "order by o.product.vendor.id, o.product.category.id ")
    List<OrderDetail> findByVendor_IdAndCategory_Id(@Param("vendor_Ids") List<Integer> vendor_Ids, @Param("category_Ids") List<Integer> category_Ids, @Param("begin_Date") Date begin_Date, @Param("end_Date") Date end_Date);

}
