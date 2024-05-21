import java.util.Random;

public class RandomPasswordGenerator {

  public static String generatePassword(int length, boolean includeUppercase,
                                    boolean includeLowercase, boolean includeNumbers,
                                    boolean includeSymbols) {
    String characterSet = "";
    if (includeUppercase) {
      characterSet += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
    if (includeLowercase) {
      characterSet += "abcdefghijklmnopqrstuvwxyz";
    }
    if (includeNumbers) {
      characterSet += "0123456789";
    }
    if (includeSymbols) {
      characterSet += "!@#$%^&*()-+";
    }

    StringBuilder password = new StringBuilder();
    Random random = new Random();
    if (characterSet.length() == 0) {
      throw new IllegalArgumentException("Password must include at least one character set");
    }
    for (int i = 0; i < length; i++) {
      int index = random.nextInt(characterSet.length());
      password.append(characterSet.charAt(index));
    }

    return password.toString();
  }

  public static void main(String[] args) {
    int passwordLength = 12; // Adjust desired password length
    boolean includeUppercase = true;
    boolean includeLowercase = true;
    boolean includeNumbers = true;
    boolean includeSymbols = true;

    String password = generatePassword(passwordLength, includeUppercase, includeLowercase, includeNumbers, includeSymbols);
    System.out.println("Generated Password: " + password);
  }
}
