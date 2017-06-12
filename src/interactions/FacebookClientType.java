package interactions;

/**
 * FacebookClientType provides a valid list of Facebook clients and the URL
 * protocols and prefix to call them. This allows URLs to be generated to load
 * contact in the browser or in the mobile application.
 * 
 */
public enum FacebookClientType {
   DESKTOP("https://www.facebook.com"),
   MOBILE("https://touch.facebook.com"),
   APP("facebook://");
   
   private String urlPrefix;

   private FacebookClientType(String urlPrefix) {
      this.urlPrefix = urlPrefix;
   }

   public String getUrlPrefix() {
      return urlPrefix;
   }

}
