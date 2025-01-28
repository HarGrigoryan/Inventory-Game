import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Item {
    private final String name;
    private Rarity rarity;

    // keeps count of the number of upgrades for Epic items
    private Integer upgradeCount;

    public Item(String name, Rarity rarity)
    {
        this.name = name;
        this.rarity=rarity;
        upgradeCount=null;
    }

    public Item(String name, Rarity rarity, Integer upgradeCount)
    {
        this.name=name;
        this.rarity= rarity;
        this.upgradeCount = upgradeCount;
    }

    public Rarity getRarity()
    {
        return rarity;
    }

    public String getName() {
        return name;
    }

    public Integer getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(Integer upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public static ArrayList<Item> loadItems(String path)
    {
        Scanner sc = null;
        try
        {
            sc = new Scanner(new FileInputStream(path));
        }
        catch(IOException e)
        {
            System.out.println("Error:" + e.getMessage());
            System.exit(0);
        }
        int size = sc.nextInt();
        sc.hasNext();
        ArrayList<Item> items= new ArrayList<>(size);
        for (int i =0; sc.hasNextLine(); i++)
        {
            String[] itemComponents = sc.nextLine().split(" ");
            int lineSize = itemComponents.length;
            String name = Utilities.combineStrings(itemComponents, 0, lineSize-2);
            Rarity r = Rarity.determineRarity(itemComponents[lineSize-2]);
            String lastComponent = itemComponents[lineSize-1];
            if(lastComponent.equals("null"))
            {
                items.add(new Item(name, r));
            }
            else
            {
                items.add(new Item(name, r, Integer.valueOf(lastComponent)));
            }
        }
        return items;
    }


}
