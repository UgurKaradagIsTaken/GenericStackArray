/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericstackarray;

/**
 *
 * @author apple
 */
public class GenericStackArray<Item>{
    Item[] array;
    int top;
    int size;

    public GenericStackArray(int capacity) {
        array = (Item[]) new Object[capacity];
        top = -1;
        size = 0;
        
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == array.length - 1;
    }
    public void push(Item item) {
        if(!isFull()) {
            item = array[++top];
        }
    }
    public Item pop() {
        Item item = array[top];
        if(!isEmpty()) {
            array[top] = null;
            top--;
        }
        return item;
    }
    public Item peek() {
        if(!isEmpty()) {
            return array[top];
        }
        return null;
    }
    public void printStackRecursive() {
        if(isEmpty()) {
            return;
        }
      Item x = peek();
      pop();
      printStackRecursive();
        System.out.println(x);
        push(x);
    }
    public int productOfBottomTwo() {
        int productTwo = 0;
        GenericStackArray<Integer> s1 = new GenericStackArray<Integer>(array.length - 2);
        for(int i = 0; i < array.length - 2; i++) {
            s1.push((Integer) pop());
        }
        Item lastTwo = pop();
        Item last = pop();
        productTwo = (Integer) lastTwo * (Integer) last;
        push(last);
        push(lastTwo);
        while(!s1.isEmpty()) {
            this.push((Item) s1.pop());
        }
      return productTwo;
    }
    public Item popBottom() {
        GenericStackArray<Item> s1 = new GenericStackArray<Item>(this.array.length - 1);
        while(top != 0) {
            s1.push(pop());
        }
        Item popBottom = pop();
        while(!s1.isEmpty()) {
            this.push(s1.pop());
        }
        return popBottom;
    }
    public static boolean checkPalindrome(String[] s) {
     GenericStackArray<String> s1 = new GenericStackArray<String>(s.length / 2);
     GenericStackArray<String> s2 = new GenericStackArray<String>(s.length / 2);
     for(int i = s.length - 1; i >= s.length; i++) {
         s1.push(s[i]);
     }
     for(int i = 0; i < s.length; i++) {
         s2.push(s[i]);
     }
     boolean isPalindrome = true;
     while(!s1.isEmpty() && !s2.isEmpty()) {
         String s11 = s1.pop();
         String s22 = s2.pop();
         if(!(s11.equals(s22))) {
             isPalindrome = false;
         }
     }
     return isPalindrome;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
