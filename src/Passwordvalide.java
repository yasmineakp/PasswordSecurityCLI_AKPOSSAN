public class Passwordvalide {

    public Passwordstrength checkStrength(String password) {

        int score = 0;

        if (password.length() >= 12) score += 2;
        else if (password.length() >= 8) score += 1;

        if (password.matches(".*[A-Z].*")) score += 1;
        if (password.matches(".*[a-z].*")) score += 1;
        if (password.matches(".*[0-9].*")) score += 1;
        if (password.matches(".*[^A-Za-z0-9].*")) score += 2;

        if (score <= 2) return Passwordstrength.TRES_FAIBLE;
        if (score <= 3) return Passwordstrength.FAIBLE;
        if (score <= 5) return Passwordstrength.MOYEN;
        if (score <= 6) return Passwordstrength.FORT;

        return Passwordstrength.TRES_FORT;
    }
}