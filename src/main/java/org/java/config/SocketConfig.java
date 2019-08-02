package org.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Auther: 昌子豪
 * @Date: 2019/7/31 15:40
 * @Description: Frighting!!!
 */

@Configuration
public class SocketConfig {


    @Bean
    public ServerEndpointExporter serverEndpointExporter(){

        System.out.println("-------扫描所有socket服务类-------");

        ServerEndpointExporter serverEndpointExporter = new ServerEndpointExporter();
        return serverEndpointExporter;
    }
}
