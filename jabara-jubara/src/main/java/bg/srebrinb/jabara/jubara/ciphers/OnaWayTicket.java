package bg.srebrinb.jabara.jubara.ciphers;

/**
 *
 * @author srebrin
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class OnaWayTicket {

    // Статичен блок за инициализация
    static {
        initialize();
    }

    // Частен конструктор, за да се предотврати създаването на инстанции
    private OnaWayTicket() {
    }

    private static void initialize() {
        // Добавяне на Bouncy Castle като доставчик на криптографски алгоритми
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void getTicket() throws Exception {

        // Генериране на ключова двойка ECC
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC", "BC");
        keyGen.initialize(new ECGenParameterSpec("secp256r1"), new SecureRandom());
        KeyPair keyPair = keyGen.generateKeyPair();
        PublicKey cryptKey = keyPair.getPublic();
        System.out.println("Crypt Key: " + Base64.getEncoder().encodeToString(cryptKey.getEncoded()));
        // Записване на ключ в файл
        try ( FileOutputStream fos = new FileOutputStream("Ticket.key");  ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(cryptKey.getEncoded());
        }
    }

    public static String flyAway(byte[] message) throws Exception {
        // Четене на публичния ключ от файл
        byte[] keyBytes;
        try ( FileInputStream fis = new FileInputStream("Ticket.key");  ObjectInputStream ois = new ObjectInputStream(fis)) {
            keyBytes = (byte[]) ois.readObject();
        }

        // Възстановяване на PublicKey обект от байтове
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        PublicKey cryptKey = keyFactory.generatePublic(keySpec);

        // Криптиране на съобщение
        Cipher cipher = Cipher.getInstance("ECIES", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, cryptKey);

        byte[] encryptedMessage = cipher.doFinal(message);
        System.out.println("Encrypted Message: " + Base64.getEncoder().encodeToString(encryptedMessage));
        return Base64.getEncoder().encodeToString(encryptedMessage);
    }
    public static String flyAway(String message) throws Exception {
        return flyAway(message.getBytes("UTF-8"));
    }
    
}
