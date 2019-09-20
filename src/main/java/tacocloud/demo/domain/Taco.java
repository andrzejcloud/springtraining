package tacocloud.demo.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {
    @NotNull
    @Size(min=5, message="minimum 5 znaków")
    private String name;
    @Size(min=1, message="minimum jeden składnik")
    private List<String> ingredients;
}
