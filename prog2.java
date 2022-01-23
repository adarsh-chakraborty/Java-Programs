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
    Information info1 = new Information("Adarsh 😛");
    info1 = new Information("😎😎😎😎");
    Information info2 = new Information("Adarsh 😀");
    info2 = new Information("😈😈😈😈");
  }
}