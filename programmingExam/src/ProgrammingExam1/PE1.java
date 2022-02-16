package ProgrammingExam1;
import java.awt.Color;
import java.util.ArrayList;

/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Kabir Patel
Student Number: 217631318
Course Section: Section Z
*/

public class PE1 {
//    public static void main(String[] args) {
//
//        /* A canvas should be created for drawing.
//         * All the shapes should be drawn on the canvas.
//         * The bottom left coordinate of the canvas is (0,0)
//         * The top right coordinates of the canvas is (1, 1)
//         * The input parameter to Draw() constructor is the
//         * title of the canvas.
//         */
//        Draw blankCanvas = new Draw("Programming Exam 1");
//
//        /* To draw a point, point function is called with proper parameters:
//         * point(x_coordinate_of_point, y_coordinate_of_point)
//         */
//        blankCanvas.point(0.7, 0.7);
//
//        /* To draw a circle, circle function is called with proper parameters:
//         * circle(x_coordinate_of_center, y_coordinate_of_center, radius)
//         */
//        blankCanvas.circle(0.5, 0.5, 0.5);
//
//        /* To draw a square, square function is called with proper parameters:
//         * square(x_coordinate_of_center, y_coordinate_center, sides_half_length)
//         */
//        blankCanvas.square(0.5,  0.5, 0.4);
//
//        /*
//         * To change the color of the pen, setPenColor is used with three numbers that are in [0, 255] range.
//         * All the colors can be made as a combination of red, green and blue.
//         * The parameters show the richness of red, green and blue of a color.
//         * For example setPenColor(new Color(0, 0, 0) sets the color of the pen
//         * to black and setPenColor(new Color(255, 255, 255) sets the color to
//         * white.
//         */
//        blankCanvas.setPenColor(new Color(150, 150, 150));
//
//        /* To draw a line, line function is called
//         * with proper parameters:
//         * line( length)
//         */
//        blankCanvas.line(0.0, 0.5, 1, 0.5);
//
//
//    }




    /**
     * This method draws a number of circles that share the same center, as long as the radius is positive.
     * @param x is the x-coordinate of the circles
     * @param y is the y-coordinate of the circles.
     * @param radius is the radius of a circle.
     * 		The function is called with the radius that is cut to two decimal points.
     * 		For example 0.39876543210 must be cut to 0.39
     * @param diff is the difference between the radius of a circle and its immediate inner circle.
     * @param page is the canvas on which the circles are drawn.
     * @param radiusList is an accumulated list of the radius of the circles that were drawn.
     * @return a list of all the circles' radius that were drawn.
     */

	
	/*
	 * this is a method that cuts off a number to two decimal places without rounding up the number.
	 */
    public static double twoDecimalPlace(double num){

        double numRounded = Math.floor(num*100)/100.0;
        return numRounded;
    }

    public static String nestedCircle (double x, double y, double radius, double diff,  Draw page, String radiusList) {
        // your code goes here. Task 1

        radius = twoDecimalPlace(radius);//converting the radius to 2 decimal places

//      recursive step
        if (radius<0){
            return "[" + radiusList + "]";
        }
        else {
            if(radius == 0.0) {//i made if for radius == 0 so that after the last number there's no ", "
            	radiusList = radiusList + radius;//making sure that the last radius makes itself in the radiusList
            }
            else{
            	radiusList = radiusList + radius + ", ";
            }
            page.circle(x, y, radius);//drawing a circle by calling page.circle
            return "" + nestedCircle(x, y, (radius-diff), diff, page, radiusList);//recursive call
        }

    }
    /**
     * This method recursively draws 4 squares, whose center falls on a corner of
     * previously drawn square. The side of the square is half as much as the side of the
     * square that is drawn in previous round.
     * @param x is the x-coordinate of the square
     * @param y is the y-coordinate of the square
     * @param halfLength is half the size of the square's side
     * @param order is the number of the rounds by which a set of squares is drawn
     * @param page is the canvas on which the squares are drawn.
     * @return a list of the center of smallest squares that are drawn..
     * 		The coordinates should be cut to one decimal point. For example:
     * 		 0.39876543210 is cut to 0.3
     */

    public static String squares (double x, double y, double halfLength, int order, Draw page) {
        // your code goes here. Task 2

    	//calculating the end points of a given center
        double yTop = y + halfLength;
        double yBottom = y - halfLength;
        double xRight = x + halfLength;
        double xLeft = x - halfLength;

        if (order == 1){//base case draws the outermost squares and returns its Point
        	page.square(x, y, halfLength);
        	return new Point(x, y).toString();
        }
        

        squares(x, y, halfLength, 1, page);//drawing a square at given center

        
        //returns the centers of the outermost squares
        return squares(xLeft, yBottom, (halfLength)/2, order-1, page) + squares(xLeft, yTop, (halfLength)/2, order-1, page) + squares(xRight, yBottom, (halfLength)/2, order-1, page) + squares(xRight, yTop, (halfLength)/2, order-1, page);
        

        

    }

