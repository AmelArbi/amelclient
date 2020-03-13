package com.valtech.bowlinggameclient.controller;

import java.net.URI;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GameController {

    private RestTemplate restTemplate;
    private PlayerController playerController;

    public GameController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public URI startGame() {
        URI startGameResourceUrl = URI.create("http://localhost:8080/api/game");
        URI location = restTemplate.postForLocation(startGameResourceUrl, Void.class);
        log.info("a new game is created with location {}", location);
        return location;
    }

    public URI addPlayer(URI gameURL) {
        URI addPlayerResourceUrl = URI.create(gameURL + "/player");
        log.info("addPlayer URL, {}", addPlayerResourceUrl);
        URI location = restTemplate.postForLocation(addPlayerResourceUrl, Void.class);
        log.info("a new player game is created with location, {}", location);
        playerController = new PlayerController(restTemplate, location);
        return location;
    }

    @PostConstruct
    public void startBowlingGameClient() {
        URI gameURL = startGame();
        for (int i = 0; i < 2; i++) {
            URI firstPlayerUrl = addPlayer(gameURL);
            new PlayerController(restTemplate, firstPlayerUrl).playGame("Player " + i);
        }

    }

    //@PreDestroy//Methode wird befor das Object ins GC landet

}
