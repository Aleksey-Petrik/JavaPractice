package academy.kovalevskyi.algorithms.week2.day0;

import java.util.Objects;

public record IntTreeNode(
        int value,
        int sum,
        int count,
        int maxDepth,
        int minDepth,
        IntTreeNode left,
        IntTreeNode right) {

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntTreeNode that = (IntTreeNode) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
