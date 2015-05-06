import java.util.*;

public class TestMoreDataStat {
    public static void main(String[] argv) {
        // Test DataStat
        DataStat d = new DataStat();
        d.add(new Segment(5));
        d.add(new Segment(3));
        System.out.println(d.average());
        // test MoreDataStat
        MoreDataStat md = new MoreDataStat();
        md.add(new Segment(5));
        md.add(new Segment(2));
        md.add(new Segment(3));
        md.add(new Segment(6));
        System.out.println(md.average()); // media di 16
        System.out.println(md.size()); // 6 - 2
        // test iteratore, Measurable < 4
        Iterator<Measurable> lessThan = md.lessThan(4);
        System.out.println(lessThan.next().measure());
        System.out.println(lessThan.next().measure());
        if(!lessThan.hasNext())
            System.out.println("fine");

    }
}
