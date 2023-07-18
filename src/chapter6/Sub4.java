package chapter6;

public class Sub4 {

	private int[][] grades;
	/*
	 * Multidimensional array. Two-dimensional in this case. We create an array 3 by
	 * 5 (3 rows, 5 columns, unlike x and y-axis, here is swapped. This array looks
	 * like this
	 * 
	 * xxxxx
	 * 
	 * xxxxx
	 * 
	 * xxxxx
	 */

	public void copyArray(int[][] original) {
		grades = new int[original.length][original[0].length];
		for (int i = 0; i < original.length; i++)
			for (int ii = 0; ii < original[0].length; ii++)
				grades[i][ii] = original[i][ii];
	}
	/*
	 * This method copies an array. Array, whether one-dimensional or
	 * multidimensional. it can be a parameter to the method, same as it can be a
	 * return type. arrayname.length returns the length of an array, it is, number
	 * of rows. arrayname[0].length returns a length of an array as columns number.
	 * 2-dimensional array is like an array of arrays. original[0] is an array that
	 * has another array in it. Whether it is [0] or any other indexed number. The
	 * returned length will be the same cuz all indexed variables has an array of
	 * the same size.
	 */

    public static void main(String[] args) {

		int[][] raggedArray = new int[3][];
		raggedArray[0] = new int[2];
		raggedArray[1] = new int[5];
		raggedArray[2] = new int[4];
		/*
		 * This is an example of a ragged array. It looks like this:
		 * 
		 * xx
		 * 
		 * xxxxx
		 * 
		 * xxxx
		 * 
		 * It is an irregular array; raggedArray has length of 3, three instances of
		 * inside array. Array 0 has an array size 2, array 1 has an array of size 5,
		 * and array 2 has an array of size 4.
		 */
	}
}
