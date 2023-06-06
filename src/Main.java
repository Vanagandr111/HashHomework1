import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Main {

  public static final String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
  public static final Logger logger = Logger.getAnonymousLogger();

  public static void main(String[] args) {

    HashMap<Character, Integer> characters = new HashMap<>();

    for(char char1 : loremIpsum.toCharArray()) {
      if(!Character.isLetter(char1)) {
        continue;
      }

      if (!characters.containsKey(char1)) {
        characters.put(char1, 1);
        continue;
      }

      characters.put(char1, characters.get(char1)+1);
    }

    char max = maxCharacter(characters);
    char min = minCharacter(characters);

    logger.info("Список букв: " + characters);
    logger.info("Буква \"" + max + "\" была больше всех в тексте. Она появлялась: " + characters.get(max) + " раз(а)");
    logger.info("Буква \"" + min + "\" была реже всех в тексте. Она появлялась: " + characters.get(min) + " раз(а)");
  }

  public static char maxCharacter(Map<Character, Integer> charMap) {
    long max = -1;
    char maxchar = 0;

    for (char char1 : charMap.keySet()) {
      int i = charMap.get(char1);
      if (i > max) {
        max = i;
        maxchar = char1;
      }
    }

    return maxchar;
  }

  public static char minCharacter(Map<Character, Integer> charMap) {
    long min = Integer.MAX_VALUE;
    char minchar = 0;

    for (char char1 : charMap.keySet()) {
      int i = charMap.get(char1);
      if (i < min) {
        min = i;
        minchar = char1;
      }
    }

    return minchar;
  }
}