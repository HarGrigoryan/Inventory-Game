import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Item implements Comparable<Item> {
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
        sc.nextLine();
        ArrayList<Item> items= new ArrayList<>(size);
        while (sc.hasNextLine())
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

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Item o) {
        return rarity.ordinal()-o.rarity.ordinal();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(name);
        s.append(" ");
        s.append(rarity);
        if(upgradeCount!=null) {
            s.append(" ");
            s.append(upgradeCount);
        }
        return s.toString();
    }
}
