public class Student {
     String name;
     int roll;

     Student(){}

     @Override
     public String toString() {
          return "Student{" +
                  "name='" + name + '\'' +
                  ", roll=" + roll +
                  '}';
     }

     Student(int roll, String name){
          this.roll = roll;
          this.name = name;


     }
}
