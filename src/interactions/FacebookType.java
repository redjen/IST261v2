package interactions;

/**
 * The FacebookType class provides a list of valid Facebook post types
 * 
 */
public enum FacebookType {
   
   STATUS("status", "status"),
   LINK("link", "status");
   
   private String displayText;
   private String urlPart;

   private FacebookType(String displayText, String urlPart) {
      this.displayText = displayText;
      this.urlPart = urlPart;
   }

   public String getDisplayText(String displayText) {
      return displayText;
   }
   
   public String getURLPart() {
      return urlPart;
   }

}
