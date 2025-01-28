public class Item {
    private String name;
    private Rarity rarity;

    // keeps count of the number of upgrades for Epic items
    private int UpgradeCount;

    public Item(String name, Rarity rarity)
    {
        this.name = name;
        this.rarity=rarity;
    }


}
