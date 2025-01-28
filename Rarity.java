import java.util.NoSuchElementException;

public enum Rarity {
    COMMON, GREAT, RARE, EPIC, LEGENDARY;

    public static Rarity determineRarity(String s)
    {
        s = s.toLowerCase();
        switch (s)
        {
            case "common":
                return COMMON;

            case "great":
                return GREAT;

            case "rare":
                return RARE;

            case "epic":
                return EPIC;

            case "legendary":
                return LEGENDARY;

            default:
                throw new NoSuchElementException("No rarity found for " + s);
        }

    }
}
