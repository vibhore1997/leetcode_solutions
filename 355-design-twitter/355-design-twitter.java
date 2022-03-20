class Twitter {
    Map<Integer, Integer> tmap;
    Map<Integer, Set<Integer>> fmap;
    List<Integer> posts;

    public Twitter() {
        tmap = new HashMap<>();
        fmap = new HashMap<>();
        posts = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tmap.put(tweetId, userId);
        posts.add(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> hs = fmap.get(userId);
        int count = 1;
        List<Integer> res = new ArrayList<>();
        int idx = posts.size() - 1;
        
        while (count <= 10 && idx >= 0) {
            int id = tmap.get(posts.get(idx));
            if (id == userId || (hs != null && hs.contains(id))) {
                res.add(posts.get(idx));
                count++;
            }
            idx--;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (fmap.containsKey(followerId)) {
            fmap.get(followerId).add(followeeId);
        } else {
            Set<Integer> hs = new HashSet<>();
            hs.add(followeeId);
            fmap.put(followerId, hs);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (fmap.containsKey(followerId)) {
            if (fmap.get(followerId) != null && fmap.get(followerId).contains(followeeId)) {
                fmap.get(followerId).remove(followeeId);
                
                // if (fmap.get(followerId).size() == 0) {
                //     fmap.remove(followerId);
                // }
            }
        }
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