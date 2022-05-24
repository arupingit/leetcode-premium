package com.arup.leetcodePremium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *  
 * @author arupdutta
 *
 */
public class MeetingRooms {

	public static void main(String[] args) {
		int[][] input1 = {{0,30},{5,10},{15,20}};
		int[][] input2 = {{7,10},{2,4}};
		MeetingRooms mr = new MeetingRooms();
		System.out.println(mr.meetingRoomCheck(input1));
		System.out.println(mr.meetingRoomCheck(input2));
	}

	private boolean meetingRoomCheck(int[][] input){
		Arrays.sort(input,new CompareMeetings());
		for(int i = 1;i<input.length;i++){
			if(input[i-1][1] > input[i][0]){
				return false;
			}
		}
		return true;
	}
	
	private class CompareMeetings implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			int[] i1 = (int[]) o1;
			int[] i2 = (int[]) o2;
			return (i1[0] - i2[0]);
		}
	}
}
