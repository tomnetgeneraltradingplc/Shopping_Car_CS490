package edu.mum.cs490.shoppingcart.repository;

import edu.mum.cs490.shoppingcart.domain.Slider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Ezequiel Suarez Buitrago, Thomas Tibebu,
 * Innocent Kateba, shuling he, Wenxin He, Tram Ly
 * Date April 20, 2019
 **/

@Repository
public interface SliderRepository extends CrudRepository<Slider, Integer> {
}
