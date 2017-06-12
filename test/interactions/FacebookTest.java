package interactions;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author redjen
 */
public class FacebookTest extends InteractionTestBase<Facebook> {

   private static final String TEST_REMOTE_ID = "abcde";
   private static final String TEST_REMOTE_USERNAME = "testUser";
   private static final FacebookType TEST_REMOTE_TYPE = FacebookType.LINK;
   private static final String TEST_REMOTE_URL_FORMATTER = "%s/%s/%s/%s";
   // contactId, remoteUsername, messageText, remoteURL
   private static final String TEST_SUMMARY_FORMATTER = "%d (+%s)%n%s%n%n %s";

   public FacebookTest() {
      super();
   }

   @Before
   public void setUp() {
      interaction = new Facebook(BASE_TEST_ID, BASE_TEST_CONTACT_ID, BASE_TEST_MESSAGE,
              TEST_REMOTE_ID, TEST_REMOTE_USERNAME, TEST_REMOTE_TYPE);
   }

   @Test
   public void testGetRemoteID() {
      assertEquals(TEST_REMOTE_ID, interaction.getRemoteID());
   }

   @Test
   public void testGetRemoteUsername() {
      assertEquals(TEST_REMOTE_USERNAME, interaction.getRemoteUsername());
   }

   @Test
   public void testGetRemoteURL_specified() {
      String expectedURL = String.format(TEST_REMOTE_URL_FORMATTER, FacebookClientType.APP.getUrlPrefix(),
              TEST_REMOTE_USERNAME, TEST_REMOTE_TYPE.getURLPart(), TEST_REMOTE_ID);
      assertEquals(expectedURL, interaction.getRemoteURL(FacebookClientType.APP));

   }

   @Test
   public void testGetRemoteURL() {
      String expectedURL = String.format(TEST_REMOTE_URL_FORMATTER, FacebookClientType.DESKTOP.getUrlPrefix(),
              TEST_REMOTE_USERNAME, TEST_REMOTE_TYPE.getURLPart(), TEST_REMOTE_ID);
      assertEquals(expectedURL, interaction.getRemoteURL(FacebookClientType.DESKTOP));
   }

   @Test
   public void testGetRemoteType() {
      assertEquals(TEST_REMOTE_TYPE, interaction.getRemoteType());
   }

   @Test
   @Override
   public void testGetSummaryText() {

      String expectedURL = String.format(TEST_REMOTE_URL_FORMATTER, FacebookClientType.DESKTOP.getUrlPrefix(),
              TEST_REMOTE_USERNAME, TEST_REMOTE_TYPE.getURLPart(), TEST_REMOTE_ID);
      String expected = String.format(TEST_SUMMARY_FORMATTER, BASE_TEST_CONTACT_ID,
              TEST_REMOTE_USERNAME, BASE_TEST_MESSAGE, expectedURL);
      assertEquals(expected, interaction.getSummaryText());
   }

}
