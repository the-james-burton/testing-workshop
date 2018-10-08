package org.projects.workshop.testing;

import static org.assertj.core.api.Assertions.*;

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
    assertThat(out.size()).isGreaterThan(0);
    String result = out.toString();
    assertThat(result.length()).isGreaterThan(0);
    assertThat(result).contains(
        "---------------------------",
        "              Europe : £ 102434.38m",
        "Company Name:ENTERTAINMENT ONE LTD.");
    assertThat(result).hasSize(20278);
  }
}
