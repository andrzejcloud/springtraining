package tacocloud.demo.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import tacocloud.demo.data.IngredientRepo;
import tacocloud.demo.domain.Dog;
import tacocloud.demo.service.ServiceBean;
import tacocloud.demo.service.ServiceBeanOne;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/data")
@Scope("request")
@CrossOrigin(origins="*")
public class DataController {

    @Autowired
    ServiceBean serviceBean;

    @Autowired
    IngredientRepo ingredientRepo;

    List<Dog> l = new ArrayList<Dog>();

    //@Autowired
    public DataController(ServiceBean serviceBean) {
        //this.serviceBean = serviceBean;

    }

    @PostConstruct
    public void init(){
        l.add(new Dog("Reksio", 100));
        l.add(new Dog("Fafik", 101));
        l.add(new Dog("Pluto", 102));
    }

    @GetMapping("/bean")
    public ResponseEntity<String> getBean(){
        String controller = serviceBean.getController();
        serviceBean.setController(this.toString());
        return new ResponseEntity<String>("controller:"+this.toString()+"\nserviceBean:"+serviceBean.toString()+" controller: "+controller, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getData(@PathVariable int id){
        Dog d = new Dog("Reksio", 100);
        log.info("Parameter submitted: " + id);
        return new ResponseEntity(Optional.of(d), HttpStatus.OK);

    }

    @GetMapping("/lista")
    public ResponseEntity<List<Dog>> getDataL(){
        Dog d = new Dog("Reksio", 100);
        l.add(new Dog("Reksio", 100));
        l.add(new Dog("Fafik", 101));
        l.add(new Dog("Pluto", 102));

        return new ResponseEntity(Optional.of(l), HttpStatus.OK);

    }

    @GetMapping("/flux")
    public ResponseEntity<Flux<Dog>> getDataFlux(){
        Dog d = new Dog("Reksio", 100);
        l.add(new Dog("Reksio", 100));
        l.add(new Dog("Fafik", 101));
        l.add(new Dog("Pluto", 102));

        return new ResponseEntity(Flux.fromIterable(l).delayElements(Duration.ofMillis(1000)), HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<Dog> getDataPost(@RequestBody Dog dog){
        log.info("Dog submitted: " + dog.getName());
        return new ResponseEntity(Optional.of(dog), HttpStatus.OK);
    }
}
