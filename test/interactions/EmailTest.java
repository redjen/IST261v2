package interactions;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author redjen
 */
public class EmailTest extends InteractionTestBase<Email> {

   private static final long TEST_ID = 9999;
   private static final long TEST_CONTACT_ID = 7777;
   private static final long TEST_CONTACT_ID_2 = 6666;
   private static final long TEST_ID_2 = 4444;
   private static final long TEST_ID_3 = 5555;
   private final static String TEST_MESSAGE = "This is a test message";
   private final static String TEST_SUBJECT = "This is a test subject";
   private final static String SUMMARY_TEXT_FORMAT = "Subject: %s%n%n%s";

   public EmailTest() {
      super();
   }

   @Before
   public void setUp() {
      interaction = new Email(TEST_ID, TEST_CONTACT_ID, TEST_MESSAGE, TEST_SUBJECT);
   }

   @Test
   @Override
   public void testGetSummaryText() {
      assertEquals(String.format(SUMMARY_TEXT_FORMAT, TEST_SUBJECT, TEST_MESSAGE), interaction.getSummaryText());
   }


   @Test
   @Override
   public void testGetMessageText() {
      assertEquals(TEST_MESSAGE, interaction.getMessageText());
   }

   @Test
   public void testCompareTo() {
      Email email2 = new Email(TEST_ID_2, TEST_CONTACT_ID, TEST_MESSAGE, TEST_SUBJECT);
      Email email3 = new Email(TEST_ID_3, TEST_CONTACT_ID, TEST_MESSAGE, TEST_SUBJECT);

      ArrayList<Email> emails = new ArrayList<>();
      emails.add(interaction);
      emails.add(email2);
      emails.add(email3);
      Collections.sort(emails);

      assertEquals(TEST_ID_2, emails.get(0).getId());
      assertEquals(TEST_ID_3, emails.get(1).getId());
      assertEquals(TEST_ID, emails.get(2).getId());
   }

   @Test
   public void testGetSubject() {
      assertEquals(TEST_SUBJECT, interaction.getSubject());
   }

}
