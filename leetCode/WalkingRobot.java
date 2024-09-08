package leetCode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WalkingRobot {
    public int robotSim(int[] commands, int[][] obstacles) { //time complexity - O(m + n*k)
        int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int x = 0, y = 0;
        int currentDirect = 0, result = 0;
        Set<Pair> set = new HashSet<>();
        for (int[] arr : obstacles) {
            set.add(new Pair(arr[0], arr[1]));
        }
        for (int cmd : commands) {
            if (cmd == -1) {
                currentDirect = (currentDirect + 1) % 4;
            } else if (cmd == -2) {
                currentDirect = (currentDirect + 3) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    Pair pair = new Pair(x + direction[currentDirect][0], y + direction[currentDirect][1]);
                    if (set.contains(pair)) {
                        break;
                    }
                    x += direction[currentDirect][0];
                    y += direction[currentDirect][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
