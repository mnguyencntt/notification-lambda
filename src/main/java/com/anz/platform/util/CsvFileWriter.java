package com.anz.platform.util;

import static com.anz.platform.util.Constants.C_COMMA;
import static com.anz.platform.util.Constants.NEW_LINE_SEPARATOR;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import com.anz.platform.exception.NotificationException;
import com.anz.platform.model.Notification;

public final class CsvFileWriter {

  private CsvFileWriter() {
    throw new UnsupportedOperationException();
  }

  private static final Object[] PROV_HEADERS = {"Id", "ReceiverUserId", "Subject", "ContentBody"};

  public static String writeCsvFile(final List<Notification> items, final String fileAbsolutePath) throws NotificationException {
    try (final FileWriter fileWriter = new FileWriter(fileAbsolutePath);
        final CSVPrinter csvFilePrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withDelimiter(C_COMMA).withRecordSeparator(NEW_LINE_SEPARATOR))) {
      csvFilePrinter.printRecord(PROV_HEADERS);
      for (Notification item : items) {
        final List<String> dataRecords = new ArrayList<>();

        dataRecords.add(item.getId());
        dataRecords.add(item.getReceiverUserId());
        dataRecords.add(item.getSubject());
        dataRecords.add(item.getContentBody());
        // studentDataRecord.add(item.getInsertionDateTime());
        // studentDataRecord.add(item.getLastUpdateDateTime());

        csvFilePrinter.printRecord(dataRecords);
      }
      return "CSV file was created successfully";
    } catch (IOException e) {
      throw new NotificationException(e.getMessage(), fileAbsolutePath);
    }
  }
}
