package functions;

import java.io.*;

// класс описывает одну точку табулированной функции
public class FunctionPoint implements Serializable {
    private double x;
    private double y;
    private static final double EPS = 1e-9;

    // конструктор с координатами
    public FunctionPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // конструктор копирования
    public FunctionPoint(FunctionPoint point) {
        this.x = point.x;
        this.y = point.y;
    }

    // точка (0, 0) по умолчанию
    public FunctionPoint() {
        x = 0;
        y = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof FunctionPoint)) {
          return false;
      }
      FunctionPoint other = (FunctionPoint) o;
      if (Math.abs(this.x - other.x) < EPS && Math.abs(this.y - other.y) < EPS) {
          return true;
      }
      else {
          return false;
      }
    }

    @Override
    public int hashCode() {
        long bitsX = Double.doubleToLongBits(x);
        int lowerX = (int)(bitsX & 0xFFFFFFFFL);
        int upperX = (int)(bitsX >>> 32);
        int hashX = lowerX ^ upperX;
        long bitsY = Double.doubleToLongBits(y);
        int lowerY = (int)(bitsY & 0xFFFFFFFFL);
        int upperY = (int)(bitsY >>> 32);
        int hashY = lowerY ^ upperY;
        int finalHash = hashX ^ hashY;
        return finalHash;
    }

    @Override
    public Object clone() {
        FunctionPoint clonePoint = new FunctionPoint(this.x, this.y);
        return clonePoint;
    }
}