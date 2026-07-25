import java.util.*; 
 
class UndergroundSystem { 
    private Map<Integer, Pair> checkInMap = new HashMap<>(); 
    private Map<String, int[]> travelMap = new HashMap<>(); 
 
    class Pair { 
        String station; 
        int time; 
        Pair(String station, int time) { 
            this.station = station; 
            this.time = time; 
        } 
    } 
 
    public UndergroundSystem() {} 
 
    public void checkIn(int id, String stationName, int t) { 
        checkInMap.put(id, new Pair(stationName, t)); 
    } 
 
    public void checkOut(int id, String stationName, int t) { 
        Pair p = checkInMap.remove(id); 
        String key = p.station + "->" + stationName; 
        travelMap.putIfAbsent(key, new int[2]); 
        travelMap.get(key)[0] += t - p.time; 
        travelMap.get(key)[1]++; 
    } 
 
    public double getAverageTime(String startStation, String endStation) { 
        int[] data = travelMap.get(startStation + "->" + 
 endStation); 
        return (double) data[0] / data[1]; 
    } 
} 
