import java.util.*;

class BST{
	
	Node root;
	
	BST(){
		root = null;
	}
	
	
	class Node{
		int data;
		Node left, right;
		
		Node(int x){
			data = x;
			left = right = null;
		}
	}
	
	
	void insert(int key) {
       root = insertRec(root, key);
    }
     
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
	
	
 
    // A utility function to do inorder traversal of BST
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data+ " ");
            inorder(root.right);
        }
    }
	
	void preorder(Node root) {
        if (root != null) {
			System.out.print(root.data+ " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
	
	void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
			System.out.print(root.data+ " ");
        }
    }
 
	
	
	boolean isEmpty(){
		return root==null;
	}
	
	boolean search(Node t, int x){
		boolean found = false;
		while(!found && t!=null){
			if(x > t.data)
				t= t.right;
			else if(x < t.data)
				t = t.left;
			else{
				found =  true;
				break;
			}
		}
		return found;
	}
		
	int countNodes(Node t){
		if(t==null)
			return 0;
		
		int count = 1;
		while(t!=null){
			count+=countNodes(t.left);
			count+=countNodes(t.right);
		}
		return count;
	}
	
	void deleteNode(int x){
		deleteNodeRec(root, x);
	}
	
	Node deleteNodeRec(Node temp,int x){
		
		if(root==null)
			return root;
		
		if(x < temp.data)
			temp.left = deleteNodeRec(temp.left, x);
		else if(x > temp.data)
			temp.right = deleteNodeRec(temp.right, x);
		
		else{
			if(temp.left==null)
				return temp.right;
			else if(temp.right==null)
				return temp.left;
			
			//to find smallest element in right subtree when node has 2 children
			temp.data = minValue(temp.right);
			
			temp.right = deleteNodeRec(temp.right, temp.data);
		}
		return temp;
	}
		
		
	int minValue(Node temp){
		while(temp.left!=null)
			temp = temp.left;
		return temp.data;
	}
	
		
		
}

class BinarySearchTree{
	public static void main(String args[]){
		
		Scanner scan = new Scanner(System.in);
		BST tree = new BST();
		
		char ch;
        /*  Perform tree operations  */
        do    
        {
            System.out.println("\nBinary Search Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete");
            System.out.println("3. search");
            System.out.println("4. count nodes");
            System.out.println("5. check empty"); 
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                tree.insert( scan.nextInt() );           
                break;                          
            case 2 : 
                System.out.println("Enter integer element to delete");
                tree.deleteNode( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ tree.search( tree.root,scan.nextInt() ));
                break;                                          
            case 4 : 
                System.out.println("Nodes = "+ tree.countNodes(tree.root));
                break;     
            case 5 :  
                System.out.println("Empty status = "+ tree.isEmpty());
                break;
				
            default : 
                System.out.println("Wrong Entry \n");
                break;   
            }
			/*System.out.print("\nPost order : ");  
			tree.postorder(tree.root);
            System.out.print("\nPre order : ");
            tree.preorder(tree.root);*/
            System.out.print("\nIn order : ");
            tree.inorder(tree.root);
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');      
		
	}
	
}
