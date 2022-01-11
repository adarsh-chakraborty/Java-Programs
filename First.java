// Java Day 1
// Tue 11 Jan 
class MyClass1 {
  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}

class MyClass2 {
  public static void main(String[] args) {
    System.out.println("Hello World 2");
  }
}


class Information {
  String name;

  Information(String name){
    this.name = name;
  }
  void printName(){
    System.out.println(this.name);
  }
}

class Driver {
  public static void main(String[] args) {
    Information info = new Information("Adarsh");
    info.printName();
  }
}