/**********************************************************************
 *  readme.txt template
 *  Kd-tree
**********************************************************************/

Name: Smári
Login: Smarib20
Section instructor:

Partner name: Axel
Partner login: Axele21
Partner section instructor:

/**********************************************************************
 *  Describe the Node data type you used to implement the
 *  2d-tree data structure.
 **********************************************************************/

It contains a point (with x,y coordinates), a node has pointers to its left and right children
It holds a boolean value of if it is horizontal or not to determine if x values is compared or y values of each inserted node.

/**********************************************************************
 *  Describe your method for range search in a kd-tree.
 **********************************************************************/
We recursively went through the whole tree but if we landed on a node where the x and y coordinates are
range xmin - xmax and ymin-ymax then the children of that node are not checked.

For each Node that is in the rectangle we added to a queue and then return the queue.

/**********************************************************************
 *  Describe your method for nearest neighbor search in a kd-tree.
 **********************************************************************/

We checked every node and found the point nearest to the point.

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
 *  Give the expected running time in seconds (using tilde notation)
 *  to build a 2d-tree on N random points in the unit square.
 *  Use empirical evidence by creating a table of different values of N
 *  and the timing results. (Do not count the time to generate the N
 *  points or to read them in from standard input.)
 **********************************************************************/


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

/**********************************************************************
 *  Have you taken (part of) this course before:
 **********************************************************************/

No

/**********************************************************************
 *  Known bugs / limitations.
 **********************************************************************/

None

/**********************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and d�mat�mar, but do
 *  include any help from people (including course staff,
 *  classmates, and friends) and attribute them by name.
 **********************************************************************/


/**********************************************************************
 *  Describe any serious problems you encountered.
 **********************************************************************/


/**********************************************************************
 *  If you worked with partners, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **********************************************************************/



Peer programming, met and solved each problem together.


/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **********************************************************************/
