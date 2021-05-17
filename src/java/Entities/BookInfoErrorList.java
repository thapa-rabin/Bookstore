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
public class BookInfoErrorList {
    
    private boolean nameMissing = false;
    private boolean isbnMissing = false;
    private boolean isbnNotNumeric = false;
    private boolean isbnTooLong = false;
    //private boolean isbnTooShort = false;
    private boolean isbnInvalidFormat = false;
    private boolean isbnInvalid = false;
    private boolean authorMissing = false;
    private boolean conditionMissing = false;
    private boolean priceMissing = false;
    private boolean priceNotNumeric = false;
    private boolean priceNegative = false;

    public boolean isNameMissing() {
        return nameMissing;
    }

    public void setNameMissing(boolean nameMissing) {
        this.nameMissing = nameMissing;
    }

    public boolean isIsbnMissing() {
        return isbnMissing;
    }

    public boolean isIsbnNotNumeric() {
        return isbnNotNumeric;
    }

    public void setIsbnNotNumeric(boolean isbnNotNumeric) {
        this.isbnNotNumeric = isbnNotNumeric;
    }

    public void setIsbnMissing(boolean isbnMissing) {
        this.isbnMissing = isbnMissing;
    }

    public boolean isIsbnInvalidFormat() {
        return isbnInvalidFormat;
    }

    public void setIsbnInvalidFormat(boolean isbnInvalidFormat) {
        this.isbnInvalidFormat = isbnInvalidFormat;
    }
    
    public boolean isIsbnInvalid() {
        return isbnInvalid;
    }

    public void setIsbnInvalid(boolean isbnInvalid) {
        this.isbnInvalid = isbnInvalid;
    }

    public boolean isAuthorMissing() {
        return authorMissing;
    }

    public void setAuthorMissing(boolean authorMissing) {
        this.authorMissing = authorMissing;
    }

    public boolean isConditionMissing() {
        return conditionMissing;
    }

    public void setConditionMissing(boolean conditionMissing) {
        this.conditionMissing = conditionMissing;
    }

    public boolean isPriceMissing() {
        return priceMissing;
    }

    public void setPriceMissing(boolean priceMissing) {
        this.priceMissing = priceMissing;
    }

    public boolean isPriceNotNumeric() {
        return priceNotNumeric;
    }

    public void setPriceNotNumeric(boolean priceNotNumeric) {
        this.priceNotNumeric = priceNotNumeric;
    }

    public boolean isPriceNegative() {
        return priceNegative;
    }

    public void setPriceNegative(boolean priceNegative) {
        this.priceNegative = priceNegative;
    }
    
}
