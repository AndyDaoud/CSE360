package cse360assign2;

/* Andy Daoud
 * CSE 360
 * Project 1
 * ID: 103
 * 
 * This is a program that involves manipulating a simple array of up to 10
 * numbers.  It instantiates a list; can add, remove and count numbers within;
 * searches for numbers; and can return the array as a string.
 */



public class SimpleList {
	private int list[];
	private int count;
	private int maxcount = 10;
	
	
//Create empty array with 10 elements
	public SimpleList() {
		this.count = 0;
		list = new int[10];
	}
	
/*
 * Increases the size of the array
 */
	public void increaseArraySize() {
		int newsize = (count + (count/2));
		int newList[] = new int[newsize];					//creates a temporary new list of the new size
		for(int index = 0; index < list.length; index++) {
			newList[index] = list[index];
		}
		list = newList;										//sets original list to equal the new list
		maxcount = newsize;
	}
	
/*
 * Decreases the size of the array
 */
	public void decreaseArraySize() {
		int newsize = count;
		int newList[] = new int[newsize];					//creates temporary list of new size
		for(int index = 0; index < count; index++) {
			newList[index] = list[index];
		}
		list = newList;										//sets original list to equal new list
		maxcount = newsize;
	}
	
/*
 * Add an element to beginning of list, shifting stored elements to the right
 * and increasing the count for each added number unless count is already at 10.
 */
	public void add(int number) {
		if(count == 0) {
			list[0] = number;  								//if count is 0, you only need to add the number in
			count++;
		} else if(count < maxcount) {
			for(int index = count; index >= 0; index--) {
				list[index+1] = list[index];  				//if count isn't 0, the other numbers must be shifted first
			}
			list[0] = number;
			count++;
		} else {
			increaseArraySize();							//increase list size if count is 
			for(int index = count; index >= 0; index--) {
				list[index+1] = list[index];  				
			}
			list[0] = number;	
			count++;
		}
	}
	
/*
 * Removes an element from list, shifting remaining elements left
 * and reducing the count by 1 per removed element.
 */
	public void remove(int num) {
		int index = 0;
		boolean numfound = false;
		while(index < count && numfound == false) {
			if(list[index] == num) {  				//when the number is found, shifting is started at it's position
				for(int ind = index; ind < count; ind++) {
					list[ind] = list[ind + 1];
				}
				count--;
				numfound = true;
			}
			index++;
		}
		if(count < (maxcount - (maxcount/4)) && (count > 0)) {
			decreaseArraySize();    				//reduce list size if more than 25% empty.
		}
	}
	
//Returns number of elements in list.
	public int count() {
		return count;
	}
	
//Returns the list of elements as a string.
	public String toString() {
		String listString = "";
		for(int index = 0; index < count; index++) {  //Empty string is created, numbers from string are added to it.
			listString = listString + list[index];
			if(index < count) {
				listString = listString + " ";        //Unless at final element, a space is added after each number.
			}
		}
		return listString;
	}
	
/*
 *Returns the position of a given number within the list.
 *Returns -1 if given number not in list
 */
	public int search(int number) {
		int numposition = -1;						  //numposition defaults at -1, only changing if it finds given number
		for(int index = 0; index < count; index++) {   
			if(list[index] == number) {
				numposition = index;
			}
		}
		return numposition;
	}
	
/*
 * Adds a number to the end of the list.  Increases the array size
 * if the array is already full.	
 */
	public void append(int number) {
		if(count == maxcount) {
			increaseArraySize();
		}
		list[count] = number;
		count++;
	}
	
/*
 * Returns the first number in the list.  If list is empty, returns -1.
 */
	public int first() {
		if(count > 0) {
			return list[0];
		} else {
			return -1;
		}
	}
	
/*
 * Returns the last number in the list.  If list is empty, returns -1.
 */
	public int last() {
		if(count > 0) {
			return list[count-1];
		} else {
			return -1;
		}
	}
	
/*
 * Returns the maximum size of the list.
 */
	public int size() {
		return maxcount;
	}
}
