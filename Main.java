import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Square kwadrat1 = new Square(5, "red", true);
        Square kwadrat2 = new Square(7, "green", false);
        Square kwadrat3 = new Square(8, "blue", true);
        Square kwadrat4 = new Square(10, "pink", false);
        Square kwadrat5 = new Square(13, "red", true);
        Square kwadrat6 = new Square(2, "darkgreen", false);
        Square kwadrat7 = new Square(3, "gray", true);
        Square kwadrat8 = new Square(14, "black", false);
        Square kwadrat9 = new Square(20, "cyan", true);
        Square kwadrat10 = new Square(4, "magenta", false);


        List<Square> kwadraty = new ArrayList<Square>();
        kwadraty.add(kwadrat1);
        kwadraty.add(kwadrat2);
        kwadraty.add(kwadrat3);
        kwadraty.add(kwadrat4);
        kwadraty.add(kwadrat5);
        kwadraty.add(kwadrat6);
        kwadraty.add(kwadrat7);
        kwadraty.add(kwadrat8);
        kwadraty.add(kwadrat9);
        kwadraty.add(kwadrat10);

        //A
        System.out.println("-----A-----");
        kwadraty.stream()
                .filter(kwadrat -> kwadrat.getSide()*4>kwadrat.getSide()*kwadrat.getSide())
                .forEach(System.out::println);
        System.out.println("------------");

        //B
        System.out.println("-----B-----");
        kwadraty.stream()
                .sorted(Comparator.comparing(Square::getArea))
                .forEach(System.out::println);
        System.out.println("-----------");

        //C
        System.out.println("-----C-----");
        kwadraty.stream()
                .sorted(Comparator.comparing(Square::getObwod).reversed())
                .forEach(System.out::println);
        System.out.println("-----------");

        //D
        System.out.println("-----D-----");
        System.out.println(kwadraty.stream()
                .mapToDouble(Square::getObwod)
                .average());
        System.out.println("-----------");

        //E
        System.out.println("-----E-----");
        System.out.println(kwadraty.stream()
                .mapToInt(kwadrat -> (int) kwadrat.getArea())
                .sum());
        System.out.println("-----------");

        //robienie mapy
        kwadraty.stream()
                .collect(Collectors.toMap(Square::getArea, Square::toString));
    }
}
