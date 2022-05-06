package com.kundan.algopractice;

import java.math.BigInteger;

public class MultiplyStrings {

	public static void main(String[] args) {
		//String A="498828660196", B="840477629533";
		String A="401716832807512840963",
		B="167141802233061013023557397451289113296441069";
		System.out.println(new MultiplyStrings().multiply(A,B));
	}

	public String multiply(String num1, String num2) {
		BigInteger n1 = BigInteger.ZERO, n2 = BigInteger.ZERO;
		n1 = stringToInteger(num1);
		n2 = stringToInteger(num2);
		BigInteger result = n1.multiply(n2);
		System.out.println("num1="+num1+" num2="+num2+" n1="+n1+" n2="+n2+" n1*n2="+(result));

		return String.valueOf(result);
    }

	private BigInteger stringToInteger(String num) {
		BigInteger n = BigInteger.ZERO;
		for (int i=num.length()-1, j=0; i>=0; i--, j++) {
			int digit = (int)num.charAt(i)-48;
			BigInteger accumulate = BigInteger.valueOf(10l).pow(j).multiply(BigInteger.valueOf(digit));
			n = n.add(accumulate);
		}
		return n;
	}
	
}
