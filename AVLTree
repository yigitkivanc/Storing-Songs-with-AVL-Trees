

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yigit
 */
public class AVLTree<Item> {

    AVLNode<Item> root;

    public AVLTree() {
        root = null;
    }

    public int height(AVLNode<Item> d) {
        if (d == null) {
            return 0;
        } else {
            return d.height;
        }
    }

    //rotate focus. to right. replace it with left child
    public AVLNode<Item> rotateMyLeft(AVLNode<Item> focus) {
        AVLNode<Item> k = focus.left;
        focus.left = k.right;
        k.right = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    //rotate focus left, replace it with right child
    public AVLNode<Item> rotateMyRight(AVLNode<Item> focus) {
        AVLNode<Item> k = focus.right;
        focus.right = k.left;
        k.left = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    public AVLNode<Item> doubleRotateLeftSide(AVLNode focus) {
        focus.left = rotateMyRight(focus.left);
        return rotateMyLeft(focus);
    }

    public AVLNode<Item> doubleRotateRightSide(AVLNode focus) {
        focus.right = rotateMyLeft(focus.right);
        return rotateMyRight(focus);
    }

    // Get Balance factor of node focus
    int getBalance(AVLNode<Item> focus) {
        if (focus == null) {
            return 0;
        }
        return height(focus.left) - height(focus.right);
    }

    public AVLNode<Item> insert(AVLNode focus, Item data, int key) {
        if (focus == null) {
            focus = new AVLNode(data, key);
        } else if (key < focus.key) {
            focus.left = insert(focus.left, data, key);
            if (getBalance(focus) == 2) {
                if (key < focus.left.key) {
                    focus = rotateMyLeft(focus);
                } else {
                    focus = doubleRotateLeftSide(focus);
                }
            }
        } else if (key > focus.key) {
            focus.right = insert(focus.right, data, key);
            if (getBalance(focus) == -2) {
                if (key > focus.right.key) {
                    focus = rotateMyRight(focus);
                } else {
                    focus = doubleRotateRightSide(focus);
                }
            }
        } else {
            // key is equal to focus.key, update data
            focus.data = data;
        }

        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        return focus;
    }

    public void insert(Item data, int key) {

        root = insert(root, data, key);
    }

    public AVLNode firstSearch (AVLNode focus,String songName){
        if (focus == null){
            return null;
        }
        AVLNode rightChild = firstSearch(focus.right,songName);
        if (focus.data.equals(songName)){
            return focus;

        }

        AVLNode leftChild = firstSearch(focus.left,songName);
        if(leftChild != null ) {
            return leftChild;
        }
        else {
            return rightChild;
        }


    }
    public void thirdSearch (AVLNode focus,int upper,int lower,Song[] songArr) {

        while (lower <= upper) {
            String lowStr = Integer.toString(lower);

            if (this.firstSearch(this.root, lowStr) != null) {
                System.out.println(songArr[this.firstSearch(this.root, lowStr).key].toString());

            }else{
                System.out.print("");
            }
            lower++;



        }
    }

    public AVLNode searchRecursive(AVLNode focus, int key) {
        if (focus == null) {
            return null;
        }
        if (focus.key == key) //found return the node
        {
            return focus;
        } else if (key < focus.key) { //check which side to go
            return searchRecursive(focus.left, key);
        } else {
            return searchRecursive(focus.right, key);
        }
    }
    public void traverseLevelOrder(AVLNode focus) {
        if (focus == null) {
            focus = root; // if null is passed. print whole tree
        }
        java.util.LinkedList<AVLNode> que = new java.util.LinkedList<AVLNode>();
        que.add(focus);
        while (!que.isEmpty()) {
            AVLNode d = que.removeFirst();
            if (d.left != null) {
                que.addLast(d.left);
            }
            if (d.right != null) {
                que.addLast(d.right);
            }
            System.out.println(d);
        }
    }

    public int Ceil(AVLNode node, int input) {
        if (node == null) {
            return -1;
        }
        if (node.key == input) {
            return node.key;
        }
        if (node.key < input) {
            return Ceil(node.right, input);
        }
        //if node.key > input
        int ceil = Ceil(node.left, input);

        if (ceil != -1) {
            return ceil;
        } else {
            return node.key;
        }

    }

    public int floor(AVLNode root, int key) {
        if (root == null) {
            return -1;
        }
        if (root.key == key) {
            return root.key;
        }
        if (root.key > key) {
            return floor(root.left, key);
        }
        int floorValue = floor(root.right, key);
        if (floorValue != -1) {
            return floorValue;
        } else {
            return root.key;
        }

    }

    AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    AVLNode deleteNode(AVLNode focus, int key) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (focus == null) {
            return focus;
        }
        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < focus.key) {
            focus.left = deleteNode(focus.left, key);
        } // If the key to be deleted is greater than the 
        // root's key, then it lies in right subtree 
        else if (key > focus.key) {
            focus.right = deleteNode(focus.right, key);
        } // if key is same as root's key, then this is the node 
        // to be deleted 
        else {

            // node with only one child or no child 
            if ((focus.left == null) || (focus.right == null)) {
                AVLNode temp = null;
                if (temp == focus.left) {
                    temp = focus.right;
                } else {
                    temp = focus.left;
                }

                // No child case 
                if (temp == null) {
                    temp = focus;
                    focus = null;
                } else // One child case 
                {
                    focus = temp; // Copy the contents of 
                }                                // the non-empty child 
            } else {

                // node with two children: Get the inorder 
                // successor (smallest in the right subtree) 
                AVLNode temp = minValueNode(focus.right);

                // Copy the inorder successor's data to this node 
                focus.key = temp.key;


                // Delete the inorder successor 
                focus.right = deleteNode(focus.right, temp.key);
            }
        }

        // If the tree had only one node then return 
        if (focus == null) {
            return focus;
        }

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE 
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether 
        // this node became unbalanced) 
        int balance = getBalance(focus);

        // If this node becomes unbalanced, then there are 4 cases 
        // Left Left Case 
        if (balance > 1 && getBalance(focus.left) >= 0) {
            return rotateMyLeft(focus);
        }

        // Left Right Case 
        if (balance > 1 && getBalance(focus.left) < 0) {
            focus.left = rotateMyRight(focus.left);
            return rotateMyLeft(focus);
        }

        // Right Right Case 
        if (balance < -1 && getBalance(focus.right) <= 0) {
            return rotateMyRight(focus);
        }

        // Right Left Case 
        if (balance < -1 && getBalance(focus.right) > 0) {
            focus.right = rotateMyLeft(focus.right);
            return rotateMyRight(focus);
        }

        return focus;
    }



}
