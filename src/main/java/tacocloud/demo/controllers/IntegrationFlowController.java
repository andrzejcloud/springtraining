package tacocloud.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tacocloud.demo.integrationFlow.MyGateway;
import tacocloud.demo.properties.MyProperties;

@Slf4j
@RestController
@RequestMapping("/integration")
public class IntegrationFlowController {

    @Autowired
    MyGateway myGateway;

    @Autowired
    MyProperties myProperties;

    @GetMapping()
    public ResponseEntity<String> getBean(){
        return new ResponseEntity<String>("controller:"+myGateway.uppercase(this.toString()), HttpStatus.OK);

    }

    @GetMapping("/properties")
    public ResponseEntity<String> getBeanProperties(){
        return new ResponseEntity<String>("controller:"+myProperties.getHost(), HttpStatus.OK);

    }
}
