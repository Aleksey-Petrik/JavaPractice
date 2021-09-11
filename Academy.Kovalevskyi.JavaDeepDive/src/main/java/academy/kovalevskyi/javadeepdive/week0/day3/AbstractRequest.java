package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;

import java.util.ArrayList;

public abstract class AbstractRequest<T> {
  protected Csv target;

  protected AbstractRequest(Csv target) {
    this.target = target;
  }

  protected AbstractRequest() {
    this(null);
  }

  protected int getIdColumn(String columnName) {
    return getIdColumn(target, columnName);
  }

  protected int getIdColumn(Csv csv, String columnName) {
    if (columnName == null || columnName.isEmpty()) {
      return -1;
    }
    for (int i = 0; i < csv.header().length; i++) {
      if (csv.header()[i].equals(columnName)) {
        return i;
      }
    }
    return -1;
  }

  protected abstract T execute() throws RequestException;

  protected Csv newCsv(ArrayList<String[]> valueList) {
    return new Csv.Builder().header(target.header()).values(valueList.toArray(String[][]::new)).build();
  }

  protected void checkHeader() throws RequestException {
    checkHeader(target);
  }

  protected void checkHeader(Csv csv) throws RequestException {
    if (!csv.withHeader()) {
      throw new RequestException("The table header does not exist!");
    }
  }

  protected Selector selectorNonNull(Selector selector) throws RequestException {
    if (selector == null) {
      throw new RequestException("The table header does not exist!");
    }
    return selector;
  }

}
