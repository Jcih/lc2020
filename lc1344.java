class Solution {
    public double angleClock(int hour, int minutes) {
        double m = minutes  * 6 ;
        double h = hour  * 30 % 360+ minutes / 2.0 ;
        
        double diff = Math.abs(h - m);
        return Math.min(diff, 360 - diff);
    }
}