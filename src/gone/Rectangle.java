package gone;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/*
 * The Rectangle class, subclass of Shape
 */
public class Rectangle extends Shape {
   // Private member variables
   //add your code here
   private double width;
   private double length;
   private String color;

   // Constructors
   public Rectangle()
   {
	  //add your code here
      this.length = 0;
      this.width = 0;
   }
   public Rectangle(String color, double length, double width) {
      //add your code here
      super(color);
      this.length = length;
      this.width = width;
   }

   @Override
   public String toString() {
      //add your code here
      String send;
      //System.out.println("Rectangle[length="+this.length+",width="+this.width+",Shape[color="+super.toString()+"]]");
      send = "Rectangle[length="+this.length+",width="+this.width+super.toString()+"]";
      return send;
   }

   // Override the inherited getArea() to provide the proper implementation
   @Override
   public double getArea() {
      //add your code here
      double area=0;
      area = length*width;
      return area;
   }

   public double getArea(double length, double width) {
	   	 //add your code here
      this.length=length;
      this.width=width;
      double rectangle=0;
      rectangle = length*width;
      return rectangle;
	   }
}
