package com.driver;

import java.util.Arrays;
import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance);
        this.tradeLicenseId = tradeLicenseId;
        if(balance < 5000) throw new Exception("Insufficient Balance");
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

    }

    public void validateLicenseId() throws Exception {

        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        char[] chars = tradeLicenseId.toCharArray();
        if(!isValid(tradeLicenseId)){
            // if false, then this is not valid
            throw new Exception("Valid License can not be generated");
        }else{
            // if not valid then try to valid.
            String validId = generateValidLicenseId(tradeLicenseId);
        }

    }
    public static String generateValidLicenseId(String licenseId) throws Exception {
        char[] chars = licenseId.toCharArray();
        Arrays.sort(chars);

        String sortedLicenseId = new String(chars);


        int n = sortedLicenseId.length();
        StringBuilder validLicenseId = new StringBuilder();
        int left = 0;
        int right = (n % 2 == 0) ? n / 2 : n / 2 + 1;
// ABBCCDD
        // ACBDBD
        while (right < n) {
            validLicenseId.append(sortedLicenseId.charAt(left));
            validLicenseId.append(sortedLicenseId.charAt(right));
            left++;
            right++;
        }

        if (n % 2 != 0) {
            validLicenseId.append(sortedLicenseId.charAt(left));
        }



        return validLicenseId.toString();
    }
    public boolean isValid(String str){
        int count = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int i = 0;
        int len = str.length();
        while(i < len){
            char ch = str.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
            if(hm.size() != 0 && hm.get(ch) > count){
                count = hm.get(ch);
            }
            i++;
        }
        if(count >= len/2){
            return false;
        }
        return true;
    }

}
