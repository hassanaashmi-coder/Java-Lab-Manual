class ParkingSystem { 
    int[] p = new int[4]; 
 
    public ParkingSystem(int big, int medium, int small) { 
        p[1] = big; 
        p[2] = medium; 
        p[3] = small; 
    } 
 
    public boolean addCar(int carType) { 
        return p[carType]-- > 0; 
    } 
} 
 
 
