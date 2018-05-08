package ip_address;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final String IP_PATTERN ="^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\W"
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\W"
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\W"
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String firstIp = scanner.nextLine();
        String lastIp = scanner.nextLine();
        scanner.close();

        Pattern pattern = Pattern.compile(IP_PATTERN);

        if (pattern.matcher(firstIp).matches() & pattern.matcher(lastIp).matches()) {
            ArrayList<String> list =  ipRange(firstIp, lastIp);
            for (String ip : list)
                System.out.println(ip);

        } else {
            System.out.println("is not validate ip");
        }
    }
    private static ArrayList<String> ipRange(String firstIp, String lastIp) {
        ArrayList<String> result = new ArrayList<>();
        int[] firstIpArray = ipToArray(firstIp);
        int[] lastIpArray = ipToArray(lastIp);
        int[] rangeIpArray = {Math.abs(firstIpArray[0] - lastIpArray[0]),
                Math.abs(firstIpArray[1] - lastIpArray[1]),
                Math.abs(firstIpArray[2] - lastIpArray[2]),
                Math.abs(firstIpArray[3] - lastIpArray[3]),
        };

        if (firstIp.compareTo(lastIp) < 0) {
            for (int i = 1; i < rangeIpArray[3]; i++) {
                int[] ip_address = {firstIpArray[0], firstIpArray[1], firstIpArray[2], (firstIpArray[3] + i)};
                result.add(ipString(ip_address));
            }
        } else if (firstIp.compareTo(lastIp) > 0){
            for (int i = 1; i < rangeIpArray[3]; i++) {
                int[] ip_address = {lastIpArray[0], lastIpArray[1], lastIpArray[2], (lastIpArray[3] + i)};
                result.add(ipString(ip_address));
            }

        } else
            System.out.println("first ip == last ip");

        return result;
    }
    private static int[] ipToArray(String ip) {
        return Arrays.stream(ip.split("\\W")).mapToInt(Integer::parseInt).toArray();

    }
    private static String ipString (int[] ip) {
        return new StringBuilder().append(ip[0]).append(".").append(ip[1]).append(".").append(ip[2]).append(".").append(ip[3]).toString();
    }
}
