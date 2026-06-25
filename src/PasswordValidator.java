import java.io.*;

public class PasswordValidator {

    public String checkStrength(String password) {

        try {

            ProcessBuilder pb = new ProcessBuilder(
                    "docker", "run", "-i", "password-checker"
            );

            Process process = pb.start();

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(process.getOutputStream())
            );

            writer.write(password);
            writer.newLine();
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String result = reader.readLine();

            process.waitFor();

            if (result == null) return "ERREUR";

            result = result.toLowerCase();

            // 🔥 LOGIQUE ADAPTÉE À TON DOCKER

            if (result.contains("way too short")) {
                return "TRES_FAIBLE";
            }

            if (result.contains("too short")) {
                return "FAIBLE";
            }

            if (result.contains("ok")) {
                return "TRES_FORT";
            }

            return "MOYEN";

        } catch (Exception e) {
            return "ERREUR_DOCKER";
        }
    }
}