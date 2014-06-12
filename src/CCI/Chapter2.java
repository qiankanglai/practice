package CCI;

import java.util.Stack;

/**
 * Created by Anthony on 2014/6/11.
 */
public class Chapter2 {
    public static void main(String args[]){
    }

    //2.1
    public void removeDuplicates(Node head){
        while(head != null){
            Node p_prev = head, p = head.next;
            while(p != null){
                if(head.data == p.data){
                    p = p.next;
                    p_prev.next = p;
                }
                else{
                    p_prev = p;
                    p = p.next;
                }
            }
            head = head.next;
        }
    }

    //2.2
    public Node nthToLast(Node head, int k){
        if(k <= 0) return null;

        Node p = head;
        for(int i = 0; i < k; i++) {
            if(p == null)
                return null;
            p = p.next;
        }
        while(p != null){
            head = head.next;
            p = p.next;
        }
        return head;
    }

    //2.3
    public boolean deleteNode(Node p){
        if(p == null)
            return false;
        if(p.next == null)
            return false;
        p.data = p.next.data;
        p.next = p.next.next;
        return true;
    }

    //2.4
    public Node partition(Node head, int x){
        if(head == null)
            return null;

        Node head1 = null, head2 = null, p1 = null, p2 = null;
        Node p = head;
        while(p != null){
            if(p.data < x){
                if(p1 == null){
                    p1 = p;
                    head1 = p;
                }
                else{
                    p1.next = p;
                    p1 = p;
                }
            }
            else{
                if(p2 == null){
                    p2 = p;
                    head2 = p;
                }
                else{
                    p2.next = p;
                    p2 = p;
                }
            }
            p = p.next;
        }
        if(p1 != null)
            p1.next = null;
        if(p2 != null)
            p2.next = null;
        if(head1 == null)
            return head2;
        else{
            p1.next = head2;
            return head1;
        }
    }

    //2.5
    public Node addList(Node l1, Node l2){
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;

        boolean advance = false;
        Node head = null, p = null;
        while(l1 != null || l2 != null){
            int t = (advance?1:0);
            if(l1 != null){
                t += l1.data;
                l1 = l1.next;
            }
            if(l2 != null){
                t += l2.data;
                l2 = l2.next;
            }
            Node q = new Node(t%10);
            advance = (t>=10);
            if(p == null){
                head = q;
                p = q;
            }
            else{
                p.next = q;
                p = q;
            }
        }
        if(advance){
            p.next = new Node(1);
        }
        return head;
    }
    class LinkedListNodeWithAdvance{
        Node node;
        boolean advance;
        public LinkedListNodeWithAdvance(Node n, boolean a){
            node = n;
            advance = a;
        }
    }
    public LinkedListNodeWithAdvance dfsAddList(Node l1, Node l2){
        if(l1 == null || l2 == null)
            return null;
        LinkedListNodeWithAdvance n = dfsAddList(l1.next, l2.next);
        int t = l1.data+l2.data;
        if(n != null && n.advance)
            t++;
        LinkedListNodeWithAdvance n2 = new LinkedListNodeWithAdvance(new Node(t%10),t>=10);
        if(n != null)
            n2.node.next = n.node;
        return n2;
    }
    public Node addList2(Node l1, Node l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        int len1 = 0, len2 = 0;
        Node p = l1;
        while(p != null){
            len1++;
            p = p.next;
        }
        p = l2;
        while(p != null){
            len2++;
            p = p.next;
        }

        //padding
        if(len1 < len2){
            Node n = null, n_head = null;
            for(int i = 0; i < len2-len1; i++){
                Node n2 = new Node(0);
                if(n == null){
                    n = n2;
                    n_head = n2;
                }
                else{
                    n.next = n2;
                    n = n2;
                }
            }
            n.next = l1;
            l1 = n_head;
            len1 = len2;
        }
        else if(len1 > len2){
            Node n = null, n_head = null;
            for(int i = 0; i < len1-len2; i++){
                Node n2 = new Node(0);
                if(n == null){
                    n = n2;
                    n_head = n2;
                }
                else{
                    n.next = n2;
                    n = n2;
                }
            }
            n.next = l2;
            l2 = n_head;
            len2 = len1;
        }

        LinkedListNodeWithAdvance r = dfsAddList(l1, l2);
        if(r.advance){
            Node n = new Node(1);
            n.next = r.node;
            return n;
        }
        else
            return r.node;
    }

    //2.6
    public Node findCycle(Node head){
        if(head == null)
            return null;
        Node p = head, q = head.next;
        while(p != q){
            p = p.next;
            if(q == null)
                return null;
            q = q.next;
            if(q == null)
                return null;
        }
        //当新的重新走到环入口的时候，老的必定在环入口！
        q = head;
        while(p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }

    //2.7
    public boolean isPalindrome(Node head){
        if(head == null)
            return false;
        int len = 0;
        Node p = head;
        while(p != null){
            len++;
            p = p.next;
        }

        Stack<Integer> stack = new Stack<Integer>();
        p = head;
        for(int i = 0; i < len/2; i++){
            stack.push(p.data);
            p = p.next;
        }
        if(len % 2 == 1){
            p = p.next;
        }
        while(p != null){
            if(stack.pop() != p.data)
                return false;
            p = p.next;
        }

        return true;
    }
}
