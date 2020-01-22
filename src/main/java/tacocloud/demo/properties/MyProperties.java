package tacocloud.demo.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "tacocloud.email")
public class MyProperties {
    private String host;
}
