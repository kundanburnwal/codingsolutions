package com.intuit.kundan;
/**
 * https://www.interviewbit.com/problems/gas-station/
 * Given two integer arrays A and B of size N.
There are N gas stations along a circular route, where the amount of gas at station i is A[i].

You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i 
to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.

You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2.. Completing the circuit means starting at i and 
ending up at i again.

Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
For Example

Input 1:
    A =  [1, 2]
    B =  [2, 1]
Output 1:
    1
    Explanation 1:
        If you start from index 0, you can fill in A[0] = 1 amount of gas. Now your tank has 1 unit of gas. But you need B[0] = 2 gas to travel to station 1. 
        If you start from index 1, you can fill in A[1] = 2 amount of gas. Now your tank has 2 units of gas. You need B[1] = 1 gas to get to station 0. So, you travel to station 0 and still have 1 unit of gas left over. You fill in A[0] = 1 unit of additional gas, making your current gas = 2. It costs you B[0] = 2 to get to station 1, which you do and complete the circuit. 

 * @author kburnwal
 *
 */
public class GasStationFilling {
	
	public static void main(String[] args) {
		int AvailableGasVolumes[] =  {1,3,4};
		int GasConsumption[] = {2,3,3};
		System.out.println("**** Tc1: Result="+canCompleteCircuit(AvailableGasVolumes, GasConsumption));
		
		int AvailableGasVolumes1[] =  {1,2};
		int GasConsumption1[] = {2,1};
		System.out.println("**** Tc2: Result="+canCompleteCircuit(AvailableGasVolumes1, GasConsumption1));
		
		int AvailableGasVolumes2[] =  {0};
		int GasConsumption2[] = {0};
		System.out.println("**** TC3:Result="+canCompleteCircuit(AvailableGasVolumes2, GasConsumption2));
		
	}
	
	public static int canCompleteCircuit(int[] AvailableGasVolumes, int[] GasConsumption) {
		
		int NumGasStations = AvailableGasVolumes.length;
		for(int startGasStationIndex = 0; startGasStationIndex < NumGasStations; startGasStationIndex++) {
			System.out.println("Starting from station:"+startGasStationIndex+" as the first station");
			boolean terminalCondition = false;
			int currentGasStationIndex = startGasStationIndex;
			int fuelTankLevel = 0;
			do {
				//currentGasStationIndex will start from startGasStationIndex , go till NumGasStations-1
				//and after NumGasStation-1, the next number will be 0, and go till startGasStation
				
				//fill all of the fuel available at the current GasStation
				fuelTankLevel += AvailableGasVolumes[currentGasStationIndex];
				//
				int fuelRequiredToReachNextGasStation = GasConsumption[currentGasStationIndex];
				System.out.println("  At GasStation:"+currentGasStationIndex+" available gas in tank is:"+fuelTankLevel+
						" but gas required to go next station is:"+fuelRequiredToReachNextGasStation);
				
				//let's travel to next station by reducing the gas required.
				fuelTankLevel -= fuelRequiredToReachNextGasStation;
				
				if(fuelTankLevel < 0) {
					System.out.println("  Cannot proceed from station:"+startGasStationIndex+" due to insufficient gas");
					terminalCondition  = true;
					break;
				}else {
					int oldGasStationIndex = currentGasStationIndex;
					currentGasStationIndex = (currentGasStationIndex+1)%NumGasStations;
					System.out.println("  We moved from Gas Station:"+oldGasStationIndex+" to "+currentGasStationIndex + 
							" by consuming "+fuelRequiredToReachNextGasStation+" amount to gas, let remain:"+fuelTankLevel+" in tank");
				}
			}while(currentGasStationIndex!=startGasStationIndex);
			
			if(!terminalCondition && currentGasStationIndex == startGasStationIndex) {
				System.out.println("Success: we could reach the starting station by starting at Gas Station Index:"+startGasStationIndex);
				return currentGasStationIndex;
			} 
			
		}
		return -1;
	}

}
