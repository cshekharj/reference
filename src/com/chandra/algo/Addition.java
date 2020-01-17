/**
 * 
 */
package com.chandra.algo;

/**
 * @author Shekhar
 *
 */
public class Addition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array2 = {1,2,3,5,6,6,7,7,8,8};
		int[] array1 = {1,2,3};
		Addition addition = new Addition();
		addition.addNumbers(array1, array2);
		addition.addNums(array1, array2);
		
	}
	
	public void addNumbers(int[] array1, int[] array2){
		
		int[] result = new int[0];
		printArray(array1);
		printArray(array2);
		System.out.println();
		if(array1.length >= array2.length)
			result=addNumbersInArrays(array1, array2);
		else
			result=addNumbersInArrays(array2, array1);
		System.out.println();
		for(int i:result)
			System.out.print(i);
	}

	private void printArray(int[] array1) {
		System.out.println("array1->"+array1.length);
		System.out.println("--------");
		for(int c:array1)
			System.out.print(c);
		System.out.println();
		System.out.println("--------");
	}

	private void addNums(int[] array1, int[] array2){
		StringBuffer arr1 = new StringBuffer(), arr2=new StringBuffer();
		int result=0;
		for(int i:array1)
			arr1.append(i);
		for(int i:array2)
			arr2.append(i);
		
		result=Integer.parseInt(arr1.toString())+Integer.parseInt(arr2.toString());
		System.out.println("--------result-----"+result);
		
	}
	/**
	 * @param array1
	 * @param array2
	 * @param carry
	 * @param result
	 * @return
	 */
	private int[] addNumbersInArrays(int[] bigArray, int[] smallArray)  {
		int value=0;
		int[] result= new int[bigArray.length];;
		
		int carry=0;
		for(
			int i=bigArray.length-1,
			j=smallArray.length-1,
			k=result.length-1;k>-1;i--,j--,k--){
			//get place value;
			if(j>-1){ // first add all small array and big array elements with carry over
				System.out.println("<---------------->");
				System.out.println("i->"+i);
				System.out.println("j->"+j);
				System.out.println("k->"+k);
				System.out.println("carry-"+carry);
				System.out.println("bigArray[i]-"+bigArray[i]);
				System.out.println("smallArray[j]-"+smallArray[j]);
				value=bigArray[i]+smallArray[j]+carry;
				System.out.println("value-"+value);
				if(value>10){
					value=value%10;
					carry=1;
				}else if(value == 10){
					value=0;
					carry=1;
				}else
					carry=0;
				
				System.out.println("carry-"+carry);
				System.out.println("remainder-"+value);
				result[k]=value;
				System.out.println("result[k]->"+result[k]);
				printArray(result);
			}
			else if(i>-1){ // add remaining elements from big array 
					System.out.println("i->"+i);
					System.out.println("j->"+j);
					System.out.println("k->"+k);
					System.out.println("array1[i]-"+bigArray[i]);
					System.out.println("result[k]-"+result[k]);
					
					value=bigArray[i]+carry;
						
					if(value>10){
						value=value%10;
						carry=1;
					}else if(value == 10){
						value=0;
						carry=1;
					}else
						carry=0;
					
					result[k]=value;
					System.out.println("result[k]-"+result[k]);
					System.out.println("carry-"+carry);
					printArray(result);
						
			}
			else{ //add carry is any
				result[k]=carry;
			}
		}
		return result;
	}

}
