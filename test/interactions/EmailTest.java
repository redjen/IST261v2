package interactions;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class EmailTest {

   private final static String SUMMARY_TEXT_FORMAT = "Subject: %s%n%n%s";

   private final long emailIdInput;
   private final long emailContactIdInput;
   private final String emailMessageTextInput;
   private final String emailSubjectTextInput;
   private final String emailSubjectTextExpected;
   private final String emailSummaryTextExpected;
   private Email email;

   public EmailTest(long emailIdInput, long emailContactIdInput, String emailMessageTextInput, String emailSubjectTextInput, String emailSubjectTextExpected, String emailSummaryTextExpected) {
      this.emailIdInput = emailIdInput;
      this.emailContactIdInput = emailContactIdInput;
      this.emailMessageTextInput = emailMessageTextInput;
      this.emailSubjectTextInput = emailSubjectTextInput;
      this.emailSubjectTextExpected = emailSubjectTextExpected;
      this.emailSummaryTextExpected = emailSummaryTextExpected;
   }

   @Parameterized.Parameters
   public static Collection data() {
      return Arrays.asList(new Object[][]{
         {100, 201, "Message body", "Message Subject", "Message Subject", String.format(SUMMARY_TEXT_FORMAT, "Message Subject", "Message body")},
         {101, 201, "Message body\\nwith\\nline breaks", "Message Subject", "Message Subject", String.format(SUMMARY_TEXT_FORMAT, "Message Subject", "Message body\\nwith\\nline breaks")}
      });
   }

   @Before
   public void setUp() {
      email = new Email(emailIdInput, emailContactIdInput, emailMessageTextInput, emailSubjectTextInput);
   }

   @Test
   public void testGetMessageSummaryText() {
      assertEquals(emailSummaryTextExpected, email.getSummaryText());
   }

   @Test
   public void testGetSubject() {
      assertEquals(emailSubjectTextExpected, email.getSubject());
   }

}
