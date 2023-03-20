import java.util.Scanner;


public class AreaEstimation {

    int toolSelect;
    double durability;
    double enchantIncrease;

    double areaSelected;

    public AreaEstimation(int toolSelect, double durability, double enchantIncrease, double areaSelected) {
        this.toolSelect = toolSelect;
        this.durability = durability;
        this.enchantIncrease = enchantIncrease;
        this.areaSelected = areaSelected;
    }
    //wooden, stone, iron, gold, diamond, netherite
    //60, 132, 251, 33, 1562, 2031
    //unbreaking levels
    //1, 2, 3, 4
    //multiply durability by enchantment level
    //number calc is area/durability
    public int getToolSelect() {
        return toolSelect;
    }
    public double getDurability() {
        return durability;
    }
    public double getEnchantIncrease() {
        return enchantIncrease;
    }
    public double getAreaSelected() {
        return areaSelected;
    }
    public void setToolSelect(int toolSelect) {
        this.toolSelect = toolSelect;
        if (toolSelect == 1){
            this.durability = 60 * this.enchantIncrease;
        }
        else if (toolSelect == 2){
            this.durability = 132 * this.enchantIncrease;
        }
        else if (toolSelect == 3){
            this.durability = 251 * this.enchantIncrease;
        }
        else if (toolSelect == 4){
            this.durability = 33 * this.enchantIncrease;
        }
        else if (toolSelect == 5){
            this.durability = 1562 * this.enchantIncrease;
        }
        else if (toolSelect == 6){
            this.durability = 2031 * this.enchantIncrease;
        }
    }
    public void setEnchantIncrease(double enchantIncrease) {
        this.enchantIncrease = enchantIncrease;
        if (this.toolSelect == 1){
            this.durability = 60 * this.enchantIncrease;
        }
        else if (this.toolSelect == 2){
            this.durability = 132 * this.enchantIncrease;
        }
        else if (this.toolSelect == 3){
            this.durability = 251 * this.enchantIncrease;
        }
        else if (this.toolSelect == 4){
            this.durability = 33 * this.enchantIncrease;
        }
        else if (this.toolSelect == 5){
            this.durability = 1562 * this.enchantIncrease;
        }
        else if (this.toolSelect == 6){
            this.durability = 2031 * this.enchantIncrease;
        }
    }
    public void setAreaSelected(double areaSelected) {
        this.areaSelected = areaSelected;
    }
}