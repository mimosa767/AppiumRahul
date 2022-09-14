package JavaPractice;

import java.util.ArrayList;

public class CoreJavaBrushUp2 {

    public static void main (String[] args) {

        int[] array2 = {1,2,4,5,6,7,8,9,10,122};

        for (int f : array2) {

            if (f % 2 == 0) {
                System.out.println(f);
                break;
            }
            else{      //else block is optional
                System.out.println(f + " is not multiple of 2");
            }
        }
        ArrayList<String> a = new ArrayList();
        a.add("stephen");
        a.add("Penn");
        a.add("Alexander");
       // a.remove(2);
        System.out.println(a.get(1));
        //create object of the class - object.method
    }
}
