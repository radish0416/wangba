package com.example.netbar.integration;

import java.util.Map;

/**
 * Adapter interface for external device control/monitor systems.
 * Implementations should call the vendor API.
 */
public interface DeviceControlClient {
    Map<String, Object> getDeviceStatus(String externalId);
    boolean openMachine(String externalId, long seconds);
    boolean closeMachine(String externalId);
}

