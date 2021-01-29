package organizing.data;

public class Utils {
    public static void validatePassword(String password) {
        if (password.length() < 12) {
            throw new IllegalArgumentException("minimum password length is not respected");
        }
    }

    public static double calculatePotentialEnergy(double mass, double height) {
        return mass * height * 9.81;
    }
}
