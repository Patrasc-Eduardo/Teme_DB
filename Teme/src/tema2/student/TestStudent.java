package tema2.student;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class TestStudent {
    public static void main(String[] args) {
        HashMap<Integer, TreeSet<Student>> gradesMaps = new HashMap<>();

        Student s1 = new Student("Gigel", 8.73);
        Student s2 = new Student("Ana", 8.43);
        Student s3 = new Student("Ana", 8.23);
        Student s4 = new Student("Gigel", 3.33);
        Student s5 = new Student("Gigel", 5.50);

        // generate a stream 1, 2, 3......, 10 and put the numbers as keys in the map
        IntStream.range(0, 11).forEach(i -> gradesMaps.put(i, new TreeSet<>()));

        gradesMaps.get((int) Math.round(s1.getGrade())).add(s1);
        gradesMaps.get((int)Math.round(s2.getGrade())).add(s2);
        gradesMaps.get((int)Math.round(s3.getGrade())).add(s3);
        gradesMaps.get((int)Math.round(s4.getGrade())).add(s4);

        System.out.println(gradesMaps);
    }
}
