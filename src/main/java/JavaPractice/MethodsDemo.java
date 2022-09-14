package JavaPractice;

public class MethodsDemo {

    public static void main(String[] args) {
        MethodsDemo d = new MethodsDemo();
        d.getData();
        String name = d.getData();
        System.out.println(name);
        MethodsDemo2 d1 = new MethodsDemo2();
        d1.getData();
        getData2();

    }
    //any time code can be used, you can write a method to call that code as a function
    //write methods outside the main block

    public String getData(){

        System.out.println("hello world from get data ");
        return  "stephen penn";
    }

    public static String getData2(){      //static moves method to the class level and no need to create an object to access it

        System.out.println("hello world from get data 2");
        return  "stephen penn";
    }

    public void getmoreData() {
        System.out.println("This method doesn't return anything");


    }


}
