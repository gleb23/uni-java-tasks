package edu.hlibbabii.points26.service;

import edu.hlibbabii.points26.dao.Dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;


/**
 *
 * @author Hlib Babii <hlib.babii at hlibbabii.ua>
 */
public class Logic {
    private int centerX;
    private int centerY;
    
    private int radius1;
    private int radius2;
    private int radius3;
    private int radius4;
    private int radius5;
    
    Collection points = null;
    
    private int circleNum = 0;
    
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }
    
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }
    
    public void setRadius1(int radius1) {
        this.radius1 = radius1;
    }
    
    public void setRadius2(int radius2) {
        this.radius2 = radius2;
    }
    
    public void setRadius3(int radius3) {
        this.radius3 = radius3;
    }
    
    public void setRadius4(int radius4) {
        this.radius4 = radius4;
    }
    
    public void setRadius5(int radius5) {
        this.radius5 = radius5;
    }
    
    private void getPoints() {
        Dao dao = Dao.getInstance();
        points = dao.selectPoints();
    }
    
    private double distanceToCenter(Point point) {
        return Math.sqrt((point.getX()-centerX)*(point.getX()-centerX)
                +(point.getY()-centerY)*(point.getY()-centerY));
    }
    
    /**
     * Returns in which circle the most points lie;
     */
    public Collection<Point> compureCircle() {
        
        getPoints();
        
        Object pointsInCircle[] = new Object[5];
        pointsInCircle[0] = new TreeSet<Point>();
        pointsInCircle[1] = new TreeSet<Point>();
        pointsInCircle[2] = new TreeSet<Point>();
        pointsInCircle[3] = new TreeSet<Point>();
        pointsInCircle[4] = new TreeSet<Point>();
        
        Iterator iterator = points.iterator();
        while(iterator.hasNext()) {
            Point point = (Point) iterator.next();
            if (distanceToCenter(point) <= radius1) {
                ((Collection<Point>)pointsInCircle[0]).add(point);
            } else if (distanceToCenter(point) <= radius2) {
                ((Collection<Point>)pointsInCircle[1]).add(point);
            } else if (distanceToCenter(point) <= radius3) {
                ((Collection<Point>)pointsInCircle[2]).add(point);
            } else if (distanceToCenter(point) <= radius4) {
                ((Collection<Point>)pointsInCircle[3]).add(point);
            } else if (distanceToCenter(point) <= radius5) {
                ((Collection<Point>)pointsInCircle[4]).add(point);
            }
        }
            
        int arrayToReturn = -1;
        int maxSetSize = -1;
        for (int i = 0; i < 5; i++) {
            if (((Collection<Point>)pointsInCircle[i]).size() > maxSetSize) {
                arrayToReturn = i;
                maxSetSize = ((Collection<Point>)pointsInCircle[i]).size();
            }
        }
        
        this.circleNum = arrayToReturn + 1;
        return (Collection<Point>) pointsInCircle[arrayToReturn];   
    }
    
    public int getCircleNum() {
        return this.circleNum;
    }
}
