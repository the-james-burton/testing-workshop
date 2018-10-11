package org.projects.workshop.testing;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class ApplicationMainTest {

  private final ByteArrayOutputStream out = new ByteArrayOutputStream();

  @Before
  public void setUp() {
    System.setOut(new PrintStream(out));
  }

  @Test
  public void mainShouldRunWithoutError() {
    ApplicationMain.main("src/test/resources/lse-companies-with-no-mkt-cap.tsv");
    assertTrue(out.size() > 0);
    String result = out.toString();
    assertTrue(result.length() > 0);
    assertTrue(result.contains("---------------------------"));
    assertTrue(result.contains("              Europe : £   2330.06m"));
    assertTrue(result.contains("Company Name:ENTERTAINMENT ONE LTD."));
  }
}
