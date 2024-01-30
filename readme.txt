/**********************************************************************
 *  Kd-tree
**********************************************************************/


/**********************************************************************
 *  Describe the Node data type you used to implement the
 *  2d-tree data structure.
 **********************************************************************/

It contains a point (with x,y coordinates), a node has pointers to its left and right children
It holds a boolean value of if it is horizontal or not to determine if x values is compared or y values of each inserted node.

/**********************************************************************
 *  Describe your method for range search in a kd-tree.
 **********************************************************************/
recursively go through the whole tree but if we landed on a node where the x and y coordinates are
range xmin - xmax and ymin-ymax then the children of that node are not checked.

For each Node that is in the rectangle we added to a queue and then return the queue.

/**********************************************************************
 *  Describe your method for nearest neighbor search in a kd-tree.
 **********************************************************************/

check every node and found the point nearest to the point.

/**********************************************************************
 *  Give the total memory usage in bytes (using tilde notation and
 *  the standard 64-bit memory cost model) of your 2d-tree data
 *  structure as a function of the number of points N. Justify your
 *  answer below.
 *
 *  Include the memory for all referenced objects (deep memory),
 *  including memory for the nodes, points, and rectangles.
 **********************************************************************/

bytes per Point2D: 32 bytes

bytes per RectHV: 64 bytes

bytes per KdTree of N points (using tilde notation):   ~ 32N bytes
[include the memory for any referenced Node, Point2D and RectHV objects]


/**********************************************************************
 *  How many nearest neighbor calculations can your brute-force
 *  implementation perform per second for input100K.txt (100,000 points)
 *  and input1M.txt (1 million points), where the query points are
 *  random points in the unit square? Explain how you determined the
 *  operations per second. (Do not count the time to read in the points
 *  or to build the 2d-tree.)
 *
 *  Repeat the question but with the 2d-tree implementation.
 **********************************************************************/

                     calls to nearest() per second
                     brute force           2d-tree
input100K.txt        874                   558,8
input1M.txt

Brute: 114.314 for 100k point
100000/114.314 = 874 per second

2d-Tree: 178.964 for 100k points
100000/178.964 = 558,8 per second
