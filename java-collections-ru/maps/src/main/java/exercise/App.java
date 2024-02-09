package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// BEGIN
class App {
  public static Map<String, Integer> getWordCount(String sentence) {
    if (Objects.equals(sentence, "")){
     Map<String, Integer> emptyWords = new HashMap<>();
     return emptyWords;
    }
    String[] words = sentence.split(" ");
    Map<String, Integer> wordCount = new HashMap<>();
    for(String word:words){
      if (wordCount.containsKey(word)) {
        wordCount.put(word, wordCount.get(word) + 1);
      } else  {
        wordCount.put(word, 1);
      }

    }
    return wordCount;
  }

  public static String toString(Map<String, Integer> wordCount) {
    StringBuilder body = new StringBuilder();
    String string = "{}";
    if (wordCount.isEmpty())
      return string;
    else {
    for (Map.Entry entry : wordCount.entrySet()) {
      String element = ("  " + entry.getKey() + ":" + " " + entry.getValue() + "\n");
      body.append(element);
      element = "";
    }
      return "{" + "\n" + body + "}";
  }
}}
