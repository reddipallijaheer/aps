class CooldownTask {
    Map.Entry<Character, Integer> task;
    int availableAt;

    CooldownTask(Map.Entry<Character, Integer> task, int availableAt) {
        this.task = task;
        this.availableAt = availableAt;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Map.Entry<Character, Integer>> heap = 
            new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        Queue<CooldownTask> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        int time = 0;

        for (char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (Map.Entry<Character, Integer> task: map.entrySet()) {
            heap.add(task);
        }

        while (!heap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!heap.isEmpty()) {
                Map.Entry<Character, Integer> task = heap.poll();
                task.setValue(task.getValue() - 1);
                if (task.getValue() > 0) {
                    queue.add(new CooldownTask(task, time + n));
                }
            }
            if (!queue.isEmpty() && queue.peek().availableAt == time) {
                heap.add(queue.poll().task);
            }
        }

        return time;
    }
}