    /**
     * This method specifies which coordinates should be drilled. It also draw the
     * horizontal line of each triangle. No duplicate point should be added to the output.
     * @param p1 is one of the vertex of the triangle
     * @param p2 is the second vertex of the triangle
     * @param p3 is the third vertex of the triangle
     * @param order is the number of times a nested triangle should be drawn.
     * 			<code> order >= 0 </code>, however if it is zero, nothing should be drawn
     * @param page is the canvas on which this method draws.
     * @param array is the list of the points that should be drilled. To add to this list point.toString() must be added.
     * @return an array that contains all the points that should be drilled. this method should not have any duplicate points in it.
     */

    public static ArrayList<String> drillPoints(Point p1, Point p2, Point p3, int order, Draw page, ArrayList<String> array) {
        // your code goes here. Task 3
    	
    	//calculating midpoints of every side of a triangle
        Point midp12 = Point.midpoint(p1, p2);
        Point midp13 = Point.midpoint(p1, p3);
        Point midp32 = Point.midpoint(p3, p2);
        
        
        //special case for order == 0, returns an array which is empty by default. I tried returning null, but as the tester uses array.contains(), it gave an error saying that array.contains() doesn't work on null objects 
        if (order == 0) {
        	return array;
        }
        //making sure the points gets into ArrayList array and they are not repeated
        if (!array.contains(p1.toString())){
        	array.add(p1.toString());
	    }
	    if (!array.contains(p2.toString())){
	        array.add(p2.toString());
	    }
	    if (!array.contains(p3.toString())){
	        array.add(p3.toString());
	    }
        
	    
	    //case for order ==1, which will be the last recursive call for every sub-triangle 
        if(order == 1){
        	lineDraw(p1, p2, p3, page);//calls a method called lineDraw(which I made), which draws a horizontal line
        	return array;
        }

        
        //recursive call
        drillPoints(p1, midp12, midp13, order-1, page, array);
        drillPoints(p2, midp32, midp12, order-1, page, array);
        drillPoints(p3, midp13, midp32, order-1, page, array);
        
        return array;// returns array which contains all the points which should be drilled

    }
    
    
    // lineDraw method draws a horizontal lines connecting appropriate points
    public static void lineDraw(Point p1, Point p2, Point p3, Draw page){
        if(p1.y == p2.y){//checking if the y coordinates of two points are equal to know that these points are the one that should be connected to make a horizontal line
            page.line(p1.x, p1.y, p2.x, p2.y);
        }
        else if(p1.y == p3.y){//checking if the y coordinates of two points are equal to know that these points are the one that should be connected to make a horizontal line
            page.line(p1.x, p1.y, p3.x, p3.y);
        }
        else if(p3.y == p2.y){//checking if the y coordinates of two points are equal to know that these points are the one that should be connected to make a horizontal line
            page.line(p3.x, p3.y, p2.x, p2.y);
        }
    }

}
/**
 * This class creates a point.
 *
 */
class Point {
    double x;
    double y;

    
    //method for cutting off a number to 2 decimal places without rounding off
    public static double twoDecimalPlace(double num){
        double numRounded = Math.floor(num*100)/100.0;
        return numRounded;
    }
    
    //,method for cutting off a number to 1 decimal place without rounding off
    public static double oneDecimalPlace(double num){
        double numRounded = Math.floor(num*10)/10.0;
        return numRounded;
    }
    /**
     * This is the constructor that builds a point
     * @param x is the x-coordinate of the point
     * @param y is the y-coordinate of the point
     */
    public Point(double x, double y) {
        // your code goes here. Task 0
        this.x = x;//sets value of x to inst var x
        this.y = y;//sets value of y to inst var y
    }
    /**
     * This method returns the mid point of a line,
     * whose two ends are given.
     * @param p1 is one end of the line
     * @param p2 is the other end of the line
     * @return the mid point of the line. Both the
     * coordinates are cut to two decimal points.
     * e.g. 0.37654 is cut to 0.37
     */
    public static Point midpoint(Point p1, Point p2) {
        // your code goes here. Task 0
        double x = ((p1.x + p2.x)/2);
        x = twoDecimalPlace(x);//making sure the number is cut to 2 decimals
        double y = (p1.y + p2.y)/2;
        y = twoDecimalPlace(y);//making sure the number is cut to 2 decimal places
        return new Point(x, y);
    }
    @Override
    /**
     * This method returns the coordinate of this object as a string.
     */
    public String toString() {
        return "["+ oneDecimalPlace(this.x) + ", "+ oneDecimalPlace(this.y) +"]";//called oneDecimalPlace to cut off the numbers to 1 decimal place as Point.toString is used only in squares and drillPoints both of which require an output of 1 decimal place
    }

}
