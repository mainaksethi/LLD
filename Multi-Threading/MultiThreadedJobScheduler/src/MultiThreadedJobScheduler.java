import java.util.*;
import java.util.concurrent.*;

/**
 * Asked in Uber
 * Design a multithreaded job scheduler. A job can have multiple tasks, and each task can have a pre-requisite
 * task as well.
 * Jobs should run in as much parallelization as possible
 */


/**
 * Learning: Implement multi-threaded topological sort in java.
 */

// TODO : Implement with a global task scheduler not blocking single thread with a job.

class MultiThreadedJobScheduler {

    ExecutorService threadPool;

    MultiThreadedJobScheduler(int threads) {
        threadPool = Executors.newFixedThreadPool(threads);
    }

    public void submitJob(Job job) {
        threadPool.submit(() -> {
            try {
                executeJob(job);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private Future<Object> executeJob(Job job) throws ExecutionException, InterruptedException {
        // topological sort

        Deque<Future<Integer>> deque = new ArrayDeque<>();

        Map<Integer, List<Integer>> reverseDep = new HashMap<>();
        Map<Integer, Integer> depFreq = new HashMap<>();

        for (Map.Entry<Integer, Runnable> entry: job.taskMap.entrySet()) {
            depFreq.put(entry.getKey(), 0);
        }

        for (Map.Entry<Integer, List<Integer>> entry: job.prerequisite.entrySet()) {
            Integer node = entry.getKey();
            depFreq.put(entry.getKey(), entry.getValue().size());
            for (Integer deps: entry.getValue()) {
                reverseDep.putIfAbsent(deps, new ArrayList<>());
                List<Integer> reverseDeps = reverseDep.get(deps);
                reverseDeps.add(node);
            }
        }

        while(!deque.isEmpty()) {
            Future<Integer> taskCompletionFuture = deque.peekFirst();
            deque.poll();
            if (!taskCompletionFuture.isDone()) {
                deque.push(taskCompletionFuture);
            } else {
                Integer taskId = taskCompletionFuture.get();
                System.out.println("Job: " + job.name + " Task: "  + taskId + "completed");
                for (Integer newNode: reverseDep.get(taskId)) {
                    depFreq.put(newNode, depFreq.get(newNode)-1);
                    if (depFreq.get(newNode) == 0) {
                        Future<Integer> newTask = threadPool.submit(() -> {
                            job.taskMap.get(newNode);
                            return newNode;
                        });
                        deque.push(newTask);
                    }
                }
            }
        }
        System.out.println("Job " + job.name + " completed");
        return null;
    }
}

class Job {

    public String name;
    public Map<Integer, Runnable> taskMap;
    public Map<Integer, List<Integer>> prerequisite;
}