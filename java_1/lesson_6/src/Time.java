public class Time {
    public int hours;
    public int minutes;
    public int seconds;

    public Time (int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int convertToSeconds () {
        return hours*3600 + minutes*60 + seconds;
    }
    public String toString() {
        return hours+" "+minutes+" "+seconds;
    }

}
