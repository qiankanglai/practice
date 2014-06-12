package CCI;

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
}
