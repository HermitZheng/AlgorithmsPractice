package Design;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/4/13
 */
public class Twitter {
    private int tick;
    private Map<Integer, List<Integer>> posts;
    private Map<Integer, Set<Integer>> following;
    private Map<Integer, Integer> postTick;
    private static final int LIMIT = 10;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        posts = new HashMap<>();
        following = new HashMap<>();
        postTick = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<Integer> userPosts = posts.computeIfAbsent(userId, x -> new LinkedList<>());
        if (userPosts.size() == LIMIT)
            userPosts.remove(userPosts.size() - 1);
        userPosts.add(0, tweetId);
        postTick.put(tweetId, tick++);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        Iterator<Integer> it = posts.computeIfAbsent(userId, x -> new LinkedList<>()).iterator();
        // add current user's posts
        for (int i = 0; i < LIMIT && it.hasNext(); i++)
            ans.add(it.next());

        for (int uid : following.computeIfAbsent(userId, x -> new LinkedHashSet<>())) {
            if (userId == uid) continue;
            List<Integer> tmp = new ArrayList<>();
            it = posts.computeIfAbsent(uid, x -> new LinkedList<>()).iterator();

            Integer pid1 = ans.size() > 0 ? ans.get(0) : null;
            Integer pid2 = it.hasNext() ? it.next() : null;

            // merge K linked list with 10 items limit
            for (int i = 1; (pid1 != null || pid2 != null) & tmp.size() < LIMIT; ) {
                if (pid1 != null && pid2 != null) {
                    if (postTick.get(pid1) > postTick.get(pid2)) {
                        tmp.add(pid1);
                        pid1 = i < ans.size() ? ans.get(i++) : null;
                    } else {
                        tmp.add(pid2);
                        pid2 = it.hasNext() ? it.next() : null;
                    }
                } else if (pid1 != null) {
                    tmp.add(pid1);
                    pid1 = i < ans.size() ? ans.get(i++) : null;
                } else {
                    tmp.add(pid2);
                    pid2 = it.hasNext() ? it.next() : null;
                }
            }
            ans = tmp;
        }

        return ans;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, x -> new HashSet<>()).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, x -> new HashSet<>()).remove(followeeId);
    }
}