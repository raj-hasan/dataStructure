package datastructure;


/**
 * Binary Search tree is a special kind of tree which has a root and
 * left nodes are always less than the right node
 */
public class BinarySearchTree {
    private Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    //Left
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    //right
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Left -> Root -> Right
     * @param focusNode The Node to focus starting with root
     */
    public void inOrderTravarsal(Node focusNode){
        if(focusNode!=null){
            inOrderTravarsal(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTravarsal(focusNode.rightChild);
        }
    }

    /**
     * Root -> Left -> Right
     * @param focusNode The Node to focus starting with root
     */
    public void preOrderTravarsal(Node focusNode){
        if(focusNode!=null){
            System.out.println(focusNode);
            preOrderTravarsal(focusNode.leftChild);
            preOrderTravarsal(focusNode.rightChild);
        }
    }

    /**
     *  Right -> Root -> Left
     * @param focusNode The Node to focus starting with root
     */
    public void postOrderTravarsal(Node focusNode){
        if(focusNode!=null){
            postOrderTravarsal(focusNode.rightChild);
            System.out.println(focusNode);
            postOrderTravarsal(focusNode.leftChild);

        }
    }

    public static void main(String [] args){
        BinarySearchTree tree= new BinarySearchTree();
        tree.addNode(50,"Principal");
        tree.addNode(25,"Teacher");
        tree.addNode(15,"Class Teacher");
        tree.addNode(30,"Vice Principle");
        tree.addNode(75,"Clerk");
        tree.addNode(40,"Asst Teacher");
        tree.addNode(90,"Pion");

        tree.postOrderTravarsal(tree.root);

    }

}

class Node {
    protected int key;
    private String name;
    protected Node leftChild;
    protected Node rightChild;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", name='" + name + '\'' +
                '}';
    }
}
