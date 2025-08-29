package com.example.netbar.integration;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MockClients implements DeviceControlClient, CashierPaymentClient {
    @Override
    public Map<String, Object> getDeviceStatus(String externalId) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "ONLINE");
        return map;
    }

    @Override
    public boolean openMachine(String externalId, long seconds) {
        return true;
    }

    @Override
    public boolean closeMachine(String externalId) {
        return true;
    }

    @Override
    public Map<String, Object> createOrder(String orderNo, long amountFen, String subject, String notifyUrl) {
        Map<String, Object> map = new HashMap<>();
        map.put("tradeNo", "MOCK-" + orderNo);
        map.put("status", "SUCCESS");
        return map;
    }

    @Override
    public Map<String, Object> queryOrder(String orderNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "SUCCESS");
        return map;
    }

    @Override
    public boolean refund(String orderNo, long refundFen) {
        return true;
    }
}

