class Driver {
public static void main(String[] args) {
String regex = "^[0-9]{5,}[^0-9]$";
System.out.println("125988ABCD".matches(regex));
System.out.println("98516".matches(regex));
System.out.println("955b".matches(regex));
System.out.println("123467a".matches(regex));
}
}