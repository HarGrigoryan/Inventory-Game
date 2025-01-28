import java.util.*;

public class Display {
    private Inventory inventory;

    public Display(String path)
    {
        inventory = new Inventory(Item.loadItems(path));
    }

    public void play()
    {
        System.out.println("The available commands are as follows:");
        System.out.println("\033[38;5;" + 28 + "m" + "1:Display the Inventory\n2:Upgrade items\n3.Exit" + "\033[0m");
        System.out.println( "Please type in and enter the number of the command you'd like me to execute");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input)
        {
            case 1:
                System.out.println("\033[38;5;" + 57 + "m" +inventory.toString() + "\033[0m");
                break;
            case 2:
                System.out.println("\033[38;5;" + 57 + "m" + "Is the item you'd like to upgrade an EPIC?\nPlease input yes or no"+ "\033[0m");
                String answer = sc.next().toLowerCase();
                if(answer.equals("no"))
                {
                    System.out.println("\033[38;5;" + 57 + "m" + "Please input the indices of the items"+ "\033[0m");
                    try
                    {
                        inventory.upgradeNonEpics(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage()+"\033[38;5;" + 57 + "m" +"\nPlease try again"+"\033[0m");
                    }
                }
                else
                {
                    System.out.println("\033[38;5;" + 57 + "m" + "Are you upgrading to legendary?" + "\033[0m");
                    String answer2 = sc.next().toLowerCase();
                    System.out.println("\033[38;5;" + 57 + "m" + "Please input the indices of the items" + "\033[0m");
                    if(answer2.equals("yes")) {

                        try {
                            inventory.upgradeEpic(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        } catch (Exception e) {
                            System.out.println(e.getMessage() + "\033[38;5;" + 57 + "m" + "\nPlease try again" + "\033[0m");
                        }
                    }
                    else
                    {
                        try {
                            inventory.upgradeEpic(sc.nextInt(), sc.nextInt(), 0);
                        } catch (Exception e) {
                            System.out.println(e.getMessage() + "\033[38;5;" + 57 + "m" + "\nPlease try again" + "\033[0m");
                        }
                    }
                }
                break;
            case 3:
                System.exit(0);
        }

    }
}
