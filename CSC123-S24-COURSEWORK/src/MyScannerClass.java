import java.io.*;

/**
 * MyScannerClass is a scanner class used for parsing primitive types and strings.
 */
	public class MyScannerClass {
	private String source;
	private BufferedReader reader;
    private int position;
    private char delimiter;
	
    /**
     * Constructor for MyScannerClass instance with input source, position, & delimiter.
     *
     * @param source string to scan it
     */
    public MyScannerClass(String source) {
        this.source = source;
        this.position = 0;
        this.delimiter = ' ';
    }
    

    /**
     * Constructs a new MyScannerClass instance that produces values scanned from the specified InputStream.
     *
     * @param inputStream the input stream to scan
     */
    public MyScannerClass(InputStream inputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
        this.position = 0;
        this.delimiter = ' ';
    }

    /**
     * Constructs a new MyScannerClass instance that produces values scanned from the specified File.
     *
     * @param file the file to scan
     * @throws FileNotFoundException if the file does not exist, is a directory rather than a regular file,
     * or for some other reason cannot be opened for reading
     */
    public MyScannerClass(File file) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(file));
        this.position = 0;
        this.delimiter = ' ';
    }
    
    /**
     * This sets the delimiter, which is a separating character used to tokenize the input string.
     *
     * @param delimiter the delimiter character
     */
    public void useDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }
    
    /**
     * hasNext() true if there is another token in the input of this scanner.
     *
     * @return true if the scanner has another token, if not it will return false
     * @throws IOException if an I/O error occurs
     */
    public boolean hasNext() {
    	if (reader != null) {
            try {
                return reader.ready();
            } catch (IOException e) {
                // Handle the IOException here, either by logging it or throwing a custom runtime exception
                e.printStackTrace();
                throw new RuntimeException("Error reading input", e);
            }
        } else {
            return position < source.length();
        }
    }
    
    /**
     * The next() reads and returns the next token which is the delimited element as a String.
     * Throws an exception if there's no more input.
     *
     * @return the next token as a String
     * @throws MyNoSuchElementException if there's no more input
     */
    public String next() throws MyNoSuchElementException {
        if (!hasNext())
            throw new MyNoSuchElementException("No more input available");

        StringBuilder token = new StringBuilder();
        while (position < source.length() && source.charAt(position) != delimiter) {
            token.append(source.charAt(position));
            position++;
        }
        // This will skip the delimiter if there is no more input.
        if (position < source.length()) {
            position++;
        }
        return token.toString();
    }
    
    /**
     * hasNextInt() returns true if the next token can be parsed as an integer.
     *
     * @return true if the next token can be parsed as an integer, otherwise return false
     */
    public boolean hasNextInt() {
        if (!hasNext())
            return false;
        try {
            Integer.parseInt(peekNext());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * This MyNoSuchElementException is a custom exception class for MyScannerClass when there's no more input.
     */
    class MyNoSuchElementException extends RuntimeException {
        public MyNoSuchElementException(String message) {
            super(message);
        }
    }

    /**
     * This MyInputMismatchException is a custom exception class for MyScannerClass when input is not in the proper formating.
     */
    class MyInputMismatchException extends RuntimeException {
        public MyInputMismatchException(String message) {
            super(message);
        }
    }
    
    /**
     * nextInt() reads the next token, then converts it to an int, and returns the value.
     * Throws an exception if the input isn't a valid integer.
     *
     * @return the next token as an int
     * @throws MyInputMismatchException if the next token is not a valid integer
     * @throws MyNoSuchElementException if there's no more input
     */
    public int nextInt() throws MyInputMismatchException, MyNoSuchElementException {
        if (!hasNext())
            throw new MyNoSuchElementException("No more input available");

        String token = next();
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new MyInputMismatchException("Input is not a valid integer: " + token);
        }
    }
    
    /**
     * nextDouble() reads the next token, then converts it to a double, and returns the value.
     * Throws an exception if the input isn't a valid double.
     *
     * @return the next token as a double
     * @throws MyInputMismatchException if the next token is not a valid double
     * @throws MyNoSuchElementException if there's no more input
     */
    public double nextDouble() throws MyInputMismatchException, MyNoSuchElementException {
        if (!hasNext())
            throw new MyNoSuchElementException("No more input available");

        String token = next();
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            throw new MyInputMismatchException("Input is not a valid double: " + token);
        }
    }

    /**
     * nextLong() reads the next token, then converts it to a long, and returns the value.
     * Throws an exception if the input isn't a valid long.
     *
     * @return the next token as a long
     * @throws MyInputMismatchException if the next token is not a valid long
     * @throws MyNoSuchElementException if there's no more input
     */
    public long nextLong() throws MyInputMismatchException, MyNoSuchElementException {
        if (!hasNext())
            throw new MyNoSuchElementException("No more input available");

        String token = next();
        try {
            return Long.parseLong(token);
        } catch (NumberFormatException e) {
            throw new MyInputMismatchException("Input is not a valid long: " + token);
        }
    }
    
    /**
     * nextFloat() reads the next token, then converts it to a float, and returns the value.
     * Throws an exception if the input isn't a valid float.
     *
     * @return the next token as a float
     * @throws MyInputMismatchException if the next token is not a valid float
     * @throws MyNoSuchElementException if there's no more input
     */
    public float nextFloat() throws MyInputMismatchException, MyNoSuchElementException {
        if (!hasNext())
            throw new MyNoSuchElementException("No more input available");

        String token = next();
        try {
            return Float.parseFloat(token);
        } catch (NumberFormatException e) {
            throw new MyInputMismatchException("Input is not a valid float: " + token);
        }
    }
    
    /**
     * nextShort() reads the next token, converts it to a short, and returns the value.
     * Throws an exception if the input isn't a valid short.
     *
     * @return the next token as a short
     * @throws MyInputMismatchException if the next token is not a valid short
     * @throws MyNoSuchElementException if there's no more input
     */
    public short nextShort() throws MyInputMismatchException, MyNoSuchElementException {
        if (!hasNext())
            throw new MyNoSuchElementException("No more input available");

        String token = next();
        try {
            return Short.parseShort(token);
        } catch (NumberFormatException e) {
            throw new MyInputMismatchException("Input is not a valid short: " + token);
        }
    }
    
    /**
     * nextByte() reads the next token, converts it to a byte, and returns the value.
     * Throws an exception if the input isn't a valid byte.
     *
     * @return the next token as a byte
     * @throws MyInputMismatchException if the next token is not a valid byte
     * @throws MyNoSuchElementException if there's no more input
     */
    public byte nextByte() throws MyInputMismatchException, MyNoSuchElementException {
        if (!hasNext())
            throw new MyNoSuchElementException("No more input available");

        String token = next();
        try {
            return Byte.parseByte(token);
        } catch (NumberFormatException e) {throw new MyInputMismatchException("Input is not a valid byte: " + token);
        }
    }

    /**
     *  nextLine() reads and returns all remaining characters (including the newline) on the current line as a String.
     *
     * @return the remaining characters on the current line as a String
     * @throws MyNoSuchElementException if there's no more input
     */
    public String nextLine() throws MyNoSuchElementException {
        if (!hasNext())
            throw new MyNoSuchElementException("No more input available");

        StringBuilder line = new StringBuilder();
        while (position < source.length() && source.charAt(position) != '\n') {
            line.append(source.charAt(position));
            position++;
        }
        // Include the newline character if present
        if (position < source.length() && source.charAt(position) == '\n') {
            line.append('\n');
            position++;
        }
        return line.toString();
    }

    /**
     * nextBoolean() reads the next token, converts it to a boolean, and returns the value.
     * Throws an exception if the input isn't a valid boolean representation.
     *
     * @return the next token as a boolean
     * @throws MyInputMismatchException if the next token is not a valid boolean
     * @throws MyNoSuchElementException if there's no more input
     */
    public boolean nextBoolean() throws MyInputMismatchException, MyNoSuchElementException {
        if (!hasNext())
            throw new MyNoSuchElementException("No more input available");

        String token = next();
        if ("true".equalsIgnoreCase(token) || "1".equals(token) || "1.0".equals(token)) { 
            return true;
        } else if ("false".equalsIgnoreCase(token) || "0".equals(token) || "0.0".equals(token)) { 
            return false;
        } else {
            throw new MyInputMismatchException("Input is not a valid boolean: " + token);
        }
    }


    /**
     * hasNextDouble() returns true if the next token can be parsed as a double.
     *
     * @return true if the next token can be parsed as a double; otherwise false
     */
    public boolean hasNextDouble() {
        if (!hasNext())
            return false;
        try {
            Double.parseDouble(peekNext());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * hasNextLong() returns true if the next token can be parsed as a long.
     *
     * @return true if the next token can be parsed as a long; otherwise false
     */
    public boolean hasNextLong() {
        if (!hasNext())
            return false;
        try {
            Long.parseLong(peekNext());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * hasNextFloat() returns true if the next token can be parsed as a float.
     *
     * @return true if the next token can be parsed as a float; otherwise false
     */
    public boolean hasNextFloat() {
        if (!hasNext())
            return false;
        try {
            Float.parseFloat(peekNext());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * hasNextShort() returns true if the next token can be parsed as a short.
     *
     * @return true if the next token can be parsed as a short; otherwise false
     */
    public boolean hasNextShort() {
        if (!hasNext())
            return false;
        try {
            Short.parseShort(peekNext());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * hasNextByte() returns true if the next token can be parsed as a byte.
     *
     * @return true if the next token can be parsed as a byte; otherwise false
     */
    public boolean hasNextByte() {
        if (!hasNext())
            return false;
        try {
            Byte.parseByte(peekNext());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Helper method used to peek at the next token while not going to the next position.
     *
     * @return the next token as a String
     */
    private String peekNext() {
        int peekPosition = position;
        while (peekPosition < source.length() && source.charAt(peekPosition) != delimiter) {
            peekPosition++;
        }
        return source.substring(position, peekPosition);
    }

    /**
     * Main method is used for testing MyScannerClass.
     */
    public static void main(String[] args){
        // Example input
        String input = "Hello 654 6.20 true";
        MyScannerClass scanner = new MyScannerClass(input);
        try {
        	// Testing reading different types of values
        	System.out.println(scanner.next()); // Output: Hello
        	System.out.println(scanner.nextInt()); // Output: 987
        	System.out.println(scanner.nextDouble()); // Output: 4.19
        	System.out.println(scanner.nextBoolean()); // Output: true
        
        	// Test reading a long
        	String longInput = "1234567890123456789";
        	MyScannerClass longScanner = new MyScannerClass(longInput);
        	System.out.println(longScanner.nextLong()); // Output: 1234567890123456789

        	// Test reading a negative integer
        	String negativeIntInput = "-567";
        	MyScannerClass negativeIntScanner = new MyScannerClass(negativeIntInput);
        	System.out.println(negativeIntScanner.nextInt()); // Output: -987

        	// Test reading a negative double
        	String negativeDoubleInput = "-6.79";
        	MyScannerClass negativeDoubleScanner = new MyScannerClass(negativeDoubleInput);
        	System.out.println(negativeDoubleScanner.nextDouble()); // Output: -3.14

        	// Test reading a boolean in uppercase
        	String uppercaseBooleanInput = "TRUE";
        	MyScannerClass uppercaseBooleanScanner = new MyScannerClass(uppercaseBooleanInput);
        	System.out.println(uppercaseBooleanScanner.nextBoolean()); // Output: true

        	// Test reading a boolean in mixed case
        	String mixedCaseBooleanInput = "TrUe";
        	MyScannerClass mixedCaseBooleanScanner = new MyScannerClass(mixedCaseBooleanInput);
        	System.out.println(mixedCaseBooleanScanner.nextBoolean()); // Output: true

        	// Test reading a boolean in integer format
        	String intBooleanInput = "1";
        	MyScannerClass intBooleanScanner = new MyScannerClass(intBooleanInput);
        	System.out.println(intBooleanScanner.nextBoolean()); // Output: true

        	// Test reading a boolean in float format
        	String floatBooleanInput = "1.0";
        	MyScannerClass floatBooleanScanner = new MyScannerClass(floatBooleanInput);
        	System.out.println(floatBooleanScanner.nextBoolean()); // Output: true

        	// Test reading a boolean in string format
        	String stringBooleanInput = "truE";
        	MyScannerClass stringBooleanScanner = new MyScannerClass(stringBooleanInput);
        	System.out.println(stringBooleanScanner.nextBoolean()); // Throws: MyInputMismatchException

        	// Test reading an empty string
        	String emptyInput = "";
        	MyScannerClass emptyScanner = new MyScannerClass(emptyInput);
        	System.out.println(emptyScanner.hasNext()); // Output: false
    	} catch (MyNoSuchElementException | MyInputMismatchException e) {
        e.printStackTrace();
    	}
    
  }
}
