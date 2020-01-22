package tacocloud.demo.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Scope("session")
@Getter
@Setter
public class ServiceBean {
    String controller;
}
