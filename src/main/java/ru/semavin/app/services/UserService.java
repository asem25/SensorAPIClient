package ru.semavin.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.semavin.app.models.Measurement;
import ru.semavin.app.models.Sensor;

import java.util.List;

@Service
public class UserService {
    private final RestTemplate restTemplate;
    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String addSensor(Sensor sensor){
        String url = "http://localhost:8080/sensors/registration";

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Sensor> sensorHttpEntity = new HttpEntity<>(sensor, headers);

        return restTemplate.postForObject(url, sensorHttpEntity, String.class);
    }

    public String addMeasurement(Measurement measurement){
        String url = "http://localhost:8080/measurements/add";

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Measurement> measurementHttpEntity = new HttpEntity<>(measurement, headers);

        return restTemplate.postForObject(url, measurementHttpEntity, String.class);
    }
    public Sensor getSensor(Integer id){
        String url = "http://localhost:8080/sensors/" + id;
        return restTemplate.getForObject(url, Sensor.class);
    }

}
