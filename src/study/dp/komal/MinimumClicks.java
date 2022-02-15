/**
 * 
 */
package com.hitachivantara.multicloud.providercost.azure;

/**
 * @author kkadam
 *
 */
public class MinimumClicks {
	int currentChannel = -1;
	int previousChannel = -1;
	
	
	public int getMinimuNumClicks (int channnelNo) {
		int clicks = 0;
		if (currentChannel != -1) {
			
			if (currentChannel == channnelNo)
				clicks = 0;
			//Memo case
			if (previousChannel != -1 &&channnelNo == previousChannel) {
				clicks =  1;
			}
				
			else if (Math.abs(currentChannel - channnelNo) == 1) {
				clicks =  1;
			}
			else if (Math.abs(currentChannel - channnelNo) == 2) {
				clicks =  2;
			} else {
				
				clicks =  getDigits(channnelNo);
			}
				
		}
		else {
			clicks =  getDigits(channnelNo);
		}
		previousChannel = currentChannel;
		currentChannel = channnelNo;
		return clicks;
	}

	private int getDigits(int channnelNo) {
		int count_digits = 0;
		int channelDigit = channnelNo;
		while (channelDigit >= 1) {
			count_digits++;
			channelDigit = channelDigit/10;
		}
		//currentChannel = channnelNo;
		return count_digits;
	}
	
	public static void main(String[] args) {
		MinimumClicks clicks = new MinimumClicks();
		System.out.println(clicks.getMinimuNumClicks(123));
		System.out.println(clicks.getMinimuNumClicks(124));
		System.out.println(clicks.getMinimuNumClicks(23));
		System.out.println(clicks.getMinimuNumClicks(124));
		System.out.println(clicks.getMinimuNumClicks(5));
		//System.out.println(clicks.getMinimuNumClicks(8));
		
	}

}


/*

Two services
1. Service 1 : 
2. Service 2 :
	
//Different providers
	like google, ibm, aws
google : protocol http
ibm : protocol grpc

google : service 1
ibm : service 1 and 2
aws : service 2

API : servicelist, and provider
	key, value : service1 : google and service2:ibm
	
	
1. API with input and output
2. High level design architecture

*/




