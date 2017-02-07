/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

/**
 *
 * @author Natsu  Dragneel
 */
public class List {

        Node head;

        static class Node{
            int data;
            Node next;
            Node(int d) {data =  d; next = null;}   // Constructor
        }


        public static void main(String args[]){

           List llist = new List();

           llist.push(1);
           llist.push(2);
           llist.push(3);

            llist.printlist();
            llist.addhead(5);
            llist.append(10);
            System.out.println(llist.head.data+"--head--what the heck is this man");
            //llist.dropNodeAtKey(10);
            //llist.dropNodeAtPosition(3);
            System.out.println(llist.listLength(llist.head));
            System.out.printf("Location of %d is %d\n", 5,llist.searchList(5));
            llist.printlist();
            System.out.println("on swapping 3 and 1");
            llist.swapNodes(5, 10);
            llist.printlist();
            llist.head = llist.reverseList(llist.head);
            llist.printlist();

        }


        public void push(int new_data){
            Node new_node = new Node(new_data);
            new_node.next = head;
            head = new_node;
        }


        public  void printlist(){
            Node n = head;
            while(n!=null){
                System.out.print(n.data+" ");
                n = n.next;
            }
            System.out.println();
        }


        public void addhead(int new_data){
            Node new_node  =  new Node(new_data);
            new_node.next = head;
            head = new_node;
        }


        public void addnode(int new_data,Node prev){
            Node new_node = new Node(new_data);
            new_node.next = prev.next;
            prev.next =  new_node;
        }


        public void append(int new_data){
            if(head==null){
                head.data = new_data;
                head.next = null;
            }
            // to find last node
            Node n = head;
            while(n.next!=null){
                n = n.next;
            }

            Node newNode = new Node(new_data);
            n.next = newNode;
        }


        public void dropNodeAtKey(int key){
            // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key)
        {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key){
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) return;

        // Unlink the node from linked list
        prev.next = temp.next;
          
            
        }


        public  void dropNodeAtPosition(int pos){
            if(head==null)
                return;

            Node temp = head;

            if(pos==0){
                head = temp.next;
                return;
            }

            for(int i=1; temp!=null && i<pos; i++ )
                temp = temp.next;               // get node before position to be deleted

            if(temp == null || temp.next==null)     // in case position > list length
                return;
                
            Node next = temp.next.next;     //taking next as addr of node next to next of temp since node after temp is to be deleted
            
            temp.next = next;       // cutting off the node

        }


        public int listLength(Node start){
            int count;
            Node temp  = start;
            for(count = 1; temp.next!=null; count++)
                temp = temp.next;

            return count;
        }


        public void swapNodes(int a, int b){

            if(a==b)return;

            //searching 'a' keeping track of prev node
            Node curX = head,prevX = null;
            while(curX.data!=a && curX.next!=null){
                prevX = curX;
                curX = curX.next;
            }

            //searching 'b' keeping track of prev node
            Node curY = head,prevY = null;
            while(curY.data!=b && curY.next!=null){
                prevY = curY;
                curY = curY.next;
            }

            // in case either a or b is not present
            if(curX==null||curY==null)return;

            //if a is not head of the list
            if(prevX!=null)
                prevX.next = curY;
            else head = curY;

            // if b is not head of the list
            if(prevY!=null)
                prevY.next = curX;
            else head = curX;

            // swapping FINALLY!!
            Node temp = curX.next;
            curX.next = curY.next;
            curY.next =temp;
        }


        public int searchList(int data){
            Node temp = head,prev= null;
            int index=0;
            while(temp.data!=data&&temp.next!=null){
                prev = temp;
                temp = temp.next;
                index++;
            }
            return index;
        }


        public static Node reverseList(Node start){
            Node prev = null;
            Node cur = start;
            Node next = null;

            while(cur!=null){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            start = prev;
            return start;
        }



}