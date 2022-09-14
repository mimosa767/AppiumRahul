package JavaPractice;

public class childClassdemo extends parentClassdemo {    //use extends to use inheritance and implements to define an interface

    public void engine() {
        System.out.println("new engine");
    }
    public  void color() {
        System.out.println(color);
    }
        public static void main(String[] args){

        childClassdemo cd = new childClassdemo();
        cd.color();
        cd.brakes();  //you are inheriting brakes from the parent class by using extends key word using inheritance
        }
    }
