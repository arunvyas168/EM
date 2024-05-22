package Tree;


/*
    SOLUTION:
        TLDR: Use a set  to store path to root from one and check for another

        1. Take node p and go all the way to root (basically parent is null)
        2. store in set
        3. take node q and go all the way to root but also keep checking set
        Note: to traverse do p = p.parent ---> while (p != null)
*/


public class LcaParent {

/*
Use a set to store visited
traverse both all the way to parent
check if there are any intersection

    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        while(p!=null){
            set.add(p);
            p = p.parent;
        }
        while(q!=null){
            if(set.contains(q)){
                return q;
            }
            q = q.parent;
        }
        return null;
    }

 */
}
