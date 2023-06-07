public class Ball {
    public int r;
    public String name;
    public Ball (int r, String name) {
        this.r = r;
        this.name = name;
    }

    public String toString() {
        return "Ball{" +
                "r=" + r +
                ", name='" + name + '\'' +
                '}';
    }
}
