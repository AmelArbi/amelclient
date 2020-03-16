package com.valtech.bowlinggameclient;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import com.valtech.bowlinggameclient.controller.PlayerController;
import com.valtech.bowlinggameclient.dto.FrameDto;
import com.valtech.bowlinggameclient.dto.GameDto;
import com.valtech.bowlinggameclient.dto.PlayerNameDto;
import com.valtech.bowlinggameclient.dto.WurfDto;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@RestClientTest(PlayerController.class)
public class PlayerControllerTest {

    @Mock
    private RestTemplate restTemplate;


    private URI playerUrl= URI.create("http://localhost:8080/api/game/1/player/1");

    @InjectMocks
    private PlayerController playerController;

//    @Before
//    public void intiUrl() {
//        playerController = Mockito.mock(PlayerController.class);
//    }

    @Test
    public void playerName() {
        verify(playerController).playerName("Alex");
    }

    @Test
    public void addThrow() {
        verify(playerController).addThrow(10);
    }

    @Test
    public void getScores() {
        GameDto gameDto = new GameDto();

        when(restTemplate.getForObject(playerUrl, GameDto.class))
                .thenReturn(gameDto);

        verify(playerController).getScores();
    }

}
