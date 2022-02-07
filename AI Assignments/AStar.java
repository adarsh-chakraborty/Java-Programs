import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class AStar {
private final List<Node> open;
private final List<Node> closed;
private final List<Node> path;
private final int[][] maze;
private Node now;
private final int xstart;
private final int ystart;
private int xend, yend;
private final boolean diag;
static class Node implements Comparable {
public Node parent;
public int x, y;
public double g;
public double h;
Node(Node parent, int xpos, int ypos, double g, double h) {
this.parent = parent;
this.x = xpos;
this.y = ypos;
this.g = g;
this.h = h;
}
@Override
public int compareTo(Object o) {
Node that = (Node) o;
return (int)((this.g + this.h) - (that.g + that.h));
}
}
AStar(int[][] maze, int xstart, int ystart, boolean diag) {
this.open = new ArrayList<>();
this.closed = new ArrayList<>();
this.path = new ArrayList<>();
this.maze = maze;
this.now = new Node(null, xstart, ystart, 0, 0);
this.xstart = xstart;
this.ystart = ystart;
this.diag = diag;
}
public List<Node> findPathTo(int xend, int yend) {
this.xend = xend;
this.yend = yend;
this.closed.add(this.now);
addNeigborsToOpenList();
while (this.now.x != this.xend || this.now.y != this.yend) {
if (this.open.isEmpty())
{
return null;
}
this.now = this.open.get(0);
this.open.remove(0);
this.closed.add(this.now);
addNeigborsToOpenList();
}
this.path.add(0, this.now);
while (this.now.x != this.xstart || this.now.y != this.ystart) {
this.now = this.now.parent;
this.path.add(0, this.now);
}
return this.path;
}
/*
** Looks in a given List<> for a node
**
** @return (bool) NeightborInListFound
*/
private static boolean findNeighborInList(List<Node> array, Node node) {
return array.stream().anyMatch((n) -> (n.x == node.x && n.y == node.y));
}
/*
** Calulate distance between this.now and xend/yend
**
** @return (int) distance
*/
private double distance(int dx, int dy) {
if (this.diag) {
return Math.hypot(this.now.x + dx - this.xend, this.now.y + dy - this.yend);
} else {
return Math.abs(this.now.x + dx - this.xend) + Math.abs(this.now.y + dy - this.yend);

}
}
private void addNeigborsToOpenList() {
Node node;
for (int x = -1; x <= 1; x++) {
for (int y = -1; y <= 1; y++) {
if (!this.diag && x != 0 && y != 0) {
continue;
}
node = new Node(this.now, this.now.x + x, this.now.y + y, this.now.g, this.distance(x, y));
if ((x != 0 || y != 0)
&& this.now.x + x >= 0 && this.now.x + x < this.maze[0].length
&& this.now.y + y >= 0 && this.now.y + y < this.maze.length
&& this.maze[this.now.y + y][this.now.x + x] != -1
&& !findNeighborInList(this.open, node) && !findNeighborInList(this.closed, node)) {
node.g = node.parent.g + 1.;
node.g += maze[this.now.y + y][this.now.x + x];
this.open.add(node);
}
}
}
Collections.sort(this.open);
}
public static void main(String[] args) {
int[][] maze = {
{ 0, 0, 0, 0, 0, 0, 0, 0},
{ 0, 0, 0, 0, 0, 0, 0, 0},
{ 0, 0, 0,100,100,100, 0, 0},
{ 0, 0, 0, 0, 0,100, 0, 0},
{ 0, 0,100, 0, 0,100, 0, 0},
{ 0, 0,100, 0, 0,100, 0, 0},
{ 0, 0,100,100,100,100, 0, 0},
{ 0, 0, 0, 0, 0, 0, 0, 0},
};
AStar as = new AStar(maze, 0, 0, true);
List<Node> path = as.findPathTo(7, 7);
if (path != null) {
path.forEach((n) -> {
System.out.print("[" + n.x + ", " + n.y + "] ");
maze[n.y][n.x] = -1;
});
System.out.printf("\nTotal cost: %.02f\n", path.get(path.size() - 1).g);
for (int[] maze_row : maze) {
for (int maze_entry : maze_row) {
switch (maze_entry) {
case 0:
System.out.print("_");
break;
case -1:
System.out.print("*");
break;
default:
System.out.print("#");
}
}
System.out.println();
}
}
}
}