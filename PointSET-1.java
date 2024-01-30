/****************************************************************************
 *  Compilation:  javac PointSET.java
 *  Execution:
 *  Dependencies:
 *  Date: 13.október 2022
 *
 *  Data structure for maintaining a set of 2-D points,
 *    including rectangle and nearest-neighbor queries
 *
 *************************************************************************/

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Stack;

import java.util.TreeSet;

public class PointSET {
    private TreeSet<Point2D> set;

    // construct an empty set of points
    public PointSET() {
        set = new TreeSet<Point2D>();

    }

    // is the set empty?
    public boolean isEmpty() {
        return set.isEmpty();
    }

    // number of points in the set
    public int size() {
        return set.size();
    }

    // add the point p to the set (if it is not already in the set)
    public void insert(Point2D p) {
        set.add(p);
    }

    // does the set contain the point p?
    public boolean contains(Point2D p) {
        return set.contains(p);
    }

    // draw all of the points to standard draw
    public void draw() {
        for (Point2D p : set) {
            p.draw();
        }
    }

    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        Stack<Point2D> pointstack = new Stack<Point2D>();
        for (Point2D p : set) {
            if (rect.contains(p)) {
                // add to some data structure
                pointstack.push(p);
            }
        }
        return pointstack;
    }

    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(Point2D p) {
        double min = Double.POSITIVE_INFINITY;
        Point2D nearest = null;
        for (Point2D q : set) {
            if (p.distanceSquaredTo(q) < min) {
                min = p.distanceSquaredTo(q);
                nearest = q;
            }
        }
        return nearest;
    }

    public static void main(String[] args) {
    }

}
