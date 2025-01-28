import java.util.ArrayList;
import java.util.Collections;

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

    public void upgradeNonEpics(int firstIndex, int secondIndex, int thirdIndex) throws Exception
    {
        String firstName = items.get(firstIndex).getName();
        String secondName = items.get(secondIndex).getName();
        String thirdName = items.get(thirdIndex).getName();
        if(firstName.equals(secondName) && secondName.equals(thirdName))
        {
            Item upgradable = items.get(firstIndex);
            if(upgradable.getRarity()==Rarity.COMMON)
                upgradable.setRarity(Rarity.GREAT);
            else if(upgradable.getRarity()==Rarity.GREAT)
                upgradable.setRarity(Rarity.RARE);
            else {
                upgradable.setRarity(Rarity.EPIC);
                upgradable.setUpgradeCount(0);
            }
            items.remove(secondIndex);
            items.remove(thirdIndex);
        }
        else
        {
            throw new Exception("Incorrect combination");
        }
    }

    @Override
    public String toString() {
        Collections.sort(items);
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sB.append(i + ": " +items.get(i).toString());
            sB.append("\n");
        }
        return sB.toString();
    }
}
