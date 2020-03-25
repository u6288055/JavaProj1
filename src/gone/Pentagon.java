package gone;

public class Pentagon extends Shape {
    private double wide;
    private double high;
    private String color;

    // Constructors
    public Pentagon()
    {
        //add your code here
        this.high = 0;
        this.wide = 0;
    }
    public Pentagon(String color, double high, double wide) {
        //add your code here
        super(color);
        this.high = high;
        this.wide = wide;
    }

    @Override
    public String toString() {
        //add your code here
        String send;
        send = "Pentagon[high="+this.high+",wide="+this.wide+super.toString()+"]";
        return send;
    }

    // Override the inherited getArea() to provide the proper implementation
    @Override
    public double getArea() {
        //add your code here
        double area=0;
        area = (5*high*wide)/2;
        return area;
    }

    public double getArea(double high, double wide) {
        //add your code here
        this.high=high;
        this.wide=wide;
        double pentagon=0;
        pentagon = (5*high*wide)/2;
        return pentagon;
    }
}
