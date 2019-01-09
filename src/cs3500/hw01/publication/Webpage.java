package cs3500.hw01.publication;

/**
 * This class represents an webpage capable of anything that a publication is capable of.
 */
public class Webpage implements Publication {

  private String title;//represents the web-page title.
  private String url; //represents the web-page url.
  private String retrieved; //represents the web-page retrieved.

  /**
   * Instantiates a webpage.
   */
  public Webpage(String title, String url, String retrieved) {
    this.title = title;
    this.url = url;
    this.retrieved = retrieved;
  }

  @Override
  public String citeApa() {
    return String.format("%s. Retrieved %s, from %s.", this.title, this.retrieved, this.url);
  }

  @Override
  public String citeMla() {
    return String.format("\"%s.\" Web. %s <%s>.", this.title, this.retrieved, this.url);
  }
}
