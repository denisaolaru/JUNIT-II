public class Main {


    public static void main ( String[] args ) {

        Calculator calculator = new Calculator ( );
        long start1 = System.nanoTime ( );
        long start2 = System.nanoTime ( );
        calculator.calculateExpression ( "12 mm + 10 cm" );
        long stop = System.nanoTime ( );
        long diff = stop - 2 * start2 + start1;
        System.out.println ( diff + " ns" );

    }

}
