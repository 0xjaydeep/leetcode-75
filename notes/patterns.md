# 🧠 Java Patterns Cheatsheet — LC75

## Arrays & Hashing
```java
Map<Integer, Integer> freq = new HashMap<>();
freq.put(n, freq.getOrDefault(n, 0) + 1);
Set<Integer> seen = new HashSet<>();
```

## Two Pointers
```java
int l = 0, r = arr.length - 1;
while (l < r) { ... l++; r--; }
```

## Sliding Window — Variable
```java
int l = 0, max = 0;
for (int r = 0; r < s.length(); r++) {
    // expand: add s.charAt(r) to window
    while (/* window invalid */) l++; // shrink
    max = Math.max(max, r - l + 1);
}
```

## Sliding Window — Fixed (size k)
```java
// build first window then slide
for (int i = k; i < arr.length; i++) {
    sum += arr[i] - arr[i - k];
}
```

## Binary Search
```java
int lo = 0, hi = arr.length - 1;
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) lo = mid + 1;
    else hi = mid - 1;
}
```

## Monotonic Stack
```java
Deque<Integer> stack = new ArrayDeque<>();
for (int i = 0; i < arr.length; i++) {
    while (!stack.isEmpty() && arr[stack.peek()] < arr[i])
        stack.pop();
    stack.push(i);
}
```

## Linked List — Fast/Slow Pointer
```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next; fast = fast.next.next;
}
// slow is at midpoint
```

## Tree — DFS (Recursive)
```java
private int dfs(TreeNode node) {
    if (node == null) return 0;
    int l = dfs(node.left), r = dfs(node.right);
    return 1 + Math.max(l, r);
}
```

## Tree — BFS (Level Order)
```java
Queue<TreeNode> q = new LinkedList<>();
q.offer(root);
while (!q.isEmpty()) {
    for (int i = 0, size = q.size(); i < size; i++) {
        TreeNode node = q.poll();
        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
    }
}
```

## Trie Node
```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}
```

## Heap / Priority Queue
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
// Custom: sort by first element of int[]
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
```

## Graph — DFS
```java
boolean[] visited = new boolean[n];
void dfs(int node, List<List<Integer>> adj) {
    visited[node] = true;
    for (int nei : adj.get(node))
        if (!visited[nei]) dfs(nei, adj);
}
```

## Graph — BFS
```java
Queue<Integer> q = new LinkedList<>();
q.offer(start); visited[start] = true;
while (!q.isEmpty()) {
    int node = q.poll();
    for (int nei : adj.get(node))
        if (!visited[nei]) { visited[nei] = true; q.offer(nei); }
}
```

## Union-Find (with path compression + rank)
```java
int[] parent, rank;
int find(int x) {
    return parent[x] == x ? x : (parent[x] = find(parent[x]));
}
void union(int x, int y) {
    int px = find(x), py = find(y);
    if (px == py) return;
    if (rank[px] < rank[py]) { int t = px; px = py; py = t; }
    parent[py] = px;
    if (rank[px] == rank[py]) rank[px]++;
}
```

## 1D DP
```java
int[] dp = new int[n + 1];
dp[0] = 1; dp[1] = 1;
for (int i = 2; i <= n; i++)
    dp[i] = dp[i-1] + dp[i-2];
```

## 2D DP
```java
int[][] dp = new int[m + 1][n + 1];
for (int i = 1; i <= m; i++)
    for (int j = 1; j <= n; j++)
        dp[i][j] = /* recurrence */;
```

## Bit Manipulation
```java
n & (n - 1)           // remove lowest set bit (check power of 2: n & n-1 == 0)
n & (-n)              // isolate lowest set bit
Integer.bitCount(n)   // count set bits
n ^ n == 0            // XOR with itself = 0 (useful for missing number)
```
