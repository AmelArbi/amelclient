package com.valtech.bowlinggameclient.controller;

import java.net.URI;
import java.util.List;
import com.valtech.bowlinggameclient.dto.FrameDto;
import com.valtech.bowlinggameclient.dto.GameDto;
import com.valtech.bowlinggameclient.dto.PlayerNameDto;
import com.valtech.bowlinggameclient.dto.WurfDto;
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
        log.info("playerURL, {}", playerURL);
        restTemplate.put(playerURL, new PlayerNameDto(name));
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
