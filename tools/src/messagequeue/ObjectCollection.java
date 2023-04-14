package messagequeue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * </br>
 * Created by yangxiaohua on 2023/4/14.
 */
public class ObjectCollection {
  private List<Object> collection;

  public ObjectCollection() {
    collection = Collections.synchronizedList(new LinkedList<Object>());
  }

  public void add(Object object) {
    synchronized (collection) {
      if (collection.size() >= 50) {
        collection.remove(0);
      }
      collection.add(object);
    }
  }

  public Object getLatest() {
    synchronized (collection) {
      return collection.get(collection.size() - 1);
    }
  }

  public void clear() {
    synchronized (collection) {
      collection.clear();
    }
  }

  public boolean isEmpty() {
    synchronized (collection) {
      return collection.isEmpty();
    }
  }

  public static void main(String[] args) {
    ObjectCollection oc = new ObjectCollection();

    // Add objects
    for (int i = 1; i <= 100; i++) {
      oc.add("Object " + i);
    }

    // Process objects every 0.5 seconds
    while (true) {
      try {
        Thread.sleep(2000);
        Object object = oc.getLatest();
        if (object != null) {
          System.out.println(object);
          oc.clear();
        }
        if (oc.isEmpty()) {
          System.out.println("All objects processed. Clearing collection.");
          oc.clear();
          break;
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}