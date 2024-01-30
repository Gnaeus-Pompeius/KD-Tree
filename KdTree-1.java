/*************************************************************************
 *************************************************************************/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Stack;

import java.util.Arrays;

public class KdTree {

    public class Node {
        private Point2D p;
        private Node left = null;
        private Node right = null;
        private boolean horizontal;

        private Node(double x, double y, boolean horiz) {
            p = new Point2D(x, y);
            horizontal = horiz;
        }
    }

    private Node root = null;
    private int size = 0;

    // construct an empty set of points
    public KdTree() {

    }

    // is the set empty?
    public boolean isEmpty() {
        if (root == null) {
            return false;
        }
        return true;
    }

    // number of points in the set
    public int size() {
        return size;
    }

    // add the point p to the set (if it is not already in the set)
    public void insert(Point2D p) {
        root = recInsert(root, p, true);
    }

    private Node recInsert(Node curr, Point2D p, boolean horizontal) {
        if (curr == null) {
            size++;
            return new Node(p.x(), p.y(), horizontal);
        }
        if (curr.p.equals(p)) {
            return curr;
        }

        boolean comparison;
        if (horizontal) {
            comparison = curr.p.x() > p.x();
        }
        else {
            comparison = curr.p.y() > p.y();
        }

        // left
        if (comparison) {
            curr.left = recInsert(curr.left, p, !horizontal);
        }

        // right
        else {
            curr.right = recInsert(curr.right, p, !horizontal);
        }
        return curr;
    }

    // does the set contain the point p?
    public boolean contains(Point2D p) {
        return recContains(root, p);
    }

    private boolean recContains(Node curr, Point2D p) {
        if (curr == null) {
            return false;
        }
        if (curr.p.equals(p)) {
            return true;
        }

        if (curr.horizontal) {
            if (p.x() < curr.p.x()) {
                return recContains(curr.left, p);
            }
            else {
                return recContains(curr.right, p);
            }

        }
        else {
            if (p.y() < curr.p.y()) {
                return recContains(curr.left, p);
            }
            else {
                return recContains(curr.right, p);
            }
        }
    }

    // draw all of the points to standard draw
    public void draw() {
        // draw all points to standard draw
    }

    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        Queue<Point2D> queue = new Queue<Point2D>();
        return recRange(root, queue, rect);
    }


    private Queue<Point2D> recRange(Node n, Queue<Point2D> queue, RectHV rect) {
        if (n == null) {
            return queue;
        }

        if (rect.contains(n.p)) {
            queue.enqueue(n.p);
        }

        if ((rect.xmax() < n.p.x() && n.p.x() < rect.xmin())
                && (rect.ymax() < n.p.y() && n.p.y() < rect.ymin())) {
            return queue;
        }


        queue = recRange(n.left, queue, rect);
        queue = recRange(n.right, queue, rect);

        return queue;
    }


    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(Point2D p) {
        Stack<Point2D> pointStack = new Stack<Point2D>();
        Point2D highPoint = new Point2D(2.0, 2.);
        pointStack.push(highPoint);
        pointStack = recNearest(root, pointStack, p);
        return pointStack.pop();
    }

    private Stack<Point2D> recNearest(Node n, Stack<Point2D> stack, Point2D p) {
        if (n == null) {
            return stack;
        }
        Point2D compP = stack.pop();
        if (p.distanceSquaredTo(n.p) < p.distanceSquaredTo(compP)) {
            stack.push(n.p);
        }
        else {
            stack.push(compP);
        }

        stack = recNearest(n.left, stack, p);
        stack = recNearest(n.right, stack, p);

        return stack;
    }

    /*******************************************************************************
     * Test client
     ******************************************************************************/
    public static void main(String[] args) {
        In in = new In();
        Out out = new Out();
        int nrOfRecangles = in.readInt();
        int nrOfPointsCont = in.readInt();
        int nrOfPointsNear = in.readInt();
        RectHV[] rectangles = new RectHV[nrOfRecangles];
        Point2D[] pointsCont = new Point2D[nrOfPointsCont];
        Point2D[] pointsNear = new Point2D[nrOfPointsNear];
        for (int i = 0; i < nrOfRecangles; i++) {
            rectangles[i] = new RectHV(in.readDouble(), in.readDouble(),
                                       in.readDouble(), in.readDouble());
        }
        for (int i = 0; i < nrOfPointsCont; i++) {
            pointsCont[i] = new Point2D(in.readDouble(), in.readDouble());
        }
        for (int i = 0; i < nrOfPointsNear; i++) {
            pointsNear[i] = new Point2D(in.readDouble(), in.readDouble());
        }
        KdTree set = new KdTree();
        for (int i = 0; !in.isEmpty(); i++) {
            double x = in.readDouble(), y = in.readDouble();
            set.insert(new Point2D(x, y));
        }
        for (int i = 0; i < nrOfRecangles; i++) {
            // Query on rectangle i, sort the result, and print
            Iterable<Point2D> ptset = set.range(rectangles[i]);
            int ptcount = 0;
            for (Point2D p : ptset)
                ptcount++;
            Point2D[] ptarr = new Point2D[ptcount];
            int j = 0;
            for (Point2D p : ptset) {
                ptarr[j] = p;
                j++;
            }
            Arrays.sort(ptarr);
            out.println("Inside rectangle " + (i + 1) + ":");
            for (j = 0; j < ptcount; j++)
                out.println(ptarr[j]);
        }
        out.println("Contain test:");
        for (int i = 0; i < nrOfPointsCont; i++) {
            out.println((i + 1) + ": " + set.contains(pointsCont[i]));
        }

        out.println("Nearest test:");
        for (int i = 0; i < nrOfPointsNear; i++) {
            out.println((i + 1) + ": " + set.nearest(pointsNear[i]));
        }

        out.println();
    }
}
