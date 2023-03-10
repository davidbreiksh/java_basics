import redis.clients.jedis.Jedis;
import redis.clients.jedis.resps.Tuple;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RedisStorage {
    private Jedis jedis;
    private Tuple tuple;
    private final String KEY = "leaderboard";

    public RedisStorage() {
        this.jedis = new Jedis("redis://127.0.0.1:6379");
    }

    public void add(String user, double score) {
        jedis.zadd(KEY, score, user);
    }

    public Set<Tuple> getLeaders() {
        List<Tuple> leaders = jedis.zrevrangeWithScores(KEY, 0, 9);
        return new LinkedHashSet<>(leaders);
    }

    public void donate(String user) {
        double currentScore = jedis.zscore(KEY, user);
            double newScore = currentScore + 1;
            jedis.zadd(KEY, newScore, user);

    }

    public void close() {
        jedis.close();
    }
}