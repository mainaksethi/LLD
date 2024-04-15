### Multi-Threading
This directory contains multiple multi-threading problem statements \
picked from educative.io website.


### Raw-Notes

1. Re-enterant lock: \
    Always use await and signal.\
    Release the lock in finally block using below piece of code.
    ```
    finally {
       if (lock.isHeldByCurrentThread()) {
           lock.unlock();
       }
    }
   ```
2. Normally we have tendency to make separate queues for consumers /
   producers. But sometime its ok to have same lock across both /
   and keep all threads in same queue. After waking up /
   either of them will will proceed. Refer to ReadWriteLock problem.