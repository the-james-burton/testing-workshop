package org.projects.workshop.testing;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.projects.workshop.testing.model.ParsedFile;
import org.projects.workshop.testing.reports.Report;

public class ProcessFileTest {

  private static final String MOCK_MARKET_CAP_SUMMARY_REPORT_OUTPUT = "marketCapSummaryReportOutput";

  private static final String MOCK_LONG_REPORT_OUTPUT = "longReportOutput";

  private ProcessFile processFile;

  private ParsedFile parsedFile;

  @Mock
  FileParser mockFileParser;

  @Mock
  Report mockLongReport;

  @Mock
  Report mockMarketCapSummaryReport;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    parsedFile = new ParsedFile();

    when(mockFileParser.parseFile(anyString()))
        .thenReturn(parsedFile);
    when(mockLongReport.generateReport(any(ParsedFile.class)))
        .thenReturn(MOCK_LONG_REPORT_OUTPUT);
    when(mockMarketCapSummaryReport.generateReport(any(ParsedFile.class)))
        .thenReturn(MOCK_MARKET_CAP_SUMMARY_REPORT_OUTPUT);

    processFile = new ProcessFile();
    processFile.setFileParser(mockFileParser);
    processFile.setReportGenerator1(mockLongReport);
    processFile.setReportGenerator2(mockMarketCapSummaryReport);
  }

  @Test
  public void processShouldContainBothReports() {
    String result = processFile.process("anything");
    verify(mockLongReport).generateReport(parsedFile);
    verify(mockMarketCapSummaryReport).generateReport(parsedFile);
    assertThat(result).contains(MOCK_LONG_REPORT_OUTPUT, MOCK_MARKET_CAP_SUMMARY_REPORT_OUTPUT);
  }

}
