/*** 第二题 
2、创建指针链表；数据就是整数；随机产生
    实现查找、新增、修改、删除功能. ***/

public class Node {/*节点类*/  
   private int data;        /*节点数据*/  
   private Node node_next; /*节点的下一个节点*/  
   public Node(){ /*节点构造函数*/  
        this.data = (int)(Math.random()*100+10);  
        node_next = null;  
    }  
    public Node getNode_next(){/*获取节点的下一个节点*/  
        return node_next;  
    }  
    public void printNode(Node n){  /*输出节点数据*/  
        Node a = n;
        int i = 0;
        while( a.node_next != null){
            System.out.print(a.data+" ");
            a = a.node_next;
        }
        System.out.println();
    } 
    //查找
    public int sort1(int number, Node n){
        int num = 1;
        Node p = n;
        while(p.node_next != null && num != number){
            p = p.node_next;
            num++;
        }
        return p.data;
    } 

    public Node sort2(int number, Node n){
        int num = 1;
        Node p = n;
        while(p.node_next != null && num != number){
            p = p.node_next;
            num++;
        }
        return p;
    } 

    //修改
    public void change(int num, Node n, int s){
        Node a = n.sort2(num, n);
        a.data = s;

    }

    //删除
    public void delete(int num, Node n){
        Node a = sort2(num-1, n);
        if(a.node_next.node_next == null){
            a.node_next = null;
        }
        else{
            Node p = a;
            p = p.node_next.node_next;
            a.node_next = p;
        }
    }

    public static void main(String[] args ){
        Node n1 = new Node();
        Node n = n1;
        int i = 0;
        while( i < 10){
            Node nn = new Node();
            n.node_next = nn;
            n = nn;
            i++;
        }
        n1.printNode(n1);
        System.out.println(n1.sort1(5,n1));
        n1.change(4, n1, 1000);
        n1.printNode(n1);
        n1.delete(10,n1);
        n1.printNode(n1);
        
    }
}  