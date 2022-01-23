public class prog4 {
  public static void main(String args[]) {
    System.out.println("hello");


    // Appending with String class
    String DATA1 = "";
    for(int i=0;i<20;i++){

      DATA1 += i;
      System.out.println(DATA1.hashCode());
    }

    String hii ="";
    


    // Appending with StringBuffer class
    StringBuffer DATA2 = new StringBuffer("");
    for(int i=0;i<20;i++){

      DATA2.append(i);
      System.out.println(DATA2.hashCode());
      System.out.println('');


    }



  }
}
