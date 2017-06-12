package interactions;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the PhoneCall class
 */
public class PhoneCallTest extends InteractionTestBase<PhoneCall> {

   private final static String SUMMARY_TEXT_CALL_TYPE_FORMAT = "%s%d%n";

   private static final int TEST_DURATION = 765;
   private static final PhoneCallType TEST_TYPE_RECEIVED = PhoneCallType.RECEIVED;
   private static final PhoneCallType TEST_TYPE_PLACED = PhoneCallType.PLACED;
   private static final PhoneCallType TEST_TYPE_MISSED = PhoneCallType.MISSED;
   private static final String TEST_MESSAGE_RECEIVED = "Received call from 7777\n"
           + "12:45";
   private static final String TEST_MESSAGE_PLACED = "Called 7777\n"
           + "12:45";
   private static final String TEST_MESSAGE_MISSED = "Missed call from 7777\n";

   private static PhoneCall phoneCallReceived;
   private static PhoneCall phoneCallPlaced;
   private static PhoneCall phoneCallMissed;

   public PhoneCallTest() {

   }

   @Before
   public void setUp() {

      phoneCallReceived = new PhoneCall(BASE_TEST_ID, BASE_TEST_CONTACT_ID, TEST_DURATION, TEST_TYPE_RECEIVED);
      phoneCallPlaced = new PhoneCall(BASE_TEST_ID, BASE_TEST_CONTACT_ID, TEST_DURATION, TEST_TYPE_PLACED);
      phoneCallMissed = new PhoneCall(BASE_TEST_ID, BASE_TEST_CONTACT_ID, TEST_DURATION, TEST_TYPE_MISSED);

   }

   @Test
   @Override
   public void testGetId() {
      assertEquals(BASE_TEST_ID, phoneCallReceived.getId());
      assertEquals(BASE_TEST_ID, phoneCallPlaced.getId());
      assertEquals(BASE_TEST_ID, phoneCallMissed.getId());

   }

   @Test
   @Override
   public void testGetContactId() {
      assertEquals(BASE_TEST_CONTACT_ID, phoneCallReceived.getContactId());
      assertEquals(BASE_TEST_CONTACT_ID, phoneCallPlaced.getContactId());
      assertEquals(BASE_TEST_CONTACT_ID, phoneCallMissed.getContactId());
   }

   @Test
   @Override
   public void testSetContactId() {
      phoneCallReceived.setContactId(BASE_TEST_CONTACT_ID_2);
      phoneCallPlaced.setContactId(BASE_TEST_CONTACT_ID_2);
      phoneCallMissed.setContactId(BASE_TEST_CONTACT_ID_2);
      
      assertEquals(BASE_TEST_CONTACT_ID_2, phoneCallReceived.getContactId());
      assertEquals(BASE_TEST_CONTACT_ID_2, phoneCallPlaced.getContactId());
      assertEquals(BASE_TEST_CONTACT_ID_2, phoneCallMissed.getContactId());
   }

   @Test
   @Override
   public void testGetSummaryText() {
      assertEquals(TEST_MESSAGE_RECEIVED, phoneCallReceived.getSummaryText());
      assertEquals(TEST_MESSAGE_PLACED, phoneCallPlaced.getSummaryText());
      assertEquals(TEST_MESSAGE_MISSED, phoneCallMissed.getSummaryText());
   }

   @Test
   @Override
   public void testGetMessageText() {
      assertEquals(TEST_MESSAGE_RECEIVED, phoneCallReceived.getMessageText());
      assertEquals(TEST_MESSAGE_PLACED, phoneCallPlaced.getMessageText());
      assertEquals(TEST_MESSAGE_MISSED, phoneCallMissed.getMessageText());
   }

   @Test
   public void testGetDurationSeconds() {
      assertEquals(TEST_DURATION, phoneCallReceived.getDurationSeconds());
      assertEquals(TEST_DURATION, phoneCallPlaced.getDurationSeconds());
      assertEquals(0, phoneCallMissed.getDurationSeconds());
   }

   @Test
   public void testGetCallType() {
      assertEquals(TEST_TYPE_RECEIVED, phoneCallReceived.getCallType());
      assertEquals(TEST_TYPE_PLACED, phoneCallPlaced.getCallType());
      assertEquals(TEST_TYPE_MISSED, phoneCallMissed.getCallType());
   }

}
