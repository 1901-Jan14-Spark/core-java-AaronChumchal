package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] y= string.toCharArray();
		char temp;
		for (int i=0; i<(y.length/2);i++) {
			temp=y[i];
			y[i]=y[y.length-1-i];
			y[y.length-1-i]=temp;
			
		}
		String z= new String(y);
		return z;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String acr="";
	String[] word=phrase.split("\\s|-|,//s");
	for(int i=0;i<word.length;i++) {
		acr=acr+word[i].charAt(0);
}
acr=acr.toUpperCase();
			return acr;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(sideOne==sideTwo && sideOne==sideThree) {
				return true;
			}else {
			return false;
			}
		}

		public boolean isIsosceles() {
			if(sideOne==sideTwo && sideOne==sideThree) {
				return false;
			}
			if (sideOne==sideTwo || sideOne==sideThree|| sideTwo==sideThree) {
			return true;
			}else {return false;
				}
		}

		public boolean isScalene() {
			if (sideOne==sideTwo || sideOne==sideThree|| sideTwo==sideThree) {
				return false;
			}
				else{
					return true;
				}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		int score=0;
		string=string.toLowerCase();
		char[] letters=string.toCharArray();
		for(int i=0;i<letters.length;i++ ) {
			
			switch(letters[i]) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'l':
			case 'n':
			case 's':
			case 'r':
			case 't':
			score=score+1;
			break;
			
			case 'd':
			case 'g':
			score=score+2;
			break;
			
			case 'b':
			case 'c':
			case 'm':
			case 'p':
			score=score+3;
			break;
			
			case 'f':
			case 'h':
			case 'v':
			case 'w':
			case 'y':
			score=score+4;
			break;
			
			case 'k':
				score=score+5;
				break;
			
			case 'j':
			case 'x':
			score=score+8;
			break;
			
			case 'q':
			case 'z':
			score=score+10;
			break;
			
			}
		}
		return score;
		
		
		
		
		
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String clean=string.replaceAll("[^!0-9]", "");
		
		if (clean.length()==10) {
		
		
		return clean;
		}else {throw new IllegalArgumentException();
		}
		
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
String[] words=string.split(",\n|\\s|,");
		
		HashMap<String, Integer> wordCount= new HashMap<String, Integer>();
		int count=0;
		ArrayList<String> repeats=new ArrayList<String>();
		for(int i=0; i<words.length;i++) {
			if(repeats.contains(words[i])) {
				repeats.add(i," ");
				continue;
			}else {
			for(int j=0;j<words.length;j++) {
				if(words[i].contentEquals(words[j])) {
					
					count=count+1;
				}
			}
			wordCount.put(words[i], (Integer)count);
			count=0;
			repeats.add(i,words[i]);
			}
		}
		
		return wordCount;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			List sortList=getSortedList();
			int x=search(sortedList, t, 0, sortedList.size());
			
			
			
			return x;
		}
		public int search(List sortList, T t, int start, int end ) {
			
		int intVal=Integer.parseInt((String) t);
			if (end>start) {
				int mid=sortList.size()/2;
				if((int)(sortList.get(mid))==intVal) {
					return (int)sortList.get(mid);
				}
				if((int)(sortList.get(mid))>intVal) {
					return search(sortList, t, start, (((int)(sortList.get(mid))-1)));
				}
				if((int)(sortList.get(mid))<intVal) {
					return search(sortList, t, (((int)(sortList.get(mid))-1)), end);
				}
				
				
			}	
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String newString;
		int i=0;
		char x;
		char y;
		
		boolean done=false;
		String[] phrase=string.split("\\s");
		
		String[] pigPhrase=new String[phrase.length];
		for(int j=0; j<phrase.length; j++) {
			newString=phrase[j];
			
			done=false;
		while(done==false) {
			 x=string.charAt(i);
			 y=string.charAt(i+1);
		if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u'  ) {
			newString=newString.concat("ay");
			done=true;
			
			pigPhrase[j]=newString;
		} 
		
			if(x=='Q' ||x=='q') {
				char[] Ax=new char[] {x};
				char[] Ay=new char[] {y};
				String rep=new String(Ax) + new String(Ay);
				newString=newString.concat(rep);
				newString=newString.replaceFirst(rep,"");
				i=i+2;
				
			}else {
			char[] chArr=new char[] {x};
			String rep=new String(chArr);
			newString=newString.concat(rep);
			newString=newString.replaceFirst(rep,"");
			i++;
			}
		}
		}
		String pig = "";
		
		for(int k=0;k<pigPhrase.length;k++) {
			if(k==0) {
				pig=pigPhrase[k];
			
			}else {
				pig=pig +  " " + pigPhrase[k];
			}
		 
		}
		return pig;
		
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		String count = Integer.toString(input);
		int digits=count.length();
		double sum=0;
		char c='a';
		for(int i=0; i<digits;i++) {
			c=count.charAt(i);
			sum=sum+ Math.pow(Integer.parseInt(String.valueOf(c)), digits);
			
			
		}
		if(input==sum) {
			return true;
		}else {
			return false;
		}
		
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	static ArrayList<Long> PrimeArray= new ArrayList<Long>();
	public static List<Long> calculatePrimeFactorsOf(long l) {
		if (l==2L) {
			PrimeArray.add(2L);
		}
		Long copy=0L;
		for(Long i=2L; i<l;i++) {
			if (l%i==0) {
				copy= (l/i);
				System.out.println("t"+i);
				if(i==2L) {
					PrimeArray.add(i);
				}else {
					factors(i);
				}
				if(copy==2L) {
					PrimeArray.add(copy);
				}else {
					factors(copy);
				}
				
				break;
			}
		}
		
		return PrimeArray;
		
	}
	public static  void factors(Long num) {
	Long copy=0L;
		
		for(Long i=2L; i<num;i++) {
			if (num%i==0) {
				copy= (num/i);
				if(i==2L) {
					PrimeArray.add(i);
				}else {
					factors(i);
				}
				if(copy==2L) {
					PrimeArray.add(copy);
				}else {
					factors(copy);
				}
				break;
			}
			if (i==(num-1L) && num%i!=0L) {
				PrimeArray.add(num);
			}
			}	
				
		}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			char x='a';
			while (key>26) {
				key=key-26;
			}
		char[] arr=new char[string.length()];
			
			 for(int i=0;i<string.length();i++ ) {
				 x=string.charAt(i);
				 if(x>64 && x<91 ) {
				 x=(char) (x+key);
				 if(x>90) {
					 x=(char) (x-26);
				 }
				 arr[i]=x;
				 }
				 if( x>96 && x<123) {
					 x=(char) (x+key);
					 if(x>122) {
						 x=(char) (x-26);
					 }
					 arr[i]=x;
			 }else {
				 arr[i]=x;
				 
			 }
				 
			 }
			 String cipher= new String(arr);
			 
			return cipher;
		
			
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		if(i==0) {
			throw new IllegalArgumentException();
		}
		int count=0;
		int x=2;
		int fin=0;
		while(count<i) {
			
		int p=0;
		for(int j=2;j<x;j++ ) {
			if (x%j==0) {
				p=p+1;
			}
		}
		if(x==2) {
			x++;
			count++;
			fin=2;
			continue;
		}
		if (p>0){
			x++;
			
		continue;
		}else {
			fin=x;
			x++;
			count++;
		}
		}
			return fin;
		
	}
	

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			string=string.toLowerCase();
			string=string.replaceAll(",", "");
			string=string.replaceAll("\\.", "");
			char x='a';
			char[] charr= new char[string.length()];
			for(int i=0;i<string.length();i++) {
				x=string.charAt(i);
				if(x>96 && x<123) {
				char x2=(char) (122-x+97);
				charr[i]=x2;
				}else {
					charr[i]=x;
				}
				}
			
			String cipher= new String(charr);
			cipher=cipher.replaceAll(" ", "");
			
			StringBuilder sb = new StringBuilder();
			charr=cipher.toCharArray();
			for(int i=1;i<=charr.length;i++ ) {
				if(i>3 && i%5==0) {
					sb.append(charr[i-1]).append(" ");
				}else {
					sb.append(charr[i-1]);
				}
				cipher=sb.toString();
				
				cipher=cipher.trim();
			}
			return cipher;
			
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			string=string.toLowerCase();
			string=string.replaceAll(" ", "");
			string=string.replaceAll("\\.", "");
			char x='a';
			char[] charr= new char[string.length()];
			for(int i=0;i<string.length();i++) {
				x=string.charAt(i);
				if(x>96 && x<123) {
				char x2=(char) (122-x+97);
				charr[i]=x2;
				}else {
					charr[i]=x;
				}
				}
			
			String cipher= new String(charr);
			
			
			return cipher;
		}
		
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		
		string=string.replaceAll("-", "");
		char[] check=string.toCharArray();
		for(int i=0;i<check.length-1;i++) {
			int a=(check[i]);  
			if (a<48 || a>57) {
				return false;
			}
		}
		char lastVal=check[9];
		System.out.println(string);
		if (lastVal!='X' && (lastVal<48 || lastVal>57)) {
			return false;
		}
		
		int x1=Character.getNumericValue(string.charAt(0));
		int x2=Character.getNumericValue(string.charAt(1));
		int x3=Character.getNumericValue(string.charAt(2));
		int x4=Character.getNumericValue(string.charAt(3));
		int x5=Character.getNumericValue(string.charAt(4));
		int x6=Character.getNumericValue(string.charAt(5));
		int x7=Character.getNumericValue(string.charAt(6));
		int x8=Character.getNumericValue(string.charAt(7));
		int x9=Character.getNumericValue(string.charAt(8));
		int x10=5;
		if(lastVal=='X') {
			 x10=10;
		}else {
		 x10=Character.getNumericValue(string.charAt(9));
		}
		System.out.println(x10);
		if ((x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) % 11 == 0) {
			return true;
		}else {
		return false;
		}
		
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: Ï€Î±Î½ Î³Ï�Î¬Î¼Î¼Î±, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		string=string.replaceAll(" ", "");
		string=string.toLowerCase();
		
		char c=66;
		for(int i=97;i<123;i++) {
			c=(char) i;
		
			char[] p=new char[1];
			p[0]=c;
			String s=new String(p);
			if(string.contains(s)){
				continue;
			}else {
				return false;
			}
			
		}
		
		return true;
	
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		if (given instanceof LocalDateTime) {
			LocalDateTime given2=((LocalDateTime) given).plusDays(11574);
			LocalDateTime given3=given2.plusHours(1);
			LocalDateTime given4=given3.plusMinutes(46);
			LocalDateTime given5=given4.plusSeconds(40);
			return given5;
			}else {
		LocalDate g=((LocalDate) given).plusDays(11574);
		LocalDateTime t=((LocalDate) g).atTime(1, 46, 40);
		return t;
			}
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		ArrayList<String> repeats= new ArrayList<String>();
		int sum=0;
		String store="";
		for(int j=0; j<set.length; j++) {
			for(int k=0;k<i;k++){
				if (k%set[j]==0 && repeats.contains(Integer.toString(k))==false) {
					
				sum=sum+k;
				store=Integer.toString(k);
				repeats.add(store);
				
			}
		}
	}
		return sum;
		
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		int other=0;
		int num=0;
		int sum=0;
		string=string.replaceAll(" ", "");
		char[] charr=string.toCharArray();
		char x='1';
		for(int i=(charr.length-1); i>=0; i--){
			if (charr[i]<48 || charr[i]>57) {
			return false;
		}
			if(other>0) {
				num=Character.getNumericValue(charr[i]);
				num=num*2;
				if(num>9) {
					num=num-9;
				}
				sum=sum+num;
				
				
				other=other-1;
			}else {
				num=Character.getNumericValue(charr[i]);
				sum=sum+num;
				other=other+1;
				
			}
		}
			if(sum%10==0) {
				return true;
			}else {
				return false;
		}
		
		
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		string=string.replace("?", "");
		int x=0;
		int y=0;
		int count=0;
		int result=0;
		String[] stArray=string.split(" ");
		for(int i=0; i<stArray.length; i++) {
			try {
				if (count<1) {
				x=Integer.parseInt(stArray[i]);
				
				count=count+1;
				}else {
					y=Integer.parseInt(stArray[i]);
				}
			}catch(NumberFormatException e) {
				
				continue;
			}
			
		}
		
		if(string.contains("plus")) {
			result=x+y;
		}
		if(string.contains("minus")) {
			result=x-y;
		}
		if(string.contains("multiplied")) {
			result=x*y;
		}
		if(string.contains("divided")) {
			result=x/y;
		}
		
		return result;
	}

}
