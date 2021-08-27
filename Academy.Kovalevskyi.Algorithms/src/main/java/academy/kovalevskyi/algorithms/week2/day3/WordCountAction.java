package academy.kovalevskyi.algorithms.week2.day3;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

public class WordCountAction extends RecursiveTask<Integer> {

  private final TrieNode node;

  public WordCountAction(TrieNode node) {
    this.node = node;
  }

  @Override
  protected Integer compute() {
    int count = node.finalCharacter ? 1 : 0;
    List<WordCountAction> subTasks = new LinkedList<>();

    for (Map.Entry<Character, TrieNode> child : node.children.entrySet()) {
      WordCountAction task = new WordCountAction(child.getValue());
      task.fork(); // запустим асинхронно
      subTasks.add(task);
    }

    for (WordCountAction task : subTasks) {
      count += task.join(); // дождёмся выполнения задачи и прибавим результат
    }

    return count;
  }
}
