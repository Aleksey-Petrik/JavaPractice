package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;

import java.util.ArrayList;
import java.util.Objects;

public class SelectRequest extends AbstractRequest<String[][]> {
  private Selector selector;
  private String[] columns;

  private SelectRequest(Csv target, Selector selector, String[] columns) {
    super(target);
    this.selector = selector;
    this.columns = columns;
  }

  @Override
  public String[][] execute() throws RequestException {
    checkHeader();

    var valuesList = new ArrayList<String[]>();
    int column = selector != null ? getIdColumn(selector.fieldName()) : -1;

    if (columns == null || (columns.length == 1 && "*".equals(columns[0]))) {
      if (column == -1) {
        return target.values();
      }
      columns = target.header();
    }

    for (String[] value : target.values()) {
      if (column == -1 || value[column].equals(selector.value())) {
        String[] selectValues = new String[columns.length];
        for (int i = 0; i < columns.length; i++) {
          selectValues[i] = value[getIdColumn(columns[i])];
        }
        valuesList.add(selectValues);
      }
    }
    return valuesList.toArray(String[][]::new);
  }

  public static class Builder {
    private Selector selector;
    private String[] columns;
    private Csv csv;

    public Builder where(Selector selector) {
      this.selector = selector;
      return this;
    }

    public Builder select(String[] columns) {
      this.columns = columns;
      return this;
    }

    public Builder from(Csv csv) {
      this.csv = csv;
      return this;
    }

    public SelectRequest build() {
      Objects.nonNull(csv);
      return new SelectRequest(csv, selector, columns);
    }
  }
}
