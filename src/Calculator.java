import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) throws IOException, NumberFormatException, IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        String example = scanner.nextLine();

        boolean b1 = testArab(example);
        boolean b2 = testRome(example);
        if (b1 == true) {
            calculationArab(example);
        }
        else if (b2 == true) {
            calculationRome(example);
        }



    }
    public static boolean testArab(String s) {
        Pattern p = Pattern.compile("[0-9]{1,2}\\s[-\\+\\*\\/]\\s[0-9]{1,2}");
        Matcher m = p.matcher(s);
        return m.matches();
    }
    public static boolean testRome(String s) {
        Pattern p = Pattern.compile("[IXV]{1,4}\\s[-\\+\\*\\/]\\s[IVX]{1,4}");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public static void calculationArab(String s) {

        String[] arr1 = s.split("\\s");
        int arr11 = Integer.parseInt(arr1[0]);
        int arr12 = Integer.parseInt(arr1[2]);

        if ((arr11 >10||arr11< 1)||(arr12 >10||arr12< 1))  {  System.out.println("error");   }
        else if(s.contains("+")) {  System.out.println(arr11 + arr12);  }
        else if(s.contains("-"))  { System.out.println(arr11 - arr12);  }
        else if(s.contains("*")) {  System.out.println(arr11 * arr12);  }
        else if(s.contains("/"))  {   System.out.println(arr11 / arr12); }
    }

    public static void calculationRome (String s) {
        String [] arr2 = s.split(" ");
        String arr11 = arr2[0];
        String arr12 = arr2[2];
        int a = Rome.valueOf(arr11).toArab();
        int b = Rome.valueOf(arr12).toArab();
        if(s.contains("+")) {  System.out.println(a + b);  }
        else if(s.contains("-"))  { System.out.println(a - b);  }
        else if(s.contains("*")) {  System.out.println(a * b);  }
        else if(s.contains("/"))  {   System.out.println(a / b); }

    }
}

