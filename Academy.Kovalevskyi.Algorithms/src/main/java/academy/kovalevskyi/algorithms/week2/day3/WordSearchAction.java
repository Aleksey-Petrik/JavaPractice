package academy.kovalevskyi.algorithms.week2.day3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

public class WordSearchAction extends RecursiveTask<List<String>> {

  private final TrieNode node;

  public WordSearchAction(TrieNode node) {
    this.node = node;
  }

  @Override
  protected List<String> compute() {
    List<WordSearchAction> subTasks = new ArrayList<>();
    List<String> words = new ArrayList<>();

    if (node.finalCharacter) {
      words.add(node.value);
    }

    for (Map.Entry<Character, TrieNode> child : node.children.entrySet()) {
      WordSearchAction task = new WordSearchAction(child.getValue());
      task.fork(); // запустим асинхронно
      subTasks.add(task);
    }

    for (WordSearchAction task : subTasks) {
      words.addAll(task.join()); // дождёмся выполнения задачи и прибавим результат
    }

    return words;
  }
}
