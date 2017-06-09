package manual;

import interactions.Email;
import interactions.Interaction;
import interactions.PhoneCall;
import interactions.PhoneCallType;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The TestHarness class runs manual tests required for assignments
 * 
 */
public class TestHarness {

   public static void main(String[] args) {
      testClassHierarchy();
   }
   
   /**
    * Test method for M04A01
    */
   private static void testClassHierarchy() {
      
      ArrayList<Interaction> list = new ArrayList<>();
      
      Email email = new Email(101, 1000, "This is the message body.", "This is the message subject");
      list.add(email);
      PhoneCall placedCall = new PhoneCall(102, 1000, 505, PhoneCallType.PLACED);
      list.add(placedCall);
      PhoneCall missedCall = new PhoneCall(103, 1000, 0, PhoneCallType.MISSED);
      list.add(missedCall);
      Collections.sort(list);
      
      for (Interaction interaction : list) {
         System.out.println(interaction.getSummaryText());
         System.out.println();
         System.out.println("--------------------------------------------------");
         System.out.println();
      }
   
   }
   
}
