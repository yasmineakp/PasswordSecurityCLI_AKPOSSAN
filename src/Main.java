public class Main {

    public static void main(String[] args) {

        PasswordGenerator generator = new  PasswordGenerator();
        PasswordValidator validator = new  PasswordValidator();

        String[] passwords = generator.generateBatch(
                5, 12, true, true, true, true
        );

        System.out.println("=== RESULTATS (Docker) ===");

        for (String password : passwords) {
            String score = validator.checkStrength(password);
            System.out.println(password + " -> " + score);
        }
    }
}