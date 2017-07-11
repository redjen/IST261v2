package data.contact;

import data.Contact;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author redjen
 */
public class ContactTest {

   private static final long TEST_ID = 99999;
   private static final String TEST_FIRST_NAME = "testfirst1";
   private static final String TEST_LAST_NAME = "testlast1";
   private static final String TEST_PHONE = "phone1";
   private static final String TEST_EMAIL = "email1@example.com";
   private static final String TEST_TWITTER = "twitter1";
   private static final String TEST_FACEBOOK = "facebook1";
   
   private Contact contact;

   public ContactTest() {
   }

   @Before
   public void setUp() {
      contact = new Contact(TEST_ID, TEST_FIRST_NAME, TEST_LAST_NAME, TEST_PHONE, TEST_EMAIL, TEST_TWITTER, TEST_FACEBOOK);
   }

   @Test
   public void testUpdate() {
   }

   @Test
   public void testGetId() {
      assertEquals(TEST_ID, contact.getId());
   }

   @Test
   public void testGetFirstName() {
      assertEquals(TEST_FIRST_NAME, contact.getFirstName());
   }

   @Test
   public void testSetFirstName() {
      contact.setFirstName("newname");
      assertEquals("newname", contact.getFirstName());
   }

   @Test
   public void testGetLastName() {
      assertEquals(TEST_LAST_NAME, contact.getLastName());
   }

   @Test
   public void testSetLastName() {
      contact.setLastName("newname");
      assertEquals("newname", contact.getLastName());
   }

   @Test
   public void testGetPhoneNumber() {
      assertEquals(TEST_PHONE, contact.getPhoneNumber());
   }

   @Test
   public void testSetPhoneNumber() {
      contact.setPhoneNumber("newphone");
      assertEquals("newphone", contact.getPhoneNumber());
   }

   @Test
   public void testGetEmail() {
      assertEquals(TEST_EMAIL, contact.getEmail());
   }

   @Test
   public void testSetEmail() {
      contact.setEmail("newmail");
      assertEquals("newmail", contact.getEmail());
   }

   @Test
   public void testGetTwitterId() {
      assertEquals(TEST_TWITTER, contact.getTwitterId());
   }

   @Test
   public void testSetTwitterId() {
      contact.setTwitterId("newid");
      assertEquals("newid", contact.getTwitterId());
   }

   @Test
   public void testGetFacebookId() {
      assertEquals(TEST_FACEBOOK, contact.getFacebookId());
   }

   @Test
   public void testSetFacebookId() {
      contact.setFacebookId("newid");
      assertEquals("newid", contact.getFacebookId());
   }

}
