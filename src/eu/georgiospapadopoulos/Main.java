package eu.georgiospapadopoulos;

/*
Challenge info:
Write a method called numberToWords with one int parameter named number.
The method needs to print out the passed number using words for the digits.
If the number is negative then print "Invalid Value".

To print the number in words use the following steps:
1. Extract last digit of given number using the remainder operator.
2.Switch the value of digit found above. There are 10 possible values of digits.
    Print the corresponding word for each digit. e.g. print "Zero" if digit is 0.
3. Remove the last digit from the number.
4.Repeat steps 2-4 until the number is 0.

The logic above is correct but the words will be printed in reverse order.
For example if the number is 234 the logic above will produce the output
"Four Three Two" instead of "Two Three Four". To overcome this problem write a second method
called reverse.

The reverse method has one int parameter and returns the reversed number (int).
For example if the number passed is 234 then the reversed number would be 432.
The reverse method should also reverse negative numbers. Use the reverse method in the
numberToWords method then print the words in the correct order.

For the number 100 the reverse number is 001. The logic above for the method
numberToWords will print "One" but that is incorrect, it should print "One Zero Zero".
To solve the problem with leading zeroes write a third method getDigitCount.

The getDigitCount method has one parameter number and returns the count of digits in
that number. If the number is negative then return -1 to indicate an invalid value.
If number has the value of 100 then the method needs to return 3 since the number has
3 digits.
 */
public class Main {
    private static String NEGATIVE_NUMBER_ERROR = "Invalid Value";

    public static void main(String[] args) {

        numberToWords(1000);
        numberToWords(1010);
        numberToWords(123);
        numberToWords(-12);
        System.out.println(reverse(-121));
        System.out.println(reverse(1212));
        System.out.println(reverse(1234));
        System.out.println(reverse(100));
        System.out.println(getDigitCount(0));
        System.out.println(getDigitCount(123));
        System.out.println(getDigitCount(-12));
        System.out.println(getDigitCount(5200));

    }

    /**
     * Receives a number and prints out its digits as words.
     * Calls method reverse to print the words in the correct order.
     * Calls method getDigitCount to solve problems regarding leading zeroes.
     *
     * @param number (int) number to print out as words.
     */
    private static void numberToWords(int number) {
        int countDigits = getDigitCount(number);
        number = reverse(number);
        if (number < 0)
            System.out.println(NEGATIVE_NUMBER_ERROR);

        int currentDigit = 0;


        int i = 0;
        while (number > 0) {
            currentDigit = number % 10;
            number /= 10;
            i++;

            switch (currentDigit) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;

            }

        }

        for (int j = 0; j < countDigits - i; j++) {
            System.out.println("Zero");
        }
    }

    /**
     * Receives a number and returns it's reverse.
     * Accepts negative numbers.
     *
     * @param number (int)
     * @return sum : The reverse of original number.
     */
    private static int reverse(int number) {

        boolean wasNegative = false;
        if (number < 0) {
            wasNegative = true;
            number *= -2;
            number /= 2;
        }
        int currentDigit, sum = 0;
        while (number > 0) {
            currentDigit = number % 10;
            number /= 10;
            sum = (sum * 10) + currentDigit;

        }
        if (wasNegative)
            sum = 0 - sum;

        return sum;

    }

    /**
     * Receives a number and returns the count of it's digits.
     * Returns -1 if number is negative, 1 if number is 0.
     *
     * @param number (int) number to count digits of.
     * @return counter (int) numbers digits.
     */

    public static int getDigitCount(int number) {
        if (number < 0)
            return -1;
        if (number == 0)
            return 1;

        int counter = 0;

        while (number > 0) {
            number /= 10;
            counter += 1;
        }
        return counter;
    }

}
