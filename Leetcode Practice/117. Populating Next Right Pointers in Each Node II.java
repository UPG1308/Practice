
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            for(int i = 0; i < size; i++){
                Node node = q.poll();
                node.next = prev;
                prev = node;
                if(node.right != null) q.offer(node.right);
                if(node.left != null) q.offer(node.left);
            }
        }
        return root;
    }
}
