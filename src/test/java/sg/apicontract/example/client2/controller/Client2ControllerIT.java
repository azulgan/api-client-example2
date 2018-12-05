package sg.apicontract.example.client2.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import sg.apicontract.example.client2.dto.ProcessResultBean;

/**
 * (c) aguegan, 2018
 * User: aguegan
 * Date: 12/5/18
 * Time: 12:50 PM
 */
@Slf4j
public class Client2ControllerIT {
    @Test
    public void testProcess() {
        RestTemplate restTemplate = new RestTemplate();
        ProcessResultBean res = restTemplate.getForObject("http://localhost:8090/process", ProcessResultBean.class);
        log.info(res.toString());
        Assert.assertEquals("Processed: calculation", res.getMessage());
        Assert.assertEquals("Test: World", res.getGreeting());
    }

}
