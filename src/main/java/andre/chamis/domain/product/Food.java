package andre.chamis.domain.product;

import andre.chamis.utils.InputUtils;
import andre.chamis.utils.StringUtils;

import java.util.Date;

public class Food extends Product {
    protected Date expirationDt;
    protected String[] ingredients;

    public Food(){
        super();
    }

    @Override
    public void print(int padding) {
        super.print(padding);
        System.out.println(StringUtils.addPadding("- Validade: " + expirationDt, padding));
        System.out.println(StringUtils.addPadding("- Ingredientes: ", padding));
        for (String ingredient: ingredients) {
            System.out.println(StringUtils.addPadding("- " + ingredient, padding + 2));
        }
    }

    @Override
    protected void input() {
        super.input();
        this.expirationDt = InputUtils.getDateInput("Digite a data de validade do produto: ");
        this.ingredients = InputUtils.getStringArrayInput("Digite os ingredientes: ");
    }

    public static Food fromInput() {
        Food food = new Food();
        food.input();
        return food;
    }
}
