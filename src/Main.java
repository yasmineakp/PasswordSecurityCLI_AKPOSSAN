public class Main {

    public static void main(String[] args) {

        Passwordgenerateur generator = new Passwordgenerateur();
        Passwordvalide validator = new Passwordvalide();

        String[] passwords = generator.generateBatch(
                5, 12, true, true, true, true
        );

        System.out.println("=== RESULTATS ===");

        for (String password : passwords) {
            Passwordstrength strength = validator.checkStrength(password);

            System.out.println(password + " -> " + strength);
        }
    }
}