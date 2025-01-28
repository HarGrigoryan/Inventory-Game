import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory(ArrayList<Item> items)
    {
        this.items = items;
    }

    public void upgradeEpic(int upgradableIndex, int secondIndex, int thirdIndex) throws Exception
    {
        Item upgradable = items.get(upgradableIndex);
        if(upgradable.getRarity() != Rarity.EPIC)
        {
            throw new Exception("The selected item is not an Epic item.");
        }
        else
        {
            int upgradeCount = upgradable.getUpgradeCount();
            Item secondItem = items.get(secondIndex);
            if(upgradeCount<2)
            {
                if(upgradeCount==0 && secondItem.getRarity()==Rarity.EPIC)
                {
                    upgradable.setUpgradeCount(1);
                    items.remove(secondIndex);
                } else if (upgradeCount==1 && secondItem.getRarity()==Rarity.EPIC)
                {
                    upgradable.setUpgradeCount(2);
                    items.remove(secondIndex);
                }
                else
                {
                    throw new Exception("The second item is not EPIC");
                }
            }
            else
            {
                String secondName = secondItem.getName();
                if(secondName.equals(items.get(thirdIndex).getName()) && upgradable.getName().equals(secondName))
                {
                    upgradable.setRarity(Rarity.LEGENDARY);
                    upgradable.setUpgradeCount(null);
                    items.remove(secondIndex);
                    items.remove(thirdIndex);
                }
                else
                {
                    throw new Exception("Incorrect combination");
                }
            }
        }
    }

    public void upgradeNonEpics(int first, int second, int third) throws Exception
    {
        String firstName = items.get(first).getName();
        String secondName = items.get(second).getName();
        String thirdName = items.get(third).getName();
        if(firstName.equals(secondName) && secondName.equals(thirdName))
        {
            Item upgradable = items.get(first);
            items.remove(second);
            items.remove(third);
            if(upgradable.getRarity()==Rarity.COMMON)
                upgradable.setRarity(Rarity.GREAT);
            else if(upgradable.getRarity()==Rarity.GREAT)
                upgradable.setRarity(Rarity.RARE);
            else
                upgradable.setRarity(Rarity.EPIC);
        }
        else
        {
            throw new Exception("Incorrect combination");
        }
    }
}
