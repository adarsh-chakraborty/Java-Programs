// String : Immutable
// StringBuffer : Mutable
// StringBuilder : Mutable


// Object class; Base Class of all Objects.

class Prog {
  public static void main(String[] args) {
    String str = "Hello";
    String str2 = new String("Hello");
    StringBuilder str22 = new StringBuilder("Hello");
    String str3 = "Hello";

    System.out.println(System.identityHashCode(str) + " | " + System.identityHashCode(str2) + " | " + System.identityHashCode(str3));
    System.out.println("str: " + str.hashCode());
    str = "Hello";
    System.out.println("str: " + str.hashCode());
    System.out.println("str2: " + str2.hashCode());
    System.out.println("str3: " + str3.hashCode());
    System.out.println(System.identityHashCode(str22) + " " + str22.hashCode());
  }
}
