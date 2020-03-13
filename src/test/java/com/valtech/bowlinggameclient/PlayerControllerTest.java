package com.valtech.bowlinggameclient;

import java.net.URI;
import com.valtech.bowlinggameclient.controller.PlayerController;
import com.valtech.bowlinggameclient.dto.PlayerNameDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@RestClientTest(PlayerController.class)
public class PlayerControllerTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private URI playerUrl;

    @InjectMocks
    private PlayerController playerController;

    @Test
    public void playerName() {





    }

}
