package academy.kovalevskyi.algorithms.week2.day2;

import academy.kovalevskyi.algorithms.week2.day0.IntTreeHelper;
import academy.kovalevskyi.algorithms.week2.day0.IntTreeNode;

public class IntSet {
  private static final int DEFAULT_BUCKETS = 3;
  private final IntTreeNode[] buckets;
  private int count;
  private int sum;

  public IntSet(int bucketsSize) {
    buckets = new IntTreeNode[bucketsSize];
  }

  public IntSet() {
    this(DEFAULT_BUCKETS);
  }

  public int getBucketsCount() {
    return buckets.length;
  }

  public int getBucketId(int value) {
    return Math.abs(value % buckets.length);
  }

  public boolean contains(int value) {
    int bucketId = getBucketId(value);
    return IntTreeHelper.hasValue(buckets[bucketId], value);
  }

  public void add(int value) {
    int bucketId = getBucketId(value);
    buckets[bucketId] = IntTreeHelper.addNode(buckets[bucketId], value);
    sum += value;
    count++;
  }

  public int count() {
    return count;
  }

  public int sum() {
    return sum;
  }

  public int countNodes() {
    int count = 0;
    for (IntTreeNode node : buckets) {
      count += node.count();
    }
    return count;
  }

  public int sumNodes() {
    int sum = 0;
    for (IntTreeNode node : buckets) {
      sum += node.sum();
    }
    return sum;
  }
}

