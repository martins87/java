public class KittyTransfer {
    public static void main(String args[]) {
        
        String address1 = "0x000000000000000000000000000000987654321b";
        String address2 = "0x000000000000000000000000000000123456789a";
        address1 = last10Characters(address1);
        address2 = last10Characters(address2);

        System.out.println("C02 emitted for kitty transfer: " + getCO2Emitted(address1, address2) + " g");
    }
    
    public static String last10Characters(String address) {
        return address.substring(address.length()-10, address.length());
    }
    
    public static double getCO2Emitted(String address1, String address2) {
        long distance = Long.parseLong(address1, 16) - Long.parseLong(address2, 16);
        if(distance < 0)
            distance *= -1;
        return Double.parseDouble( Long.toString(distance) ) / 100000;
    }
    
}
