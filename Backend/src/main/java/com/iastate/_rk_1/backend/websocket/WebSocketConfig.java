package com.iastate._rk_1.backend.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author peyton
 */

@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndPointExport() {
        return new ServerEndpointExporter();
    }
}
