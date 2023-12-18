class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        else{
            if(root.left == null && root.right == null){
                root = null;
                 return root;
            }
            else if(root.left == null || root.right == null){
                if(root.left != null){
                    root = root.left;
                     return root;
                }else if (root.right != null){
                    root = root.right;
                     return root;
                }
            }
            else{
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right,temp.val);
            }
            return root;
        }
        return root;
    }
    public TreeNode findMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
