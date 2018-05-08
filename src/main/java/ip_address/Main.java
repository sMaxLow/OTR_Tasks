package ip_address;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final long TARG_0 = 256 * 256 * 256;
    private static final long TARG_1 = 256 * 256;
    private static final long TARG_2 = 256;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String firstIp = scanner.nextLine();
        String lastIp = scanner.nextLine();
        scanner.close();

        ArrayList<String> list;
        try {
            list = ipRange(firstIp, lastIp);
            for (String ip : list)
                System.out.println(ip);
        } catch (UnknownHostException e) {
            System.out.println("is not validate ip");
            e.printStackTrace();
        }
    }

    private static ArrayList<String> ipRange(String firstIp, String lastIp) throws UnknownHostException {
        ArrayList<String> list = new ArrayList<>();
        InetAddress ip1 = InetAddress.getByName(firstIp);
        InetAddress ip2 = InetAddress.getByName(lastIp);
        long longFirstId = Main.ipToLong(ip1);
        long longLastId = Main.ipToLong(ip2);
        long rangeId = Math.abs(longFirstId - longLastId);

        if (longLastId > longFirstId) {
            for (long i = 1; i < rangeId; i++) {
                list.add(Main.longToIp(longFirstId + i));
            }
        } else {
            for (long i = 1; i < rangeId; i++) {
                list.add(Main.longToIp(longLastId + i));
            }
        }
        return list;
    }

    static long ipToLong(InetAddress ipAddress) {
        byte ipAddressToByteArray[] = ipAddress.getAddress();

        int firstByte = ipAddressToByteArray[0];
        if (firstByte < 0) {
            firstByte += 256;
        }
        int secondByte = ipAddressToByteArray[1];
        if (secondByte < 0) {
            secondByte += 256;
        }
        int threeByte = ipAddressToByteArray[2];
        if (threeByte < 0) {
            threeByte += 256;
        }
        int fourByte = ipAddressToByteArray[3];
        if (fourByte < 0) {
            fourByte += 256;
        }
        return (TARG_0 * firstByte) + (TARG_1 * secondByte) + (TARG_2 * threeByte) + fourByte;
    }

    static String longToIp(long ip) {

        long a = ip;
        long firstLong = a / TARG_0;
        a -= (firstLong * TARG_0);
        long secondLong = a / TARG_1;
        a -= (secondLong * TARG_1);
        long threeLong = a / TARG_2;
        a -= (threeLong * TARG_2);
        long fourLong = a;
        return firstLong + "." + secondLong + "." + threeLong + "." + fourLong;
    }
}
