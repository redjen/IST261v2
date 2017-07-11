package data.interaction;

import data.AbstractInteraction;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Base tests for an AbstractInteraction
 *
 * @param <T> Implementing class
 */
public abstract class InteractionTestBase<T extends AbstractInteraction> {

   protected static final long BASE_TEST_ID = 9999;
   protected static final long BASE_TEST_CONTACT_ID = 7777;
   protected static final long BASE_TEST_CONTACT_ID_2 = 6666;
   protected static final long BASE_TEST_ID_2 = 4444;
   protected static final long BASE_TEST_ID_3 = 5555;
   protected final String BASE_TEST_MESSAGE = "This is a test message";

   protected T interaction;

   public InteractionTestBase() {

   }

   @Test
   public void testGetId() {
      assertEquals(BASE_TEST_ID, interaction.getId());
   }

   @Test
   public void testGetContactId() {
      assertEquals(BASE_TEST_CONTACT_ID, interaction.getContactId());
   }

   @Test
   public void testGetMessageText() {
      assertEquals(BASE_TEST_MESSAGE, interaction.getMessageText());
   }

   @Test
   public abstract void testGetSummaryText();

}
