package JavaPractice;

public class CoreJavaBrushUp1 {

    public static void main(String[] args) {
        int number = 5;
        String website = "Rahul Shetty Academy";
        char letter = 'r';
        double decimals2 = 5.99;
        boolean myCard = true;

        System.out.println(number + "is my variable number");

        //Arrays - multiple values
        int[] arrayofIntegers = new int[5]; //variable that hold 5 values, the memory is being assigned
        arrayofIntegers[0] = 1;
        arrayofIntegers[1] = 2;
        arrayofIntegers[2] = 3;
        arrayofIntegers[3] = 4;
        arrayofIntegers[4] = 5;

        int[] arrayofIntegers2 = {1, 2, 3, 4, 5};

        System.out.println(arrayofIntegers[0]);
        System.out.println(arrayofIntegers[1]);
        System.out.println(arrayofIntegers[2]);
        System.out.println(arrayofIntegers[3]);
        System.out.println(arrayofIntegers[4]);

        System.out.println(arrayofIntegers2[0]);
        System.out.println(arrayofIntegers2[1]);
        System.out.println(arrayofIntegers2[2]);
        System.out.println(arrayofIntegers2[3]);
        System.out.println(arrayofIntegers2[4]);

        //for loop
//        for (int s = 0; s < arrayofIntegers.length; s++) {      //this gives size of the array
//
//            System.out.println(arrayofIntegers[s]);
//        }

        for (int i = 0; i<arrayofIntegers2.length; i++) {
                System.out.println(arrayofIntegers2[i]);
        }
        String[] name = {"stephen", "alexander", "penn"};

        for (int j = 0; j<name.length; j++){

            System.out.println(name[j]);
        }

        for(String p : name) {    //enhance for loop condition
            System.out.println(p);
        }
    }
    }