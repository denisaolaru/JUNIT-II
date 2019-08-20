

public class Calculator {

    public Calculator () {
    }


    public int calculateExpression ( String expression ) {

        String splitBySpace[] = new String[20];
        int numbers[] = new int[40];
        String[] unitOfMeasurement = new String[40];
        String plusMinus = "";

        splitBySpace = extractSpaces ( expression , splitBySpace );


        int j = 0;
        int k = 0;
        int l = 0;
        int total = 0;

        for ( int i = 0; i <= splitBySpace.length - 1; i++ ) {

            if ( i % 3 == 0 || i == 0 ) {
                numbers[j] = Integer.parseInt ( splitBySpace[i] );
                j++;
            }


            if ( (i + 2) % 3 == 0 ) {
                transformTheNumbers ( splitBySpace , numbers , j , i );
            }

            plusMinus = extractMinusPlus ( splitBySpace[i] , plusMinus );

        }
        total = getTotal ( numbers , plusMinus );
        return (total);
    }

    public void transformTheNumbers ( String[] splitBySpace , int[] numbers , int j , int i ) {
        String unit = "";
        unit = splitBySpace[i];

        switch (unit) {
            case "mm":
                numbers[j - 1] = numbers[j - 1];
                break;
            case "cm":
                numbers[j - 1] = numbers[j - 1] * 10;
                break;
            case "dm":
                numbers[j - 1] = numbers[j - 1] * 100;
                break;
            case "m":
                numbers[j - 1] = numbers[j - 1] * 1000;
                break;
            case "km":
                numbers[j - 1] = numbers[j - 1] * 10000;
                break;
        }
    }

    public String extractMinusPlus ( String s , String plusMinus ) {
        if ( s.equalsIgnoreCase ( "+" ) ) {
            plusMinus = plusMinus + "+";

        }
        if ( s.equalsIgnoreCase ( "-" ) ) {
            plusMinus = plusMinus + "-";
        }
        return plusMinus;
    }

    public String[] extractSpaces ( String expression , String[] splitBySpace ) {
        for ( int i = 0; i < expression.length ( ) - 1; i++ ) {
            splitBySpace = expression.split ( "\\s" );
        }
        return splitBySpace;
    }

    public int getTotal ( int[] numbers , String plusMinus ) {
        int total;
        int z = 0;
        total = numbers[0];
        for ( int i = 1; i <= numbers.length - 1; i++ ) {

            if ( plusMinus.charAt ( z ) == '+' ) {
                total = total + numbers[i];
            } else if ( plusMinus.charAt ( z ) == '-' ) {
                total = total - numbers[i];
            }
            z++;

            if ( numbers[i + 1] == 0 ) {
                break;
            }
        }
        return total;
    }


}
