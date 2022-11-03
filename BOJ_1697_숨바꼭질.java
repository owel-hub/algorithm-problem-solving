import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int max = Math.max(N, K) + 1;
        int[] check = new int[max + 1];
        Arrays.fill(check, -1);

        Queue<Integer> queue = new LinkedList<>();
        check[N] = 0;
        queue.add(N);
        while (check[K] != 0 && !queue.isEmpty()) {
            int front = queue.poll();
            int[] target = {front - 1, front + 1, front * 2};
            for (int x : target) {
                if (x < 0 || x > max || check[x] != -1) continue;
                check[x] = check[front] + 1;
                queue.add(x);
            }
        }
        System.out.println(check[K]);
    }
}
