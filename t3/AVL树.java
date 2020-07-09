

public class AVL树  {
    public Node root = null;


    //===================================================
    //插入AVL树
    public void insert(int key){
        if(root == null){
            root = new Node(key,null);
            return;
        }

        Node cur = root;
        Node parent = null;
        while(cur!= null){
            if(key==(cur.key)){
                throw new RuntimeException("key重复了  "+key);
            }
            else if(key<cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }

        //找到null的位置，插入
        if(key<parent.key){
            parent.left = new Node(key,parent);
            cur = parent.left;
        }else{
            parent.right = new Node(key,parent);
            cur = parent.right;
        }



        while(true){
            //更新parent的平衡因子
            if(cur ==parent.left){
                parent.bf++;
            }else{
                parent.bf--;
            }
            //分情况处理，处理结束全都是break
            if(parent.bf==0){
                break;
            }else if(parent.bf==2){
                //修复 左左或者左右

                if(cur.bf==1){
                    //左左
                   fixll(parent);
                }else{
                    //左右
                    fixlr(parent);
                }
                break;
            }else if(parent.bf==-2){
                //修复 右右 或 右左
                if(cur.bf==-1){
                    //右右
                    fixrr(parent);
                }else{
                    //右左
                    fixrl(parent);
                }
                break;
            }else if(parent ==root){
                //到根
                break;
            }

            //若未处理，需要继续向上蔓延
            cur = parent;
            parent = cur.parent;
        }


    }

  //=======================================================================

    //左旋
    private void leftRotate(Node parent){
        Node cur = parent.right;
        Node pp = parent.parent;
        Node cc = cur.left;

        //1.使cur的父为p父，使p父的子节点变成cur
        if(pp!=null){
            if(parent==pp.left){
                pp.left = cur;
                cur.parent = pp;
            }else{
                pp.right = cur;
                cur.parent = pp;
            }
        }else{
            root = cur;//将root更新为cur
            cur.parent =null;
        }

        //2.使cur左变成p右
        if(cc!=null){
            parent.right = cc;
            cc.parent = parent;
        }else{
            parent.right =null;
        }



        //3.使p的父为cur,使cur的子为p
        parent.parent = cur;
        cur.left = parent;


    }

    //===================================================
    private void rightRotate(Node parent){
        Node pp = parent.parent;
        Node cur = parent.left;
        Node cc = cur.right;


        //1.p、cur和 pp的父子关系
        if(pp!=null){
            if(parent==pp.left){
                pp.left = cur;
                cur.parent = pp;
            }else{
                pp.right = cur;
                cur.parent = pp;
            }
        }else{
            root = cur;
            cur.parent =null;
        }

        //2.cur 和p的父子关系
        cur.right = parent;
        parent.parent = cur;

        //3.cc和p的父子关系
        if(cc!=null){
            parent.left = cc;
            cc.parent = parent;
        }else{
            parent.left=null;
        }
    }
    //=====================右左==============================
    private void fixrl(Node parent) {
        Node node = parent;
        Node right = parent.right;
        Node left = right.left;

        rightRotate(right);
        leftRotate(parent);

        if(left.bf==1){
            node.bf =0;
            right.bf=-1;
            left.bf =0;
        }else if(left.bf==-1){
            node.bf =1;
            right.bf=0;
            left.bf =0;
        }else{
            node.bf =0;
            left.bf =0;
            right.bf=0;
        }
    }

    //====================左右===============================
    private void fixlr(Node parent) {
        Node node = parent;
        Node left = parent.left;
        Node right = left.right;

        leftRotate(left);
        rightRotate(parent);

        if(right.bf==1){
            node.bf =-1;
            left.bf =0;
            right.bf=0;
        }else if(right.bf==-1){
            node.bf =0;
            left.bf =1;
            right.bf=0;
        }else{
            node.bf =0;
            left.bf =0;
            right.bf=0;
        }
    }

    //=====================右右==============================
    private void fixrr(Node parent) {
        Node node = parent;
        Node right = parent.right;

        leftRotate(parent);
        node.bf = right.bf =0;
    }

    //======================左左=============================
    private void fixll(Node parent) {
        Node node = parent;
        Node left = parent.left;

        rightRotate(parent);
        node.bf = left.bf =0;
    }

    //===================================================
    //在AVL树中查找对应的key
    public boolean contains(int key){
        Node cur = root;
        while(cur!= null){
            if(key==(cur.key)){
                 return true;
            }
            else if(key<cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;            }
        }
        return false;
    }


}
