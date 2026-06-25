import java.security.SecureRandom;

public class Passwordgenerateur {

    private static final String MAJUSCULES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String MINUSCULES = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHIFFRES = "0123456789";
    private static final String SYMBOLES = "!@#$%^&*()-_=+[]{}<>?/";

    private final SecureRandom random = new SecureRandom();

    public String generatePassword(int length,
                                   boolean useUpper,
                                   boolean useLower,
                                   boolean useDigits,
                                   boolean useSymbols) {

        StringBuilder pool = new StringBuilder();

        if (useUpper) pool.append(MAJUSCULES);
        if (useLower) pool.append(MINUSCULES);
        if (useDigits) pool.append(CHIFFRES);
        if (useSymbols) pool.append(SYMBOLES);

        if (pool.isEmpty()) {
            throw new IllegalArgumentException("Aucun type sélectionné");
        }

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(pool.length());
            password.append(pool.charAt(index));
        }

        return password.toString();
    }

    public String[] generateBatch(int count,
                                  int length,
                                  boolean useUpper,
                                  boolean useLower,
                                  boolean useDigits,
                                  boolean useSymbols) {

        String[] passwords = new String[count];

        for (int i = 0; i < count; i++) {
            passwords[i] = generatePassword(
                    length,
                    useUpper,
                    useLower,
                    useDigits,
                    useSymbols
            );
        }

        return passwords;
    }
}