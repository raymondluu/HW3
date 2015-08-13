public class HW3 {

	public static int inversion(int []inputs)
	{
	//add your code for Q1 here
		int inversions = 0;
		
		// loop through every number
		for (int i = 0; i < inputs.length; i++)
		{
			// loop through every number that is ahead of the first number
			for (int j = i + 1; j < inputs.length; j++)
			{
				// if data in first index is greater than data in second index then it is
				// out of order and add count to inversion.
				if (inputs[i] > inputs[j])
				{
					inversions++;
				}
			}
		}
		return inversions;
	}

	public static boolean isBinarySearchTree(TreeNode root)
	{
	//add your code for Q2 here.
		boolean valid = false;
		
		// Leaf case therefore BinarySearchTree is present
		if (root.left == null && root.right == null)
		{
			valid = true;
		}
		// Not leaf case so test to see if left and right child are in order.
		else
		{
			if (root.left != null)
			{
				// go to the left child node of current node
				valid = isBinarySearchTree(root.left);
			}
			if (root.right != null)
			{
				// go to the right child node of current node
				valid = isBinarySearchTree(root.right);
			}
			// test if data is out of order.
			if (root.left.data > root.data || root.right.data < root.data)
			{
				valid = false;
			}
		}
		return valid;
	}
	public static int maxSum(TreeNode root)
	{
		//add your code for Q3 here.
		// used two separate helper methods to divide up task
		// returns the max of the two tasks max value
		return Math.max(maxSumHelper1(root), maxSumHelper2(root));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//I will take care of the test part. 

	}
	
	// finds cross paths of each node and gives max sum received from all the nodes then
	// returns that value
	private static int maxSumHelper1(TreeNode root)
	{
		int cross = 0;
		int left = 0;
		int right = 0;
		
		// Leaf case max is the current root
		if (root == null)
		{
			cross = 0;
		}
		// Not leaf case so go to left and right child.
		else
		{
			left = maxSumHelper1(root.left);
			right = maxSumHelper1(root.right);
			if (root.left != null || root.right !=null)
			{
				cross = root.data + root.left.data + root.right.data;
			}
			else
			{
				cross = root.data + left + right;
			}
		}
		return Math.max(cross, Math.max(left, right));
	}
	
	// finds the path from parent to leaf or from any other node
	// to leaf with the max sum and returns it
	private static int maxSumHelper2(TreeNode root)
	{
		int max_path = 0;
		int left = 0;
		int right = 0;
		
		// Leaf case max is the current root
		if (root == null)
		{
			max_path = 0;
		}
		// Not leaf case so go to left and right child.
		else
		{
			left = Math.max(maxSumHelper2(root.left), 0);
			right = Math.max(maxSumHelper2(root.right), 0);
			max_path = root.data + Math.max(left,  right);

		}
		return Math.max(max_path, Math.max(left, right));
	}

}