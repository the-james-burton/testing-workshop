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
    ApplicationMain.main("");
    assertTrue(out.size() > 0);
    String result = out.toString();
    assertTrue(result.length() > 0);
    assertTrue(result.contains("---------------------------"));
    assertTrue(result.contains("              Europe : £ 102434.38m"));
    assertTrue(result.contains("Company Name:ENTERTAINMENT ONE LTD."));
    assertTrue(result.length() == 20278);
  }
}
