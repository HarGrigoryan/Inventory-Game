public class Utilities {

    public static String combineStrings(String[] strings, int low, int high)
    {
        StringBuilder combined = new StringBuilder();
        for (int i = low; i < high; i++) {
            combined.append(strings[i]);
            if(i!=high-1)
                combined.append(" ");
        }
        return strings.toString();
    }
}
