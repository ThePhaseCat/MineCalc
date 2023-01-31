import java.util.Scanner;


public class AreaEstimation {

    int revertState = 0;

    public void hi() {
        System.out.println("test");
    }


    public void EstimateArea(int area) {
        Scanner keyboard = new Scanner(System.in);
        int pickSelect = 0;
        int selector = 0;
        String pickaxe = "";
        int enchantLevel = 0;
        double durability = 0;
        double enchantIncrease = 0;
        String enchant = "";

        System.out.println("Are you using a pickaxe or shovel?");
        System.out.println("1. Pickaxe");
        System.out.println("2. Shovel");
        selector = keyboard.nextInt();

        if (selector == 1){
            System.out.println("What pickaxe are you using?");
            System.out.println("1. Wooden");
            System.out.println("2. Stone");
            System.out.println("3. Iron");
            System.out.println("4. Gold");
            System.out.println("5. Diamond");
            System.out.println("6. Netherite");
            pickSelect = keyboard.nextInt();

            if (pickSelect == 1){
                durability = 60;
                pickaxe = "Wooden";
            }
            if (pickSelect == 2){
                durability = 132;
                pickaxe = "Stone";
            }
            if (pickSelect == 3){
                durability = 251;
                pickaxe = "Iron";
            }
            if (pickSelect == 4){
                durability = 33;
                pickaxe = "Gold";
            }
            if (pickSelect == 5){
                durability = 1562;
                pickaxe = "Diamond";
            }
            if (pickSelect == 6){
                durability = 2032;
                pickaxe = "Netherite";
            }

            System.out.println("What enchantment level of Unbreaking are you using?");
            System.out.println("1. 0");
            System.out.println("2. Unbreaking 1");
            System.out.println("3. Unbreaking 2");
            System.out.println("4. Unbreaking 3");
            enchantLevel = keyboard.nextInt();

            if (enchantLevel == 1){
                enchantIncrease = 1;
                enchant = "no Unbreaking";
            }
            if (enchantLevel == 2){
                enchantIncrease = 2;
                enchant = "Unbreaking 1";
            }
            if (enchantLevel == 3){
                enchantIncrease = 3;
                enchant = "Unbreaking 2";
            }
            if (enchantLevel == 4){
                enchantIncrease = 4;
                enchant = "Unbreaking 3";
            }

            //get new durability number
            durability = durability * enchantIncrease;
            double numOfPicks = area/durability;
            System.out.println("You require " + numOfPicks + " " + pickaxe + " pickaxe's to clear an area of " + area + " blocks");
            revertState = 1;
        }
        if (selector == 2){
            System.out.println("What shovel are you using?");
            System.out.println("1. Wooden");
            System.out.println("2. Stone");
            System.out.println("3. Iron");
            System.out.println("4. Gold");
            System.out.println("5. Diamond");
            System.out.println("6. Netherite");
            pickSelect = keyboard.nextInt();

            if (pickSelect == 1){
                durability = 60;
                pickaxe = "Wooden";
            }
            if (pickSelect == 2){
                durability = 132;
                pickaxe = "Stone";
            }
            if (pickSelect == 3){
                durability = 251;
                pickaxe = "Iron";
            }
            if (pickSelect == 4){
                durability = 33;
                pickaxe = "Gold";
            }
            if (pickSelect == 5){
                durability = 1562;
                pickaxe = "Diamond";
            }
            if (pickSelect == 6){
                durability = 2032;
                pickaxe = "Netherite";
            }

            System.out.println("What enchantment level of Unbreaking are you using?");
            System.out.println("1. 0");
            System.out.println("2. Unbreaking 1");
            System.out.println("3. Unbreaking 2");
            System.out.println("4. Unbreaking 3");
            enchantLevel = keyboard.nextInt();

            if (enchantLevel == 1){
                enchantIncrease = 1;
                enchant = "no Unbreaking";
            }
            if (enchantLevel == 2){
                enchantIncrease = 2;
                enchant = "Unbreaking 1";
            }
            if (enchantLevel == 3){
                enchantIncrease = 3;
                enchant = "Unbreaking 2";
            }
            if (enchantLevel == 4){
                enchantIncrease = 4;
                enchant = "Unbreaking 3";
            }

            //get new durability number
            durability = durability * enchantIncrease;
            double numOfPicks = area/durability;
            System.out.println("You require " + numOfPicks + " " + pickaxe + " shovels to clear an area of " + area + " blocks");
            revertState = 1;
        }
    }


    public int revert(){
        return revertState;
    }
}