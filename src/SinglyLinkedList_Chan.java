public class SinglyLinkedList_Chan {
    private Node h;
    public Iterator i;
    public SinglyLinkedList_Chan(){
        h = new Node();
        i = new Iterator();
        h.l = null;
        h.next = null;
    }
    public boolean insert(StudentGradeData newListing)
    { Node n = new Node();
        if (n == null) //even though it's never null cuz we just created it, we still need to check for out of memory
            return false;
        else
        { n.next = h.next; //assign n.next to the last node added - equal to the link chain
            h.next = n; //insert n to h.next, h.next data would be equal to Node n data (linking n to h.next, h.next still linked to other objects)
            n.l = newListing.deepCopy(); //extracting info to variable l
            return true; //insert operation success
        }
    }
    public StudentGradeData fetch(String targetKey)
    { Node p = h.next;//assign p to last node added
        while(p != null && !(targetKey.equals(p.l.getClassc()))) //while p doesn't reach to the end of the linkedList && targetkey doesn't equal to data p
        { p = p.next;//jump to the next
        }
        if(p != null)//check if key is found, return deep copy of it
            return p.l.deepCopy();
        else
            return null;
    }
    public boolean delete(String targetKey)
    { Node q = h;//assign q to dumb Node h
        Node p = h.next;//assign p to last node added
        while(p != null && !(targetKey.equals(p.l.getClassc())))
        { q = p;
            p = p.next;
        }
        if(p != null)//if p is found
        { q.next = p.next;//assign next link of q to next of p (skipping p that way)
            return true;
        }
        else//else p wasn't found
            return false;
    }
    public boolean update(String targetKey, StudentGradeData newListing)
    { if(delete(targetKey) == false) //if couldn't delete a targetKey, return false
        return false;
    else if(insert(newListing) == false)//targetKey was found, and trying to insert newListing to the front of Linkedlist
        return false;//out of memory
        return true;//operation success
    }
    public void showAll() {
        Node p = h.next;//set p to the last node added
        while (p != null) {//while not the end of the LinkedList
            System.out.println(p.l.toString());//display the node
            p = p.next;//jump to the next node
        }
    }
    public String fileGrade() {
        String str = "";
        Node p = h.next;//set p to the last node added
        while (p != null) {//while not the end of the LinkedList
            str+=","+ p.l.getClassc()+","+p.l.getGrade();
            p = p.next;//jump to the next node
        }
        str+="\n";
        return str;
    }
    public class Node{
        private StudentGradeData l;
        private Node next;
        public Node(){}
    }
    public class Iterator{
        private Node ip;
        public Iterator(){
            ip = h;
        }
        public void reset(){
            ip = h;
        }
        public boolean hasNext(){
            if(ip.next != null)
                return true;
            else return false;
        }
        public StudentGradeData next(){
            ip = ip.next;
            return ip.l.deepCopy();
        }
        public void set(StudentGradeData newListing){
            ip.l = newListing.deepCopy();
        }
    }
}
