package tacocloud.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reactive {
    @Test
    public static void main(String[] args){

        Flux<Long> f = Flux.interval(Duration.ofSeconds(1)).take(5);
        StepVerifier.create(f)
                .expectNext(0L)
                .expectNext(1L)
                .expectNext(2L)
                .expectNext(3L)
                .expectNext(4L)
                .verifyComplete();
        f.subscribe(System.out::println);

        Reactive r = new Reactive();
        String name = "Craig";
        Mono.just(name).map(n->n.toUpperCase())
                .map(cn->"Hello "+cn)
                .subscribe(r::printer);

        List<String> list = new ArrayList<String>();
        list.add("Craig");
        list.add("Linda");
        list=list.stream()
                .map(n->n.toUpperCase())
                .map(cn->"Hello "+cn)
                .collect(Collectors.toList());
        System.out.println(list);

        Flux<String> fruitFlux = Flux
                .just("Apple", "Orange", "Grape", "Banana", "Strawberry");

        StepVerifier.create(fruitFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();

        fruitFlux.subscribe(System.out::println);

    }

    public void printer(String n){
        System.out.println(n);
    }
}
