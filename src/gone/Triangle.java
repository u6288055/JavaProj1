package gone;

/*  The structure of Triangle class is similar to Rectangle */
public class Triangle extends Shape {


   //add your code here
   private double base;
   private double height;
   private String color;

    // Constructors
    public Triangle()
    {
        //add your code here
        this.base = 0;
        this.height = 0;
    }
    public Triangle(String color, double base, double height) {
        //add your code here
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public String toString() {
        //add your code here
        String send;
        //System.out.println("Rectangle[length="+this.length+",width="+this.width+",Shape[color="+super.toString()+"]]");
        send = "Triangle[base="+this.base+",height="+this.height+super.toString()+"]";
        return send;
    }

    // Override the inherited getArea() to provide the proper implementation
    @Override
    public double getArea() {
        //add your code here
        double area=0;
        area = height*base*0.5;
        return area;
    }

    public double getArea(double base, double height) {
        //add your code here
        this.base=base;
        this.height=height;
        double triangle=0;
        triangle = base*height*0.5;
        return triangle;
    }


}
