package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/6/10.
 */
public class MaxPointsonaLine {
    class Line implements Comparable<Line>{
        private int gcd(int m, int n){
            m = Math.abs(m);
            n = Math.abs(n);

            if(m == 0) {
                if(n == 0)
                    return 1;
                else
                    return n;
            }
            else if(n == 0)
                return m;

            if(m < n){
                int t=m;m=n;n=t;
            }
            int t = 0;
            while((t=m % n) > 0){
                m=n;
                n=t;
            }
            return n;
        }

        public int a, b, c;//ax+by+c=0
        public int count, time;
        public Line(Point a, Point b, int count){
            this.a = (b.y - a.y);
            this.b = (a.x - b.x);
            this.c = -(this.a * a.x + this.b * a.y);
            if(this.a == 0){
                if(this.b < 0){
                    this.b = -this.b;
                    this.c = -this.c;
                }
                else if(this.b == 0) {
                    //throw new Exception("duplicate points");
                }
                int g = gcd(this.b, this.c);
                this.b /= g;
                this.c /= g;
            }
            else{
                if(this.a < 0){
                    this.a = -this.a;
                    this.b = -this.b;
                    this.c = -this.c;
                }

                int g = gcd(this.a, this.b);
                g = gcd(g, this.c);
                this.a /= g;
                this.b /= g;
                this.c /= g;
            }
            this.count = count;
            this.time = 1;
        }

        @Override
        public int compareTo(Line o) {
            if(this.a != o.a)
                return this.a - o.a;
            else{
                if(this.b != o.b)
                    return this.b - o.b;
                else
                    return this.c - o.c;
            }
        }
    }

    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
            return 0;

        ArrayList<Point> points2 = new ArrayList<Point>();
        ArrayList<Integer> counts = new ArrayList<Integer>();
        for(int i = 0; i < points.length; i++){
            Point p = points[i];
            int ptr;
            for(ptr = 0; ptr < points2.size(); ptr++){
                Point p2 = points2.get(ptr);
                if(p2.x > p.x || (p2.x == p.x && p2.y > p.y))
                    continue;
                else
                    break;
            }
            if(ptr == points2.size()){
                points2.add(p);
                counts.add(1);
            }
            else{
                if(p.x == points2.get(ptr).x && p.y == points2.get(ptr).y)
                    counts.set(ptr, counts.get(ptr)+1);
                else{
                    points2.add(ptr, p);
                    counts.add(ptr, 1);
                }
            }
        }

        if(points2.size() == 1)
            return counts.get(0);

        ArrayList<Line> lines = new ArrayList<Line>();
        for(int i = 0; i < points2.size(); i++){
            for(int j = i+1; j < points2.size(); j++) {
                Line l = new Line(points2.get(i), points2.get(j), counts.get(i) + counts.get(j));
                int ptr;
                for (ptr = 0; ptr < lines.size(); ptr++) {
                    if (lines.get(ptr).compareTo(l) < 0)
                        continue;
                    else
                        break;
                }
                if(ptr == lines.size())
                    lines.add(l);
                else{
                    if(lines.get(ptr).compareTo(l) == 0) {
                        lines.get(ptr).count += l.count;
                        lines.get(ptr).time++;
                    }
                    else
                        lines.add(ptr, l);
                }
            }
        }
        int max = 0;
        for(Line l : lines){
            int t = (int) Math.sqrt(l.time * 2);
            if(t*(t-1) < l.time*2)
                t++;

            t = l.count / (t-1);

            if(t >= max)
                max = t;
        }
        return max;
    }

    public static void main(String args[]){
        Point points[] = new Point[3];
        points[0] = new Point(2,2);
        points[1] = new Point(0,0);
        points[2] = new Point(-1,-1);
        //points[3] = new Point(2,2);
        System.out.println(new MaxPointsonaLine().maxPoints(points));
    }
}
