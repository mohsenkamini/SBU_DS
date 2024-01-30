public class Three {
    public static void main(String[] args) {
        int counter=0;
        for (int x = 0; x <= 100; x++) {
            if (x % 7 == 2 || x % 7 == 5) {
                System.out.println(x);
                counter++;
            }
        }
        System.out.println(counter);
    }
}