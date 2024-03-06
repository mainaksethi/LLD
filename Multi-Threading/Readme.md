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