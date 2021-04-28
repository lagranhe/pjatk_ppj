import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        //String appKey = "KPMG H@ckademy";
        //String appMes = "323d28231a382e010469183f633d4a1f16550f0c3c0d0853337e2236";
        crypt();
    }

    public static void crypt () throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write message:");
        String message = reader.readLine();
        System.out.println("Write key:");
        String key = reader.readLine();

        byte[] keyBytes = key.getBytes();
        byte[] messageBytes = message.getBytes();
        //byte[] messageBytesFromHex = hexStringToByteArray(message);

        System.out.print("Key bytes: ");
        for (int i = 0; i < keyBytes.length; i ++){
            System.out.print(keyBytes[i]);
        }
        System.out.println();
        System.out.print("Message bytes: ");
        for (int i = 0; i < messageBytes.length; i ++){
            System.out.print(messageBytes[i]);
        }
        System.out.println();

        byte[] result = xor(messageBytes, keyBytes);

        System.out.print("Bytes of encrypt/decrypt result : ");
        for (int i = 0; i < result.length; i ++){
            System.out.print(messageBytes[i]);
        }
        System.out.println();

        String hexString = byteArrayToHex(result);
        System.out.println("HexString of encrypt/decrypt result: " + hexString);

        byte[] bytesFromHex = javax.xml.bind.DatatypeConverter.parseHexBinary(hexString);

        String resultString = new String(bytesFromHex);
        System.out.println("String of encrypt/decrypt result from HexString: : " + resultString);

        String resultStringFromByte = new String(result);
        System.out.println("String of encrypt/decrypt result from ByteArray: : " + resultStringFromByte);
    }


    private static byte[] xor(byte[] str, byte[] key) {
        for (int i = 0; i < str.length; i++) {
            str[(str.length - i) - 1] = (byte) (str[(str.length - i) - 1] ^ key[i % key.length]);
        }
        return str;
    }

    public static String byteArrayToHex(byte[] ba) {
        StringBuilder sb = new StringBuilder(ba.length * 2);
        int length = ba.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(ba[i])}));
        }
        return sb.toString();
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

}
