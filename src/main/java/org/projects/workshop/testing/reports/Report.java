package org.projects.workshop.testing.reports;

import org.projects.workshop.testing.model.ParsedFile;

public interface Report {

  String generateReport(ParsedFile parsedFile);

}
