import java.util.ArrayList;
import java.util.List;

public class Q3 {
	private static String firstName = "";
    private static String lastName = "";
    private static String middleName = "";
    private static String typeOfDivision = "";
    private static List<String> middleNames = new ArrayList<String>();
    private static List<String> titlesBefore = new ArrayList<String>();
    private static List<String> titlesAfter = new ArrayList<String>();
    private static String[] prefixes = { "dr", "mr", "ms", "atty", "prof", "miss", "mrs" };
    private static String[] suffixes = { "jr", "sr", "ii", "iii", "iv", "v", "vi", "esq", "2nd", "3rd", "jd", "phd",
            "md", "cpa" };
    
    public static void reset() {
        firstName = lastName = middleName = "";
        middleNames = new ArrayList<String>();
        titlesBefore = new ArrayList<String>();
        titlesAfter = new ArrayList<String>();
    }
    
    private static boolean isOneOf(String checkStr, String[] titles) {
        for (String title : titles) {
            if (checkStr.toLowerCase().startsWith(title))
                return true;
        }
        return false;
    }
    
    public static String chop(String str) {
    	if (str == null) {
    		return null;
    	}
    	int strLen = str.length();
    	if (strLen < 2) {
    		return "";
    	}
    	int lastIdx = strLen - 1;
    	String ret = str.substring(0, lastIdx);
    	char last = str.charAt(lastIdx);
    	if (last == '\n') {
    		if (ret.charAt(lastIdx - 1) == '\r') {
    			return ret.substring(0, lastIdx - 1);
    		}
		}
        return ret;
    }

    public static boolean isBlank(String str) {
    	int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
    
    public static void parse(String name) {
        if (name.equals("") || name.equals(null))
            return;
        reset();
        String[] words = name.split("\\.");
        typeOfDivision = "DOT";
        if(name.contains("_")) {
        	words = name.split("\\_");
        	typeOfDivision = "UNDERSCORE";
        } else {
        	words = name.split("(?=\\d)", 2);
        	typeOfDivision = "CHAR";
        }
        boolean isFirstName = false;
      
        for (String word : words) {
        	word = word.replaceAll("[0-9]", "");
            if (word.equals("") || word.equals(null))
                continue;
            
            if (word.endsWith(",") || word.endsWith("(") || word.endsWith("_") || word.endsWith(")"))
                word = chop(word);
            if (isFirstName == false) {
                firstName = word;
                isFirstName = true;
            } else {
                middleNames.add(word);
            }
            
        }
        if (middleNames.size() > 0) {
            boolean stop = false;
            List<String> toRemove = new ArrayList<String>();
            for (int i = middleNames.size() - 1; i >= 0 && !stop; i--) {
                String str = middleNames.get(i);
                if (isOneOf(str, suffixes)) {
                    titlesAfter.add(str);
                } else {
                    lastName = str;
                    stop = true;
                }
                toRemove.add(str);
            }
            if (isBlank(lastName) && titlesAfter.size() > 0) {
                lastName = titlesAfter.get(titlesAfter.size() - 1);
                titlesAfter.remove(titlesAfter.size() - 1);
            }
            for (String s : toRemove) {
                middleNames.remove(s);
            }
        }
    }
	public static void main(String[] args) {
		String name = "kumar1sree";
		parse(name);
		
		String email = "kumar1sree@gmail.com";
		
		if ( typeOfDivision.equals("UNDERSCORE") ) {
			String[] emailData = email.split("@")[0].split("_");
			if ( emailData.length > 0 && emailData[0].equals(firstName) ) {
				System.out.println("FIRSTUNDERSCORELAST");
			} else {
				System.out.println("LASTUNDERSCOREFIRST");
			}
		}else if ( typeOfDivision.equals("DOT") ) {
			String[] emailData = email.split("@")[0].split("\\.");
			if ( emailData.length > 0 && emailData[0].equals(firstName) ) {
				System.out.println("FIRSTDOTLAST");
			} else {
				System.out.println("LASTDOTFIRST");
			}
		}else {
			String[] emailData = email.split("@")[0].split("(?=\\d)", 2);
			if ( emailData.length > 0 && emailData[0].equals(firstName) ) {
				System.out.println("FIRSTCHARLAST");
			} else {
				System.out.println("LASTCHARFIRST");
			}
		}
	}

}


/*
 * Input : 
 * name -> sree.pavan
 * email -> sree.pavan@gmail.com
 * 
 * Output: 
 * FIRSTDOTLAST
 * *****************************************************************
 * Input : 
 * name -> pavan.sree
 * email -> sree.pavan@gmail.com
 * 
 * Output: 
 * LASTDOTFIRST
 * 
 * *****************************************************************
 * Input : 
 * name -> sree_pavan
 * email -> sree_pavan@gmail.com
 * 
 * Output: 
 * FIRSTUNDERSCORELAST
 * 
 * *****************************************************************
 * Input : 
 * name -> pavan_sree
 * email -> sree_pavan@gmail.com
 * 
 * Output: 
 * LASTUNDERSCOREFIRST
 * *****************************************************************
 * Input : 
 * name -> sree1pavan
 * email -> sree1pavan@gmail.com
 * 
 * Output: 
 * FIRSTCHARLAST
 * 
 * *****************************************************************
 * Input : 
 * name -> pavan1sree
 * email -> sree1pavan@gmail.com
 * 
 * Output: 
 * LASTCHARFIRST
 * *****************************************************************
 * 
 * */














