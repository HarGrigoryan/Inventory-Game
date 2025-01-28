public class Main {
    public static void main(String[] args) {
        System.out.println("Hello dear Friend welcome or welcome back to your Inventory");
        Display d = new Display(args[0]);
        while (true) {
            d.play();
        }
    }
}
