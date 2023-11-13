class MyStack 
{
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }   
    StackNode top;
    //Function to push an integer into the stack.
    void push(int a) 
    {
        // Add your code here
        StackNode temp = new StackNode(a);
        temp.next = top;
        top = temp;
        
    }
    
    //Function to remove an item from top of the stack.
    int pop() 
    {
        // Add your code here
        if(top == null){
            return -1;
        }
        StackNode temp = top;
        top = temp.next;
        temp.next = null;
        return temp.data;
        
    }
}
