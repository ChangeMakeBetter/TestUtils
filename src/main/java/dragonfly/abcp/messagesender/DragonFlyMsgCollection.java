package dragonfly.abcp.messagesender;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * </br>
 * Created by yangxiaohua on 2023/4/14.
 */
public class DragonFlyMsgCollection {

  private final List<DragonFlyMessage> collection;
  private final ReentrantLock lock = new ReentrantLock();

  public DragonFlyMsgCollection() {
    collection = Collections
      .synchronizedList(new LinkedList<>());
  }

  public void add(DragonFlyMessage msg) {
    System.out.println("oc.add:" + msg.getContent());
    lock.lock();
    try {
      collection.add(msg);
    } finally {
      lock.unlock();
    }
  }

  public DragonFlyMessage getLatest() {
    lock.lock();
    try {
      return collection.get(collection.size() - 1);
    } finally {
      lock.unlock();
    }
  }

  public boolean isEmpty() {
    lock.lock();
    try {
      return collection.isEmpty();
    } finally {
      lock.unlock();
    }
  }

  public int size() {
    lock.lock();
    try {
      return collection.size();
    } finally {
      lock.unlock();
    }
  }

  public void clear() {
    System.out.println("oc.clear");
    lock.lock();
    try {
      collection.clear();
    } finally {
      lock.unlock();
    }
  }

  public boolean hasSame(DragonFlyMessage msg) {
    lock.lock();
    try {
      if (collection.isEmpty()) {
        return false;
      } else {
        return getLatest().equals(msg);
      }
    } finally {
      lock.unlock();
    }
  }

}