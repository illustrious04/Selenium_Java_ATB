package testCases;

import java.util.Random;

import org.apache.commons.text.RandomStringGenerator;

public class Extra {
	
//-----------------------Main Method--------------------------------------------
	public static void main(String[] args) {
        String randomNumber = generateRandomNumberString(4);
        System.out.println("Random number string: " + randomNumber);
        
        String alphanumericNumber = generateAlphanumericWithAt(5, 4);
        System.out.println("Alphanumeric Number is "+ alphanumericNumber);
        
    }
	
//-----------------------How to Generate A Random Number-------------------------
	public static String generateRandomNumberString(int length) {
        Random random = new Random();
        String result = ""; // Start with an empty string

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // 0 to 9
            result += digit; // Append the digit to the string
        }

        return result;
    }

//-------------------------How to Generate AlphaNumetic Number with @-------------
	public static String generateAlphanumericWithAt(int stringLength, int numberLength) {
	    // 1. Generate Random Letters:
	    RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder()
	            .withinRange('a', 'z').withinRange('A', 'Z')
	            .build();
	    String randomLetters = stringGenerator.generate(stringLength); // Example: "aBcDe"

	    // 2. Add the "@" Symbol (using StringBuilder for efficiency):
	    StringBuilder result = new StringBuilder(randomLetters); // Start with the letters
	    result.append("@"); // Now it's "aBcDe@"

	    // 3. Generate Random Numbers:
	    Random randomNumber = new Random();
	    for (int i = 0; i < numberLength; i++) {
	        int digit = randomNumber.nextInt(10); // 0 to 9
	        result.append(digit); // Example: "aBcDe@1", then "aBcDe@12", then ...
	    }

	    // 4. Combine (StringBuilder to String):
	    return result.toString(); // Example: "aBcDe@123"
	}
//-------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
