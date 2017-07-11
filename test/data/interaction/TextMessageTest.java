
package data.interaction;

import data.TextMessage;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author redjen
 */
public class TextMessageTest extends InteractionTestBase<TextMessage> {

    public TextMessageTest() {
       super();
    }

    @Before
    public void setUp() {
       interaction = new TextMessage(BASE_TEST_ID, BASE_TEST_CONTACT_ID, BASE_TEST_MESSAGE);
    }

   @Override @Test
   public void testGetSummaryText() {
      assertEquals(BASE_TEST_MESSAGE, interaction.getSummaryText());
   }

}