

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Astars {
private int a[][]=new int[4][3];
private int b[][]=new int[4][3];
private int Expnode[][]=new int[4][3];
private int l=0;
private int parent[][]=new int[4][3];
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
List<int[][]> l1=new ArrayList();
List<int[][]> l2=new ArrayList();
private int row=0;
private int col=0;
private int prow=-1;
private int pcol=-1;
private int temp=0;
private int depth=0;
private int t=0;
private int pathcost=0;
private int StatesEnqued=1;
public void getState()throws Exception
{
System.out.println("\n Enter the initial State");
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
a[i][j]=Integer.parseInt(br.readLine());
}
}
a[3][1]=depth;
System.out.println("\n Enter the final State");
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
b[i][j]=Integer.parseInt(br.readLine());
}
}
}
public void display()
{
System.out.println("\n The initial state is");
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
System.out.print(" "+a[i][j]);
}
System.out.println();
}
System.out.println("\n==============================================================================");
System.out.println("\n The Final State");
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
System.out.print(" "+b[i][j]);
}
System.out.println();
}
System.out.println("\n==============================================================================");
}
public void displayState(int a[][])
{
System.out.println("\n==============================================================================");
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
System.out.print(" "+a[i][j]);
}
System.out.println("");
}
System.out.println("\n==============================================================================");
}
int getMin(){
int min = l1.get(0)[3][0];
int index = 0;
for(int i=1;i<l1.size();i++)
{
if(l1.get(i)[3][0]<min){
min = l1.get(i)[3][0];
index =i;
}
}
System.out.print("min cost selected"+min);
return index;
}
public String TreeSearch()
{
l1.add(a);
while(true)
{
if(l1.isEmpty()==false)
{
Expnode=l1.remove(getMin());
displayState(Expnode);
}
else
{
return "Fail";
}
t=0;
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
if(Expnode[i][j]!=b[i][j])
{
t=1;
}
}
}
if(t!=1)
{
System.out.println("The path cost is"+Expnode[3][1]);
System.out.println("The Total Number of states Explored"+StatesEnqued);
return "success";
}
else
{
expand(Expnode,Expnode[3][1]+1);
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
parent[i][j]=Expnode[i][j];
}
}
}
}
}
public void expand(int k[][],int depth)
{
findSuccessor(k,depth);
prow=row;
pcol=col;
}
public void findSuccessor(int orgnode[][],int depth)
{
findspace(orgnode);
if((row-1>=0 && prow!=row-1)|| (row-1>=0 && prow==-1))
{
int n[][]=new int[4][3];
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
n[i][j]=orgnode[i][j];
}
}
swap(n,row-1,col,depth);
}
if((col+1<=2 && pcol!=col+1) || (col+1<=2 && pcol==-1))
{
int n[][]=new int[4][3];
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
n[i][j]=orgnode[i][j];
}
}
swap(n,row,col+1,depth);
}
if((row+1<=2 && prow!=row+1) || (row+1)<=2 && prow==-1)
{
int n[][]=new int[4][3];
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
n[i][j]=orgnode[i][j];
}
}
swap(n,row+1,col,depth);
}
if((col-1>=0 && pcol!=col-1) || (col-1)>=0 && pcol==-1)
{
int n[][]=new int[4][3];
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
n[i][j]=orgnode[i][j];
}
}
swap(n,row,col-1,depth);
}
}
public void swap(int listnode[][],int j,int k,int depth)
{
int count=0;
int cost=0;
int temp=listnode[j][k];
int s = 1;
//int depth=0;
listnode[j][k]=listnode[row][col];
listnode[row][col]=temp;
listnode[3][1]=depth;
for(int i=0;i<3;i++)
{
for(int p=0;p<3;p++)
{
if(listnode[i][p]!=b[i][p])
{
count++;
}
}
}
StatesEnqued++;
cost=listnode[3][1]+count;
System.out.print("costs is: "+cost+" ");
listnode[3][0]=cost;
l1.add(listnode);
}
public void findspace(int orgnode[][])
{
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
if(orgnode[i][j]==0)
{
row=i;
col=j;
break;
}
}
}
}
}