package manual;

import interactions.Facebook;
import interactions.FacebookType;
import java.util.ArrayList;
import interactions.Sociable;
import interactions.Tweet;

/**
 * The TestHarness class runs manual tests required for assignments
 *
 */
public class TestHarness {

   public static void main(String[] args) {
      testInterface();
   }

   public static void testInterface() {
      ArrayList<Sociable> list = new ArrayList<>();

      Sociable<String> facebookPost = new Facebook(393, 1000, "This is the message.",
              "ab1930", "TestUser", FacebookType.STATUS);
      list.add(facebookPost);
      Sociable<Integer> tweetPost = new Tweet(1002, "TestTweeter", 10394, 1000, "This is the message");
      list.add(tweetPost);
      Sociable<String> facebookLink = new Facebook(293, 1000, "This is the message.",
              "ab1930", "TestUser", FacebookType.LINK);
      list.add(facebookLink);

      for (Sociable sociable : list) { 
         System.out.println(sociable.getRemoteURL());
      }
   }

}
