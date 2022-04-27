import java.util.Scanner;

public class PolybiusImpl {

    private String key;
    private String userMessage;
    private String encryptedMessage;
    private String DecryptedMessage;

    private PolybiusEncryption polybiusEncryption;

    private  PolybiusDecryption polybiusDecryption;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getEncryptedMessage() {
        return encryptedMessage;
    }

    public void setEncryptedMessage(String encryptedMessage) {
        this.encryptedMessage = encryptedMessage;
    }

    public String getDecryptedMessage() {
        return DecryptedMessage;
    }

    public void setDecryptedMessage(String decryptedMessage) {
        DecryptedMessage = decryptedMessage;
    }

    public void Begin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Polybius Message Encryption and Decryption\n");

        while(true) {
            try {
                System.out.print("Enter a Message to Encrypt: ");
                setUserMessage(scanner.nextLine());

                System.out.print("Enter a Secret Key: ");
                setKey(scanner.nextLine());

            }catch (Exception e) {
                System.out.println("Invalid data! Cause: " + e.getMessage());
                continue;
            }

            while(true) {
                try {
                    System.out.print("\nPress [E] to Encrypt [D] to Decrypt: ");
                    final String decision = scanner.nextLine().toString();

                    if(decision.trim().equalsIgnoreCase("E")) {
                        polybiusEncryption = new PolybiusEncryption(getKey(),getUserMessage());
                        setEncryptedMessage(polybiusEncryption.Encryption());
                        System.out.println("Encrypted Message: " + getEncryptedMessage());

                    }else if(decision.trim().equalsIgnoreCase("D")) {

                        System.out.print("\nPlease Enter the Encrypted Message: ");

                        setDecryptedMessage(scanner.nextLine());
                        final Long decryption = Long.parseLong(getDecryptedMessage());

                        polybiusDecryption = new PolybiusDecryption(getKey(), decryption);

                        System.out.println("Decrypted Message: " + polybiusDecryption.Decryption());

                        break;
                    }
                }catch (Exception e) {
                    System.out.println("Invalid data! Cause = " + e.getMessage());
                    continue;
                }
            }

            System.out.print("Do you want to try another one? [Y/N]");
            final String yesOrNo = scanner.next();

            if(yesOrNo.trim().equalsIgnoreCase("Y")) {
                continue;
            }else {
                System.out.print("Goodbye!");
                break;
            }
        }
    }
}
