//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TwoSumRecursion {
    
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> numList = getNumsFromTree(root);
        int firstNum;
        int secondNum;
        for(int i = 0; i < numList.size(); i++) {
            firstNum = numList.get(i);
            for(int j = numList.size() - 1; j >= 0; j--) {
                if(i == j) break;
                secondNum = numList.get(j);
                if(firstNum + secondNum == k) {
                    return true;
                }
                
            }
        }
        return false;
    }
    
    public List<Integer> getNumsFromTree(TreeNode root) {
        ArrayList<Integer> numList = new ArrayList<>();
        addToList(numList, root);
        return numList;
        
    }
    
    void addToList(ArrayList<Integer> list, TreeNode root) {
        if(root.left != null) {addToList(list, root.left);}
        list.add(root.val);
        if(root.right != null) {addToList(list, root.right);}
    }
}
