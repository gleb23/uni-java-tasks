package edu.hlibbabii.points26.service;

/**
 *
 * @author Hlib Babii <hlib.babii at hlibbabii.ua>
 */
public class Point implements Comparable{
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Object o) {
        if (x != ((Point)o).getX()) {
            return x - ((Point)o).getX();
        } else {
            return (y - ((Point)o).getY());
        }
    }
}
