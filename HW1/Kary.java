public class Kary {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        if (k < 2 || k > 16) {
            System.out.println("Base must be between 2 and 16.");
            return;
        }
        if (n == 0) {
            System.out.println("0");
            return;
        }

        char[] digits = "0123456789ABCDEF".toCharArray();

        StringBuilder result = new StringBuilder();

        int value = n;
        while (value > 0) {
            int remainder = value % k;
            result.append(digits[remainder]);
            value /= k;
        }

        result.reverse();
        System.out.println(result.toString());
    }
}

