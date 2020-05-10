import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
class Twitter {

    Map<Integer, Set<Integer>> follows = new HashMap<>();
    Map<Integer, List<int[]>> tweets = new HashMap<>();

    int serial = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(final int userId, final int tweetId) {
        List<int[]> userTweets = tweets.computeIfAbsent(userId, x -> new ArrayList<>());
        userTweets.add(new int[]{userId, tweetId, userTweets.size(), serial++});
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(final int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[3] - a[3]);
        Set<Integer> followees = follows.computeIfAbsent(userId, x -> new HashSet<>());
        followees.add(userId);
        for (int followee : followees) {
            if (tweets.containsKey(followee)) {
                List<int[]> userTweets = tweets.get(followee);
                pq.add(userTweets.get(userTweets.size() - 1));
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10 && !pq.isEmpty(); i++) {
            int[] curr = pq.poll();
            res.add(curr[1]);
            if (curr[2] > 0) {
                pq.add(tweets.get(curr[0]).get(curr[2] - 1));
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(final int followerId, final int followeeId) {
        follows.computeIfAbsent(followerId, x -> new HashSet<>()).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(final int followerId, final int followeeId) {
        follows.computeIfAbsent(followerId, x -> new HashSet<>()).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

