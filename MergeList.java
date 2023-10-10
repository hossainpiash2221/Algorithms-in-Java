package mergelist;

class node {

    int data;
    node next;

    node(int val) {
        this.data = val;
        this.next = null;
    }
}

class linkedlist {

    node head;

    linkedlist() {
        this.head = null;
    }

    public node findMid(node head) {
        node slow = head;
        node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public node mergesort(node head) {
        if (head == null || head.next == null) {
            return head;
        }
        node mid = findMid(head);
        node left = head;
        node right = mid.next;
        mid.next = null;

        left = mergesort(left);
        right = mergesort(right);

        node result = Merge(left, right);

        return result;
    }

    public node Merge(node left, node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        node ans = new node(-1);
        node temp = ans;

        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            } else {
                temp.next = right;

                right = right.next;
                temp = temp.next;

            }

        }
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;

            right = right.next;
            temp = temp.next;
        }

        return ans.next;
    }

    public void insertLast(int val) {
        node newNode = new node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void display() {   //1 2 3 4 5
        node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}

public class MergeList {

    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        int a[] = {10, 3, 2, 4, 6, 3};
        for (int i = 0; i < a.length; i++) {
            list.insertLast(a[i]);

        }
        list.head = list.mergesort(list.head);
        list.display();

    }

}
