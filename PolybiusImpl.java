import java.util.Scanner;

public class PolybiusImpl {
    private String decision;

    public void Begin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Polybius Message Encryption and Decryption\n");

        while(true) {
            System.out.print("Press [E] to Encrypt [D] to Decrypt: ");
            while(true) {
                try {
                    decision = scanner.nextLine();

                    if(decision.trim().equalsIgnoreCase("E")) {
                        PolybiusEncryption polybiusEncryption = new PolybiusEncryption();
                        polybiusEncryption.EncryptionImpl();
                        System.out.println("Encrypted Message: " + polybiusEncryption.Encryption());
                        break;
                    }else if(decision.trim().equalsIgnoreCase("D")) {
                        PolybiusDecryption polybiusDecryption = new PolybiusDecryption();
                        polybiusDecryption.DecryptionImpl();
                        System.out.println("Decrypted Message: " + polybiusDecryption.Decryption());
                        break;
                    }
                }catch (Exception e) {
                    System.out.println("Invalid data! Cause = " + e.getMessage());
                    continue;
                }
            }

            System.out.print("\nDo you want to try another one? [Y/N]");
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
