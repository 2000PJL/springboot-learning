package com.hunau;

import com.hunau.netty.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hunau.bluetooth228.BluetoothServer;

@SpringBootApplication
@MapperScan(basePackages = "com.hunau")
public class Web228Application {
    public static void main(String[] args) {
        SpringApplication.run(Web228Application.class, args);
        new BluetoothServer().start();
        new NettyServer(5000).start();
    }

}
