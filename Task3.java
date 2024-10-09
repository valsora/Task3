import java.util.HashSet;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("1) " + isStrangePair("ratio", "orator"));
        System.out.println("2) ");
        System.out.println("3) " + successShot(-2, -3, 4, 5, -6));
        System.out.println("4) " + parityAnalysis(243));
        System.out.println("5) " + rps("paper", "scissors"));
        System.out.println("6) " + bugger(999));
        System.out.println("7) " + mostExpensive(new Item[] {new Item("Скакалка", 550, 8), new Item("Шлем", 3750, 4), new Item("Мяч", 2900, 10)}));
        System.out.println("8) " + longestUnique("abcdefgewuwbnckshsk"));
    }

    public static boolean isStrangePair(String s1, String s2) {
        if (s1.equals("")|| s2.equals("")) {
            if (s1.equals(s2)) return true;
            else return false;
        }
        if (s1.charAt(0) == s2.charAt(s2.length() - 1) && s1.charAt(s1.length() - 1) == s2.charAt(0)) return true;
        else return false;
    }

    // public static  sale(, int discount) {
        
    // }

    public static boolean successShot(double x, double y, double r, double m, double n) {
        double R = Math.sqrt(Math.pow((m - x), 2) + Math.pow((n - y), 2));
        return R > r ? false : true;
    }

    public static boolean parityAnalysis(int n) {
        String stringN = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < stringN.length(); i++) {
            sum +=  Character.getNumericValue(stringN.charAt(i));
        }
        if (n % 2 == sum % 2) return true;
        else return false;
    }

    public static String rps(String p1, String p2) {
        if (p1.equals(p2)) return "Tie";
        if ((p1.equals("rock") && p2.equals("scissors")) || (p1.equals("scissors") && p2.equals("paper")) || (p1.equals("paper") && p2.equals("rock"))) return "Player 1 wins";
        else return "Player 2 wins";
    }

    public static int bugger(int n) {
        String stringN = Integer.toString(n);
        int counter = 0;
        while (stringN.length() > 1) {
            int nextN = 1;
            for (int i = 0; i < stringN.length(); i++) {
                nextN *= Character.getNumericValue(stringN.charAt(i));
            }
            stringN = Integer.toString(nextN);
            counter++;
        }
        return counter;
    }

    public static String mostExpensive(Item[] items) {
        double maxTotalPrice = 0;
        String maxName = "";
        for (Item item : items) {
            double totalPrice = item.getPrice() * item.getAmount();
            if (totalPrice > maxTotalPrice) {
                maxTotalPrice = totalPrice;
                maxName = item.getName();
            }
        }
        return "Наиб. общ. стоимость у предмета " + maxName + " - " + maxTotalPrice;
    }

    public static String longestUnique(String s) {
        for (int i = s.length(); i > 1; i--) {
            for (int j = 0; j < s.length() - i + 1; j++) {
                String substr = s.substring(j, j + i);
                System.out.println(substr);
                HashSet<Character> set = new HashSet<>();
                boolean isUnique = true;
                for (int k = 0; k < substr.length(); k++) {
                    int setSize = set.size();
                    set.add(substr.charAt(k));
                    if (set.size() == setSize) {
                        isUnique = false;
                        break;
                    }
                }
                if (isUnique) return substr;
            }
        }
        return s.substring(0, 1);
    }
}

class Item {
    private String name;
    private double price;
    private int amount;

    public Item(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}