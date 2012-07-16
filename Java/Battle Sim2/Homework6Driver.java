public class Homework6Driver
{
public static void main(String[] args)
{
Homework6Input parser = new Homework6Input();
String data = parser.readInput();
Homework6Functions funcs = new Homework6Functions();
funcs.go(data, parser);
}
}
