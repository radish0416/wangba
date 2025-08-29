package com.example.netbar.integration;

import java.util.Map;

/**
 * Adapter interface for external cashier/payment system.
 */
public interface CashierPaymentClient {
    Map<String, Object> createOrder(String orderNo, long amountFen, String subject, String notifyUrl);
    Map<String, Object> queryOrder(String orderNo);
    boolean refund(String orderNo, long refundFen);
}

