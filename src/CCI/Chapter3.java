package CCI;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Anthony on 2014/6/12.
 */
public class Chapter3 {
    public static void main(String args[]){
        /*ThreeStack s = new ThreeStack();
        s.push(0, 1);
        s.push(1, 1);
        s.push(2, 1);
        s.push(0, 2);
        s.push(0, 3);
        s.push(0, 4);
        int t = s.pop(1);
        s.push(0, 5);
        s.push(1, 10);
        s.push(1, 11);*/
    }

    static class ThreeStack{
        final int size = 10;
        int data[];
        int start[];
        int end[];
        public ThreeStack(){
            data = new int[size];
            start = new int[3];
            end = new int[3];
            start[0] = 0;
            start[1] = size/3;
            start[2] = 2*size/3;
            end[0] = 0;
            end[1] = size/3;
            end[2] = 2*size/3;
        }

        boolean empty(int stack){
            return start[stack] == end[stack];
        }
        public void push(int stack, int item){
            int nextStack = (stack+1)%3;
            if(end[stack] == start[nextStack]){
                if(end[nextStack] == start[(nextStack+1)%3]){
                    //这里只考虑挪后面一个stack，没考虑挪俩
                    return;
                }
                int ptr = end[nextStack];
                while(ptr != start[nextStack]){
                    int prev_ptr = (ptr+size-1)%size;
                    data[ptr] = data[prev_ptr];
                    ptr = prev_ptr;
                }
                start[nextStack]++;
                end[nextStack]++;
            }
            data[end[stack]] = item;
            end[stack]++;
        }
        public int pop(int stack){
            if(empty(stack))
                return -1;
            int e2 = (end[stack]+size-1)%size;
            int item = data[e2];
            end[stack] = e2;
            return item;
        }
    }

    class StackWithMin {
        //可以做的更好：当只有item<=head2.data时才压入min栈
        Node head, head2;
        public StackWithMin(){
            head = null;
            head2 = null;
        }
        public void push(int item){
            Node n1 = new Node(item);
            Node n2 = new Node((head2 != null && head2.data < item)?head2.data:item);
            n1.next = head;
            n2.next = head2;
            head = n1;
            head2 = n2;
        }
        public int pop(){
            int d = head.data;
            head = head.next;
            head2 = head2.next;
            return d;
        }
        public int min(){
            return head2.data;
        }
    }

    class SetOfStacks{
        ArrayList<Stack> stacks = new ArrayList<Stack>();
        public void push(int item){
            int l = stacks.size();
            if(l == 0 || stacks.get(l-1).size() >= 10){
                stacks.add(new Stack());
                l++;
            }
            stacks.get(l-1).push(item);
        }
        public int pop(int item){
            int l = stacks.size();
            if(l == 0)
                return -1;
            int data = stacks.get(l-1).pop();
            if(stacks.get(l-1).size() == 0){
                stacks.remove(l-1);
            }
            return data;
        }
        public int popAt(int idx){
            if(stacks.size() < idx)
                return -1;
            int data = stacks.get(idx-1).pop();
            if(stacks.get(idx-1).size() == 0)
                stacks.remove(idx-1);
            return data;
        }
    }

    class Tower{
        Stack disks = new Stack();
        public void addDisk(int disk){
            disks.push(disk);
        }
        public void moveDist(Tower dest, Tower temp, int count){
            if(count == 1){
                dest.addDisk(disks.pop());
                return;
            }

            this.moveDist(temp, dest, count-1);
            dest.addDisk(disks.pop());
            temp.moveDist(dest, this, count-1);
        }
    }
    public void Hanoi(int size){
        Tower t1 = new Tower();
        Tower t2 = new Tower();
        Tower t3 = new Tower();
        for(int i = 0; i < size; i++)
            t1.addDisk(i);
        t1.moveDist(t3, t2, size);
    }

    class MyQueue{
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        void enqueue(int data){
            stack1.push(data);
        }
        int dequeue(){
           if(stack2.size() > 0){
               return stack2.pop();
           }
           while(stack1.size() > 0){
               stack2.push(stack1.pop());
           }
            if(stack2.size() > 0){
                return stack2.pop();
            }
            else
                return -1;
        }
    }

    public void sort(Stack stack){
        Stack temp = new Stack();
        while(stack.size() > 0){
            int item = stack.pop();
            if(temp.size() == 0){
                temp.push(item);
            }
            else if(temp.peek() > item){
                temp.push(item);
            }
            else{
                while(temp.size() > 0 && temp.peek() < item){
                    stack.push(temp.pop());
                }
                temp.push(item);
            }
        }
        while(temp.size() > 0){
            stack.push(temp.pop());
        }
    }

    enum ANIMAL{CAT, DOG};
    class Animal{
        int order;
        ANIMAL type;
        public Animal(int order, ANIMAL type){
            this.order = order;
            this.type = type;
        }
    }
    class AnimalHouse{
        //最好是猫狗分开队列
        LinkedList<Animal> animals = new LinkedList<Animal>();
        int order = 0;
        public void enqueue(ANIMAL type){
            Animal animal = new Animal(++order, type);
            int i = 0;
            for(; i < animals.size(); i++){
                if(animals.get(i).order < animal.order)
                    break;
            }
            animals.add(i, animal);
        }
        Animal dequeueAny(){
            if(animals.size() == 0)
                return null;
            else{
                return animals.removeFirst();
            }
        }
        Animal dequeueCat(){
            for(int i = 0; i < animals.size(); i++){
                if(animals.get(i).type == ANIMAL.CAT)
                    return animals.remove(i);
            }
            return null;
        }
        Animal dequeueDog(){
            for(int i = 0; i < animals.size(); i++){
                if(animals.get(i).type == ANIMAL.DOG)
                    return animals.remove(i);
            }
            return null;
        }
    }
}
