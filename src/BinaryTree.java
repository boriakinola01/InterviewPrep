public class BinaryTree {

    TreeNode root;

    class TreeNode{
        int data;

        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data = data;
        }

        // recursive insertion
        public void insert(int value){
            if(data <= value){
                if(leftChild == null)
                    leftChild = new TreeNode(value);
                else leftChild.insert(value);
            } else {
                if(rightChild == null)
                    rightChild = new TreeNode(value);
                else rightChild.insert(value);
            }
        }
    }

    // non-recursive insertion
    public void addNode(int data){
        TreeNode newNode = new TreeNode(data);

        if(root == null){
            root = newNode;
        } else {
            TreeNode focusNode = root;
            TreeNode parent;

            while(true){
                parent = focusNode;
                if(data < focusNode.data){
                    focusNode = focusNode.leftChild;
                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if(focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraversal(TreeNode focusNode){
        if (focusNode != null){
            inOrderTraversal(focusNode.leftChild);

            System.out.println(focusNode);

            inOrderTraversal(focusNode.rightChild);
        }
    }

    public void preOrderTraversal(TreeNode focusNode){
        if (focusNode != null){

            System.out.println(focusNode);

            preOrderTraversal(focusNode.leftChild);

            preOrderTraversal(focusNode.rightChild);
        }
    }

    public void postOrderTraversal(TreeNode focusNode){
        if (focusNode != null){

            postOrderTraversal(focusNode.leftChild);

            postOrderTraversal(focusNode.rightChild);

            System.out.println(focusNode);
        }
    }

    public TreeNode findNode(int data){
        TreeNode focusNode = root;

        while(focusNode.data != data){

            if(data < focusNode.data){
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null)
                return null;
        }

        return focusNode;
    }

    public TreeNode invertTree(TreeNode root){
        if(root == null)
            return null;

        TreeNode right = invertTree(root.rightChild);
        TreeNode left = invertTree(root.leftChild);

        //swap
        root.rightChild = left;
        root.leftChild = right;

        return root;
    }

}


