package com.valtech.bowlinggameclient;

import java.net.URI;
import com.valtech.bowlinggameclient.controller.GameController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private GameController gameController;

    @Test
    public void startGameTest() {
        URI startGameResourceUrl = URI.create("http://localhost:8080/api/game");
        URI location = URI.create("http://localhost:8080/api/game/1");

        when(restTemplate.postForLocation(startGameResourceUrl,Void.class))
        .thenReturn(location);

        URI actual = gameController.startGame();
        assertThat(actual, is(location));
    }

    @Test
    public void addPlayerTest() {
        URI gameUrl =  URI.create("http://localhost:8080/api/game/1");
        URI startGameResourceUrl = URI.create("http://localhost:8080/api/game/1/player");
        URI location = URI.create("http://localhost:8080/api/game/1/player/1");

        when(restTemplate.postForLocation(startGameResourceUrl,Void.class))
                .thenReturn(location);

        assertThat(gameController.addPlayer(gameUrl), is(location));
    }

}
