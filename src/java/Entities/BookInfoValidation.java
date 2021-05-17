/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author thapa.rbn24
 */
public class BookInfoValidation {
    
    //if the trimmed input is empty string
    //return true, set nameMissing to true
    public static boolean validateName(String name, 
                                        BookInfoErrorList errors) {
        if("".equals(name.trim())) {
            errors.setNameMissing(true);
            return false;
        }
        else {
            return true;
        }
    }
    
    //check if the input is a valid isbn
    //does isbn have to match the book?
    //check the algorithm for valid isbn (isIsbnValid)
    public static boolean validateIsbn(String isbn, 
                                        BookInfoErrorList errors) {
        //if the trimmed input is empty string
        //create isbnMissing error
        isbn = isbn.trim();
        if("".equals(isbn)) {
            errors.setIsbnMissing(true);
            return false;
        }
        
        //check if input has any character that is not digit or '-'
        //if so, set isbnNotNumeric to true
        for(int i=0;i<isbn.length();i++) {
            char c = isbn.charAt(i);
            if(Character.isDigit(c) || c == '-')
                continue;
            else {
                errors.setIsbnNotNumeric(true);
                return false;
            }   
        }
        
        //ISBN should be in XXX-X-XX-XXXXXX-X format
        String isbnRegEx = "\\d{3}-\\d-\\d{2}-\\d{6}-\\d"; //might want to loosen the contraint
        //if ISBN not in correct format, set isbnInvalid to true
        if(!isbn.matches(isbnRegEx)) {
            errors.setIsbnInvalidFormat(true); 
            return false;
            }
        else {
            //check if ISBN is valid
            //calculate the sum: 1*first_digit+3*second_digit+1*third_digit+...+1*thirteenth_digit
            //if the sum is a multiple of ten, then the number is a valid ISBN
            isbn = isbn.replace("-","");
            int sum = 0;
            for(int i=0;i<13;i++) {
                int multiple;
                if(i%2==0)
                    multiple = 1;
                else
                    multiple = 3;
                
                int digit = Character.getNumericValue(isbn.charAt(i));
                sum += multiple*digit;
            }
            if(sum%10 != 0) {
                errors.setIsbnInvalid(true); 
                return false;
            } 
            else 
                return true;
        }
        
        /*
        else {
            //else, check length of inpput
            //and parse the value to Integer
            try { 
                //check if the input is an Integer
                Long.parseLong(isbn.trim()); // 13-digit isbn is not in range of primitive int
                
                //if the input is an integer
                //check if input is 13 digits long
                isbn = isbn.trim();
                if(isbn.length() > 13) {
                    errors.setIsbnTooLong(true);
                    return false;
                }
        
                //check if input isbn shorter 13 digits long
                if(isbn.length() < 13) {
                    errors.setIsbnTooShort(true);
                    return false;
                }
                
                //do further testing on validity of isbn
            }
            //if value is not an integer (i.e. NumberFormatException occurs)
            //create priceNotNumeric error
            catch(NumberFormatException ex) {
                errors.setIsbnNotNumeric(true);
                return false;
            }
        }*/
    }
    
    public static boolean validateAuthor(String author, 
                                        BookInfoErrorList errors) {
        //if the trimmed input is empty string
        //create authorMissing error
        if("".equals(author.trim())) {
            errors.setAuthorMissing(true);
            return false;
        }
        else {
            return true;
        }
    }
    
    public static boolean validateCondition(String condition, 
                                        BookInfoErrorList errors) {
        //if the trimmed input is empty string
        // set conditionMissing to true
        if(condition == null || condition.equals("choose")) {
            errors.setConditionMissing(true);
            return false;
        }
        else {
            return true;
        }
    }
    
    public static boolean validatePrice(String price, 
                                        BookInfoErrorList errors) {
        //if the trimmed input is empty string
        //create priceMissing error
        if("".equals(price.trim())) {
            errors.setPriceMissing(true);
            return false;
        }
        else {
            //else, parse the value to Double
            try {
                double priceValue = Double.parseDouble(price);
                
                //if value is a number, check if it is negative
                //if yes, create priceNegative error
                if (priceValue < 0) {
                    errors.setPriceNegative(true);
                    return false;
                }
            }
            //if value is not a number (i.e. NumberFormatException occurs)
            //create priceNotNumeric error
            catch (NumberFormatException ex) {
                errors.setPriceNotNumeric(true);
                return false;
            }
        } 
        return true;
    }
    
}
