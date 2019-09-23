package tacocloud.demo.data;

import tacocloud.demo.domain.Taco;

public interface TacoRepo {
    Taco save(Taco design);
}
