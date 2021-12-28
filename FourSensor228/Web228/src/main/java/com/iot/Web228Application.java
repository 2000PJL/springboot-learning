package com.iot;

import com.iot.bluetooth228.BluetoothServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.iot")
public class Web228Application {
    public static void main(String[] args) {
        SpringApplication.run(Web228Application.class, args);
        new BluetoothServer().start();
    }

}
