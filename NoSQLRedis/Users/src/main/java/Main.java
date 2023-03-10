import redis.clients.jedis.Jedis;
import redis.clients.jedis.resps.Tuple;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("redis://127.0.0.1:6379");
//        Tuple tuple;

        // Add users to the sorted set
        jedis.zadd("users", 0, "user 1");
        jedis.zadd("users", 0, "user 2");
        jedis.zadd("users", 0, "user 3");
        jedis.zadd("users", 0, "user 4");
        jedis.zadd("users", 0, "user 5");
        jedis.zadd("users", 0, "user 6");
        jedis.zadd("users", 0, "user 7");
        jedis.zadd("users", 0, "user 8");
        jedis.zadd("users", 0, "user 9");
        jedis.zadd("users", 0, "user 10");
        jedis.zadd("users", 0, "user 11");
        jedis.zadd("users", 0, "user 12");
        jedis.zadd("users", 0, "user 13");
        jedis.zadd("users", 0, "user 14");
        jedis.zadd("users", 0, "user 15");
        jedis.zadd("users", 0, "user 16");
        jedis.zadd("users", 0, "user 17");
        jedis.zadd("users", 0, "user 18");
        jedis.zadd("users", 0, "user 19");
        jedis.zadd("users", 0, "user 20");

        Random random = new Random();

        // Loop forever
        while (true) {
            // Wait for 5 seconds
            Thread.sleep(5000);

            // Get the top 10 users from the sorted set
            List<Tuple> tuples = jedis.zrevrangeWithScores("users", 0, 9);
            Set<Tuple> topUsers = new LinkedHashSet<>(tuples);

            // Print the top 10 users
            for (Tuple tuple : topUsers) {
                System.out.println("User " + tuple.getElement() + " has score " + tuple.getScore());
            }

            // Pick a random user to donate
            int randomIndex = random.nextInt(10);
            Tuple randomUserTuple = (Tuple) topUsers.toArray()[randomIndex];
            String randomUser = randomUserTuple.getElement();

            // Donate to the random user
            double currentScore = randomUserTuple.getScore();
            double newScore = currentScore + 1;
            jedis.zadd("users", newScore, randomUser);
            System.out.println("User " + randomUser + " received a donation! New score is " + newScore);

            // 10% chance of promoting a random user
            if (random.nextDouble() < 0.1) {
                // Pick a random user to promote
                int randomIndex2 = random.nextInt(10);
                Tuple randomUserTuple2 = (Tuple) topUsers.toArray()[randomIndex2];
                String randomUser2 = randomUserTuple2.getElement();

                // Promote the random user
                double currentScore2 = randomUserTuple2.getScore();
                double newScore2 = currentScore2 + 1;
                jedis.zadd("users", newScore2, randomUser2);
                System.out.println("User " + randomUser2 + " was promoted! New score is " + newScore2);
            }
        }
    }
}