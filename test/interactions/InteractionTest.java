package interactions;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class InteractionTest {

   private final long idInput;
   private final long idExpected;
   private final long contactIdInput;
   private final long contactIdExpected;
   private final String messageTextInput;
   private final String messageTextExpected;
   private Interaction interaction;

   public InteractionTest(long interactionIdInput, long interactionIdExpected, long interactionContactIdInput, long interactionContactIdExpected, String interactionMessageTextInput, String interactionMessageTextExpected) {
      super();
      this.idInput = interactionIdInput;
      this.idExpected = interactionIdExpected;
      this.contactIdInput = interactionContactIdInput;
      this.contactIdExpected = interactionContactIdExpected;
      this.messageTextInput = interactionMessageTextInput;
      this.messageTextExpected = interactionMessageTextExpected;
   }
   
   
   @Parameters
   public static Collection data() {
      return Arrays.asList(new Object[][]{
         {100, 100, 200, 200, "Test message 100", "Test message 100"},
         {101, 101, 201, 201, "Test message 200", "Test message 200"}
      });
   }

   @Before
   public void setUp() {
      interaction = new Interaction(idInput, contactIdInput, messageTextInput);
   }
   
   @Test
   public void testGetMessageSummaryText() {
      assertEquals(messageTextExpected, interaction.getSummaryText());
   }
//
   @Test
   public void testGetId() {
      assertEquals(idExpected, interaction.getId());
   }

   @Test
   public void testGetContactId() {
      assertEquals(contactIdExpected, interaction.getContactId());
   }

   @Test
   public void testSetContactId() {
      long expected = 9999;
      interaction.setContactId(expected);
      assertEquals(expected, interaction.getContactId());
   }

   @Test
   public void testGetMessageText() {
      assertEquals(messageTextExpected, interaction.getMessageText());
   }
   
//   @Test
   public void testCompareTo() {
   
   }

}
