package tacocloud.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacocloud.demo.data.IngredientRepo;
import tacocloud.demo.data.TacoRepo;
import tacocloud.demo.domain.Ingredient;
import tacocloud.demo.domain.Order;
import tacocloud.demo.domain.Taco;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static tacocloud.demo.domain.Ingredient.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepo ingredientRepo;

    private TacoRepo designRepo;

    @Autowired
    public DesignTacoController(
            IngredientRepo ingredientRepo,
            TacoRepo designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }

    @GetMapping()
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
                ingredientRepo.findAll().forEach(i -> ingredients.add(i));
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        model.addAttribute("design", new Taco());
        return "design";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(
            @Valid Taco design, Errors errors,
            @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }
        Taco saved = designRepo.save(design);
        //order.addDesign(saved);
        return "redirect:/orders/current";
    }
}
