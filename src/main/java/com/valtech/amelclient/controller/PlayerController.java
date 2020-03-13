package com.valtech.amelclient.controller;

import java.net.URI;
import java.util.List;
import javax.annotation.PostConstruct;
import com.valtech.amelclient.dto.FrameDto;
import com.valtech.amelclient.dto.GameDto;
import com.valtech.amelclient.dto.PlayerNameDto;
import com.valtech.amelclient.dto.WurfDto;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayerController {

    private RestTemplate restTemplate;
    private URI playerURL;

    public PlayerController(RestTemplate restTemplate, URI playerURL) {
        this.restTemplate = restTemplate;
        this.playerURL = playerURL;
    }

    public void playerName(String name) {
        URI playerNameResourceUrl = URI.create(playerURL.toString());
        log.info("playerURL, {}", playerNameResourceUrl);
        restTemplate.put(playerNameResourceUrl, new HttpEntity<>(new PlayerNameDto(name)));
    }

    public void addThrow(int zahl) {
        URI addThrowUrl = URI.create(playerURL.toString() + "/throw");
        log.info("addThrow, {}, zahl {}", addThrowUrl, zahl);
        restTemplate.put(addThrowUrl, new WurfDto(zahl));
    }

    public void getScores() {
        GameDto gameDto = restTemplate.getForObject(playerURL, GameDto.class);
        log.info("GamDto : {}", gameDto);
        List<FrameDto> listFrames = gameDto.getFrames();
        log.info("Number of Frames {}", listFrames.size());
        for (int j = 0; j < listFrames.size(); j++) {
            log.info("Frame nr : {}", j);
            log.info("Throws {}", listFrames.get(j).getThrowList());
        }
        log.info("PlayerName, {}", gameDto.getPlayerName());
    }

    public void playGame(String name) {
        playerName(name);
        addThrow(1);
        addThrow(1);
        addThrow(1);
        addThrow(1);

        log.info("Scores of Player with name {}",name);
        getScores();
    }

}
