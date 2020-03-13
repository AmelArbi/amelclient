package com.valtech.bowlinggameclient;

import java.net.URI;
import com.valtech.bowlinggameclient.controller.PlayerController;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@RestClientTest(PlayerController.class)
public class PlayerControllerTest {
    @Mock
    private RestTemplate restTemplate;

    @Mock
    private URI playerURL;

    @InjectMocks
    private PlayerController playerController;





}
