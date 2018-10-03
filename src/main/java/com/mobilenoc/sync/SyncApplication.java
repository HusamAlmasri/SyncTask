package com.mobilenoc.sync;

import com.mobilenoc.sync.controller.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SyncApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SyncApplication.class, args);

        MainController mainController = (MainController) ctx.getBean("mainController");
        mainController.checking();
    }
}
