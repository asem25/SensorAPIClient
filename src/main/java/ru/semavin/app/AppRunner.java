package ru.semavin.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import ru.semavin.app.models.Measurement;
import ru.semavin.app.models.Sensor;
import ru.semavin.app.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class AppRunner implements CommandLineRunner {
    private final UserService userService;
    @Autowired
    public AppRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Sensor sensor1 = userService.getSensor(9);

        Random random = new Random();


        for (int i = 0; i < 1000; i++) {
            System.out.println(userService
                    .addMeasurement(new Measurement(- 100 + (200 * random.nextDouble()),
                            true,
                            sensor1)));
        }


    }
}
