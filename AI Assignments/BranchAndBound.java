import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.management.Query;

public class BranchAndBound {
private int[] weight;
private int[] value;
private int sumV;

public static void main(String[] args) {
BranchAndBound bp = new BranchAndBound();
int[] w = {1,2,5,6,7};
int[] c = {1,6,18,22,28};
int sumV = 11;
bp.weight = w;
bp.value = c;
bp.sumV = sumV;
int maxValue;
maxValue = bp.getMaxValueWithFifo();
System.out.println(maxValue);
maxValue = bp.getMaxValueWithPriority();
System.out.println(maxValue);
}
private int getMaxValueWithPriority() {
int maxValue = 0;
PriorityQueue<status> pq = new PriorityQueue<status>();
pq.add(new status(0,0,-1));
status st;
int indextemp;
while(pq.size()>0){
st = pq.remove();
indextemp = st.index +1;
if(indextemp >= weight.length){
continue;
}
if((st.currentW + weight[indextemp]) <= sumV){
pq.add(new status(st.currentW + weight[indextemp],st.currenC +
value[indextemp],indextemp));
if(maxValue <st.currenC + value[indextemp]){
maxValue = st.currenC + value[indextemp];
}
}
pq.add(new status(st.currentW, st.currenC, indextemp));
}
return maxValue;
}
private int getMaxValueWithFifo() {
int maxValue = 0;
LinkedList<status> al = new LinkedList<status>();
al.add(new status(0,0,-1));
status st;
int indextemp;
while(al.size()>0){
st = al.remove();
indextemp = st.index +1;
if(indextemp >= weight.length){
continue;
}
if((st.currentW + weight[indextemp]) <= sumV){
al.add(new status(st.currentW + weight[indextemp],st.currenC +
value[indextemp],indextemp));
if(maxValue <st.currenC + value[indextemp]){
maxValue = st.currenC + value[indextemp];
}
}
al.add(new status(st.currentW, st.currenC, indextemp));
}
return maxValue;
}
//The value and weight of the total items stored
static class status implements Comparable<status>{
//Current weight and value;
private int currentW;
private int currenC;
private int index;
public status(int currentW,int currenC,int index){
this.currentW = currentW;
this.currenC = currenC;
this.index = index;
}
@Override
public int compareTo(status o) {
if(this.currentW> o.currentW){
return 1;
}
if(this.currentW <o.currentW){
return -1;
}
return 0;
}
}
}