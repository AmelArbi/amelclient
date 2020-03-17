package com.valtech.bowlinggameclient;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import com.valtech.bowlinggameclient.controller.PlayerController;
import com.valtech.bowlinggameclient.dto.FrameDto;
import com.valtech.bowlinggameclient.dto.GameDto;
import com.valtech.bowlinggameclient.dto.PlayerNameDto;
import com.valtech.bowlinggameclient.dto.WurfDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerControllerTest {

    private RestTemplate restTemplate;

    private URI playerUrl = URI.create("http://localhost:8080/api/game/1/player/1");

    private PlayerController playerController;

    @Before
    public void init() {
        restTemplate = Mockito.mock(RestTemplate.class);
        playerController = new PlayerController(restTemplate, playerUrl);

    }

    @Test
    public void playerName() {
        playerController.playerName("Alex");

        verify(restTemplate).put(Mockito.eq(playerUrl), Mockito.eq(new PlayerNameDto("Alex")));

    }

    @Test
    public void addThrow() {
        URI addThrowUrl = URI.create("http://localhost:8080/api/game/1/player/1/throw");

        playerController.addThrow(10);

        verify(restTemplate).put(Mockito.eq(addThrowUrl), Mockito.eq(new WurfDto(10)));
    }

    @Test
    public void getScores() {
        List<FrameDto> frameDtoList = Arrays.asList(new FrameDto());
        GameDto gameDto = new GameDto(0, frameDtoList, "Alex");

        when(restTemplate.getForObject(playerUrl, GameDto.class))
                .thenReturn(gameDto);

        playerController.getScores();

        verify(restTemplate).getForObject(playerUrl, GameDto.class);
    }

}
