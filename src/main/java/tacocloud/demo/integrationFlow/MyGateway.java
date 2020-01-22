package tacocloud.demo.integrationFlow;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel="inChannel", defaultReplyChannel="outChannel")
public interface MyGateway {
    String uppercase(String in);
}
