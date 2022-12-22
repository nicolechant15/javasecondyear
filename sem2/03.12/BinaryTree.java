public class BinaryTree {
    Node root;
    public void addNode(int num) {

        Node newNode = new Node(num); // создаем узел и инициализируем его

        if (root == null) {
            root = newNode; // если не было корня то узел им становится
        }
        else {
            Node focusNode = root;
            Node parent; // родитель узла

            while (true) {
                parent = focusNode;

                // смотрим в какую сторону относительно родительского узла должен идти новый
                if (num < focusNode.num) { // проверяем левую сторону: если новый узел меньше родительского, то ему сюда
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) { // проверяем левую сторону на пустоту
                        parent.leftChild = newNode; // если пустая то закидываем сюда
                        return;
                    }
                }
                else { // в ином случае новому узлу сюда
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) { // также проверяем на пустоту
                        parent.rightChild = newNode;
                        return;

                    }

                }

            }
        }

    }

    public static void main(String[] args) {

        BinaryTree theTree = new BinaryTree();

        // добавляем узлы
        theTree.addNode(60);
        theTree.addNode(45);
        theTree.addNode(98);
        theTree.addNode(14);
        theTree.addNode(9);
        theTree.addNode(88);
    }
}

class Node {
    int num;
    Node leftChild; // левый потомок
    Node rightChild; // правый потомок

    Node(int num) {
        this.num = num;
    }
}