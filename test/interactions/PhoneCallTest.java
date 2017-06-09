package interactions;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PhoneCallTest {

   private final long idInput;
   private final long contactIdInput;
   private final int durationSecondsInput;
   private final int durationSecondsExpected;
   private final PhoneCallType callTypeInput;
   private PhoneCall call;

   private final static String SUMMARY_TEXT_CALL_TYPE_FORMAT = "%s%d%n";
   private final static String SUMMARY_TEXT_DURATION_FORMAT = "%d:%d";

   public PhoneCallTest(long idInput, long contactIdInput, int durationSecondsInput, int durationSecondsExpected, PhoneCallType callTypeInput) {
      this.idInput = idInput;
      this.contactIdInput = contactIdInput;
      this.durationSecondsInput = durationSecondsInput;
      this.durationSecondsExpected = durationSecondsExpected;
      this.callTypeInput = callTypeInput;
   }

   @Parameterized.Parameters
   public static Collection data() {
      return Arrays.asList(new Object[][]{
         {100, 201, 1035, 1035, PhoneCallType.PLACED, ""},
         {101, 201, 0, 0, PhoneCallType.MISSED, ""},
         {102, 201, 301, 0, PhoneCallType.MISSED, ""},
         {103, 201, 3019, 3019, PhoneCallType.RECEIVED, ""}
      });
   }

   @Before
   public void setUp() {
      call = new PhoneCall(idInput, contactIdInput, durationSecondsInput, callTypeInput);
   }

   @Test
   public void testGetMessageSummaryText() {
      String expected = String.format(SUMMARY_TEXT_CALL_TYPE_FORMAT, 
              callTypeInput.getDisplayText(), contactIdInput);
      if (!callTypeInput.equals(PhoneCallType.MISSED)) {
         expected += String.format(SUMMARY_TEXT_DURATION_FORMAT, durationSecondsExpected / 60, durationSecondsExpected % 60);
      }
      assertEquals(expected, call.getSummaryText());
   }

   @Test
   public void testGetDurationSeconds() {
      assertEquals(durationSecondsExpected, call.getDurationSeconds());
   }

   @Test
   public void testGetCallType() {
      assertEquals(callTypeInput, call.getCallType());
   }

}
