package demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.TimeZone;

public class IPAddressTimeZoneExample {
    public static void main(String[] args) {
        String ipAddress = "192.168.0.1";

        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            TimeZone timeZone = TimeZone.getDefault();

            String timeZoneName = timeZone.getDisplayName();
            int rawOffset = timeZone.getRawOffset();

            System.out.println("IP Address: " + inetAddress.getHostAddress());
            System.out.println("Time Zone: " + timeZoneName);
            System.out.println("Raw Offset: " + rawOffset);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}