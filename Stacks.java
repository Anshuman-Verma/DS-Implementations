/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;
/**
 *
 * @author Natsu  Dragneel
 */
import java.util.Stack;
import java.util.*;
public class Stacks {

    public static void main(String args[]){
        Stack st = new Stack();
        boolean a = st.empty();
        st.push(10);
        st.push(11);
        st.push(12);
        System.out.println(st.peek());
        System.out.println(st.indexOf(10));
        System.out.println(st.search(12));
        System.out.println(st.size());
        System.out.println(st.pop());
        System.out.println(revStr("abcd"));
    }

    public static String revStr(String s){
        String a = "";
        Stack<String> tmp =  new Stack<String>();
        for(int i = 0; i<s.length(); i++)
            tmp.push(s.substring(i,i+1));

        while(!tmp.isEmpty()){
            a  += tmp.pop();
        }
        return a;
    }

}