package tacocloud.demo.integrationFlow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.messaging.support.GenericMessage;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class IntegrationFlowConfig {

    @Bean
    public IntegrationFlow uppercaseFlow(){
        return IntegrationFlows
                .from("inChannel")
                .<String, String> transform(s->{
                    System.out.println(s.toUpperCase());
                    return s.toUpperCase();
                })
                .channel("outChannel")
                .get();
    }

    @Bean
    public IntegrationFlow uppercase(){
        return IntegrationFlows
                .from("outChannel")
                .<String, String> transform(s->{
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .channel("outChannel")
                .get();
    }



}
