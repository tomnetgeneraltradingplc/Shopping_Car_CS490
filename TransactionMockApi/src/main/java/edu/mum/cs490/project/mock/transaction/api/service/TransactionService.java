/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.shoppingcart.mock.transaction.api.service;

import edu.mum.cs490.shoppingcart.mock.transaction.api.entity.Account;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by Ezequiel Suarez Buitrago, Thomas Tibebu,
 * Innocent Kateba, shuling he, Wenxin He, Tram Ly
 * Date April 20, 2019
 **/
public interface TransactionService {

    String doTransaction(String requestStr);
    Account refreshAccount(Account account);

}
