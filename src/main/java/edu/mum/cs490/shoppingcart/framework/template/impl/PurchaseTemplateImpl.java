package edu.mum.cs490.shoppingcart.framework.template.impl;

import edu.mum.cs490.shoppingcart.domain.CardDetail;
import edu.mum.cs490.shoppingcart.domain.Order;
import edu.mum.cs490.shoppingcart.domain.TransactionType;
import edu.mum.cs490.shoppingcart.framework.observer.NotifierSubject;
import edu.mum.cs490.shoppingcart.framework.observer.TransferSubject;
import edu.mum.cs490.shoppingcart.framework.template.TransactionTemplate;
import edu.mum.cs490.shoppingcart.service.PaymentService;
/**
 * Created by Ezequiel Suarez Buitrago, Thomas Tibebu,
 * Innocent Kateba, shuling he, Wenxin He, Tram Ly
 * Date April 20, 2019
 **/
public class PurchaseTemplateImpl extends TransactionTemplate {

    private final Order order;

    private final CardDetail OSSCardDetail;

    private final NotifierSubject notifierSubject;

    private final TransferSubject transferSubject;

    private final PaymentService paymentService;

    public PurchaseTemplateImpl(Order order, CardDetail OSSCardDetail, NotifierSubject notifierSubject, TransferSubject transferSubject, PaymentService paymentService) {
        this.order = order;
        this.OSSCardDetail = OSSCardDetail;
        this.notifierSubject = notifierSubject;
        this.transferSubject = transferSubject;
        this.paymentService = paymentService;
    }


    @Override
    protected Integer doTransaction() {
        return paymentService.doTransaction("" + System.currentTimeMillis(),
                order.getCard().getCardNumber(),
                order.getCard().getCardExpirationDate(),
                order.getCard().getCardHolderName(),
                order.getCard().getCvv(),
                order.getCard().getZipcode(),
                order.getCard().getCardType(),
                order.getTotalPriceWithTax(),
                OSSCardDetail.getCardNumber(),
                TransactionType.PURCHASE);
    }

    @Override
    protected void notifyPurchase() {
        try {
            notifierSubject.doNotify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void transfer() {
        try {
            transferSubject.doNotify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
