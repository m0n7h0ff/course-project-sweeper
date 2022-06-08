package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges
{
    private static Coord size;//хранит размеры окна
    private static ArrayList<Coord> allCoords;//для перебора всех координат без for
    private static Random random = new Random();

    public static void setSize(Coord _size)
    {
        size=_size;
        allCoords=new ArrayList<Coord>();//для заполнения координат поля
        for (int y=0; y<size.y; y++)//заполнение всех координат
            for(int x=0;x<size.x;x++)
            {
                allCoords.add(new Coord(x,y));
            }
    }
    public static Coord getSize()
    {
        return size;
    }

    public static ArrayList<Coord> getAllCoords()
    {
        return allCoords;
    }
    public static boolean inRange(Coord coord)//проверка координаты на выход за пределы границ
    {
        return coord.x>=0 && coord.x<size.x&&
                coord.y>=0 && coord.y< size.y;
    }

    //генерация случайных координат для бомб
    static Coord getRandomCoord()
    {
        return new Coord(random.nextInt(size.x),
                random.nextInt(size.y));
    }

    //возвращает 1 вокруг бомб
    public static ArrayList<Coord> getCoordsAround(Coord coord)
    {
        Coord around;
        ArrayList<Coord> list= new ArrayList<Coord>();//СПИСОК КООРДИНАТ ВОКРУГ
        for (int x = coord.x-1; x<= coord.x+1;x++)
            for (int y = coord.y-1; y<= coord.y+1;y++)
                if(inRange(around=new Coord(x,y)))//ПРОВЕРКА ГРАНИЦ
                    if (!around.equals(coord))
                        list.add(around);

        return list;
    }

}
