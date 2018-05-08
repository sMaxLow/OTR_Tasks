package ip_address;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final String IP_PATTERN = "^(25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|[0-9][0-9]|[0-9])" +
            "(\\W(25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|[0-9][0-9]|[0-9]))" +
            "(\\W(25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|[0-9][0-9]|[0-9]))" +
            "(\\W(25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|[0-9][0-9]|[0-9]))$";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String firstIp = scanner.nextLine();
        String lastIp = scanner.nextLine();
        scanner.close();

        Pattern pattern = Pattern.compile(IP_PATTERN);

        if (pattern.matcher(firstIp).matches()| pattern.matcher(lastIp).matches()) {
            rangeIp(firstIp, lastIp);

        } else {
            System.out.println("is not validate ip");
        }
    }
    public static void rangeIp(String firstIp, String lastIp) {
        boolean end = false;
        int[] firstArray = ipToArray(firstIp);
        int[] lastArray = ipToArray(lastIp);

        int one = Math.abs(firstArray[0] - lastArray[0]);
        int two = Math.abs(firstArray[1] - lastArray[1]);
        int three = Math.abs(firstArray[2] - lastArray[2]);
        int four = Math.abs(firstArray[3] - lastArray[3]);

        if (firstArray[0] < lastArray[0]){

        }

    }
    public static int[] ipToArray(String ip) {
        return Arrays.stream(ip.split("\\W")).mapToInt(Integer::parseInt).toArray();

    }


}
