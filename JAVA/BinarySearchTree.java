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
    void inorder(Node temp) {
        if (temp != null) {
            inorder(temp.left);
            System.out.print(temp.data+ " ");
            inorder(temp.right);
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
		
		// no child present
		if(root==null)
			return root;
		
		if(x < temp.data)
			temp.left = deleteNodeRec(temp.left, x);
		else if(x > temp.data)
			temp.right = deleteNodeRec(temp.right, x);
		
		else{
			
			//  case when only a single child is present
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
	
	int maxValue(Node temp){
		while(temp.right!=null)
			temp  = temp.right;
		return temp.data;
	}
	
	
	// a function to return the INORDER predecessor Node and successor Node of a key,  in case key is not present in the tree this prints the value within this node should lie.
	
	Node pre = new Node(-1), suc =  new Node(-1); // Nodes to store predecessor and successor
	
	void findPreSuc(Node temp, int key){
		
		if(temp==null)
			return;
		
		//  key is found !
		if(temp.data==key){
	
			//max value in left subtree is predecessor
			if(temp.left!=null){
				Node trav = temp.left;
				do{
					pre = trav;
					trav = trav.right;
				}
				while(trav.right!=null);
			}
			
			// min value in right subtree is successor
			if(temp.right!=null){
				Node trav = temp.right;
				do{
					suc = trav;
					trav = trav.left;
				}
				while(trav.left!=null);
			}
			return;
		}
		
		
		// when key is greater than temp's key, go to right subtree
		if(temp.data < key){
			pre = temp;
			findPreSuc(temp.right, key);
		}
		
		
		// else go to right subtree
		else {
			suc =  temp;
			findPreSuc(temp.left, key);
		}
		 
		
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
			System.out.println("6. display predecessor & successor"); 

 
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
				
			case 6 :  
				try{
				tree.findPreSuc(tree.root, scan.nextInt() );
				if(tree.pre!=null && tree.suc!=null)
					System.out.println( "Predecessor: " + tree.pre.data + "\n Successor: " +tree.suc.data);
				else if(tree.pre!=null)
					System.out.println( "Predecessor: " + tree.pre.data);
				else if(tree.suc!=null)
					System.out.println( "Successor: " + tree.suc.data);
				else 
					System.out.println( "No predecessor or successor");
				}
				catch(Exception e){
					System.out.println("something wrong");
				}
                break;
				
            default : 
                System.out.println("Wrong Entry \n");
                break;   
            }
			System.out.print("\nPost order : ");  
			tree.postorder(tree.root);
            System.out.print("\nPre order : ");
            tree.preorder(tree.root);
            System.out.print("\nIn order : ");
            tree.inorder(tree.root);
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');      
		
	}
	
}
