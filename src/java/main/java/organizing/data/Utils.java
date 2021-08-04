package organizing.data;

public class Utils {
    public static final int MINIMUM_PASSWORD_LENGTH = 12;
    public static final double GRAVITATIONAL_CONSTANT = 9.81;

    public static void validatePassword(String password) {
        if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("minimum password length is not respected");
        }
    }

    public static double calculatePotentialEnergy(double mass, double height) {
        return mass * height * GRAVITATIONAL_CONSTANT;
    }
}
