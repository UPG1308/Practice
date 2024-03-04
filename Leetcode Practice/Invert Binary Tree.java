class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        swapChild(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public void swapChild(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

======================================================


  class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            swapChild(node);
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        return root;
    }
    public void swapChild(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
