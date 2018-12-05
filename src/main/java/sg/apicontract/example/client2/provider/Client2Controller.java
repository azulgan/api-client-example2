package sg.apicontract.example.client2.provider;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import sg.apicontract.example.client2.dto.ProcessResultBean;
import sg.apicontract.example.provider.dto.GreetingBean;

@Controller
public class Client2Controller {

    @RequestMapping(value = "/process", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ProcessResultBean process(@RequestParam(name="processName", required=false, defaultValue="calculation") String name) {
        RestTemplate restTemplate = new RestTemplate();
        GreetingBean res = restTemplate.getForObject("http://localhost:8080/greeting", GreetingBean.class);
        ProcessResultBean ret = new ProcessResultBean("Processed(2): " + name, res.getMessage());
        return ret;
    }
 
}