class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // monotonic stack will be better to use here as we need position info
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        for(int i = 0 ; i < temperatures.length ; i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.push(i);
        }
        return answer;
    }
}