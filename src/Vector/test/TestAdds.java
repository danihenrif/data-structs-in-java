package Vector.test;

import Vector.domain.Teacher;
import Vector.domain.Vector;

public class TestAdds {
    public static void main(String[] args) {
        Vector vector = new Vector();

        Teacher t1 = new Teacher("Marcos", 40);
        Teacher t2 = new Teacher("Josh", 41);
        Teacher t3 = new Teacher("Joshn", 71);
        Teacher t4 = new Teacher("Daniel", 51);
        Teacher t5 = new Teacher("ERROR", 1);


        vector.add(t1);
        vector.add(t2);
        System.out.println(vector);
        vector.add(t3,0);
        System.out.println(vector);
        vector.add(t4,2);
        System.out.println(vector);
        vector.add(t5,3);
        System.out.println(vector);
    }

}
