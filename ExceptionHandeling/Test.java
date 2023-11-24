package ExceptionHandeling;

class InvalidInputException extends Exception {
    int input;

    InvalidInputException(int input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "InvalidInputException[" + input + "]";
    }
}

class TestPrime {
    public Boolean isPrime(int input) throws InvalidInputException { // ducking exception, not handel by itself it just
                                                                     // throwing this exception ot handel other "those can be used basicaly for unchecked exception"
        if (input <= 1) {
            throw new InvalidInputException(input); // throw the exception that will be caught by the catch block
        }

        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0)
                return false;
        }
        return true;
    }

}

public class Test {

    public static void main(String[] args) {
        TestPrime testPrime = new TestPrime();

        try {
            if (testPrime.isPrime(5)) {
                System.out.println("5 is Prime Number.");
            } else {
                System.out.println("5 isn't Prime Number.");
            }

            if (testPrime.isPrime(0)) {
                System.out.println("0 is Prime Number.");
            } else {
                System.out.println("0 isn't Prime Number.");
            }
            if (testPrime.isPrime(4)) {
                System.out.println("4 is Prime Number.");
            } else {
                System.out.println("4 isn't Prime Number.");

            }
        } catch (InvalidInputException e) {
            System.out.println("Exception " + e);
        }
    }

}
