package JavaPractice;

public class CoreJavaBrushUp3 {
    public static void main(String[] args) {

        //string is an object
        String s = "Rahul Shetty Academy"; //this is how you declare a string as a literal
        String s1 = "Rahul Shetty Academy"; //if the text is the same it will point to the same object
        String s2 = new String("Welcome");
        String s3 = new String("Welcome"); //this is how you declare a string in memory, objects are created each time even when they are the same
        String[] splittedString = s.split(" ");
        System.out.println(splittedString[0]);
        System.out.println(splittedString[1]);
        System.out.println(splittedString[2]);
//        for(int n = 0; n<s.length(); n++) {     //This for loops iterates through the array and prints all the characters
//
//            System.out.println(s.charAt(n));
//        }

        for (int m = s.length() - 1; m>=0; m--) {  //this prints the array in reverse order
            System.out.println(s.charAt(m));
        }
    }
}
