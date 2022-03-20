class UndergroundSystem {

    Map<Integer, Pair<String, Integer>> custMap;
    Map<String, Pair<Double, Double>> avgMap;
    public UndergroundSystem() {
        custMap = new HashMap<>();
        avgMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        custMap.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> p = custMap.get(id);
        String start = p.getKey();
        int sTime = p.getValue();
        
        int tripTime = t - sTime;
        
        String key = start + "=>" + stationName;
        if (avgMap.containsKey(key)) {
            Pair<Double,Double> res = avgMap.get(key);
            avgMap.put(key, new Pair(res.getKey() + tripTime, res.getValue() + 1));
        } else {
            avgMap.put(key, new Pair(tripTime * 1.0, 1.0));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<Double, Double> res = avgMap.get(startStation + "=>" + endStation);
        return res.getKey()/res.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */