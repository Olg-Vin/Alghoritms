package Tree.SearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E>{
    private Node<E> root;
    public BinarySearchTree() {
    }
    public BinarySearchTree(E element) {
        this.root = new Node<>(element);
    }
    public BinarySearchTree(Node<E> node) {
        this.root = node;
    }
    void printTree(Node<E> node, int level) {
        if (node == null)
            return;
        printTree(node.rightChild, level + 1);
        for (int i = 0; i < level; i++)
            System.out.print("   ");
        System.out.println(node.value);
        printTree(node.leftChild, level + 1);
    }
    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<>(element); // Создаем новый узел
        if (root == null) {
            root = newNode; // Если дерево пустое, новый узел становится корнем
            return;
        }
        Node<E> current = root;
        while (true) {
            if (element.compareTo(current.value) < 0) {
                if (current.leftChild == null) {
                    current.leftChild = newNode; // Вставляем новый узел в левую ветвь
                    return;
                }
                current = current.leftChild; // Переходим к следующему узлу слева
            } else if (element.compareTo(current.value) > 0) {
                if (current.rightChild == null) {
                    current.rightChild = newNode; // Вставляем новый узел в правую ветвь
                    return;
                }
                current = current.rightChild; // Переходим к следующему узлу справа
            } else {
                System.out.println("This element already exists");
                return;
            }
        }
    }
    @Override
    public boolean contains(E element) {
        if (root == null) {
            return false; // Если дерево пустое, вернём false
        }
        Node<E> current = root;
        while (current!=null) {
            if (element.compareTo(current.value) < 0) {
                current = current.leftChild; // Переходим к следующему узлу слева
            } else if (element.compareTo(current.value) > 0) {
                current = current.rightChild; // Переходим к следующему узлу справа
            } else {
                System.out.println("This element already exists");
                return true;
            }
        }
        return false;
    }
    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        if (root == null) {
            return new BinarySearchTree<>(); // Если дерево пустое, вернём новое пустое дерево
        }
        Node<E> current = root;
        while (current!=null) {
            if (element.compareTo(current.value) < 0) {
                current = current.leftChild; // Переходим к следующему узлу слева
            } else if (element.compareTo(current.value) > 0) {
                current = current.rightChild; // Переходим к следующему узлу справа
            } else {
                System.out.println("This element already exists");
                return new BinarySearchTree<>(current);
            }
        }
        return new BinarySearchTree<>();
    }
    @Override
    public Node<E> getRoot() {
        return root;
    }
    @Override
    public Node<E> getLeft() {
        return root.leftChild;
    }
    @Override
    public Node<E> getRight() {
        return root.rightChild;
    }
    @Override
    public E getValue() {
        return root.value;
    }

    public BinarySearchTree<E> arrayToTree(E[] array){
        return new BinarySearchTree<>(createTree(array,0,array.length-1));
    }
    private Node<E> createTree(E[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node<E> root = new Node<>(array[mid]);
        root.leftChild = createTree(array, start, mid - 1);
        root.rightChild = createTree(array, mid + 1, end);
        return root;
    }




    public void insertOrDelete(E element) {
        if (contains(element)) {
            delete(element);
        } else {
            insertTwo(element);
        }
    }
    public void insertTwo(E element) {
        root = insertRecursive(root, element);
    }
    private Node<E> insertRecursive(Node<E> current, E element) {
        if (current == null) {
            return new Node<>(element);
        }

        if (element.compareTo(current.value) < 0) {
            current.leftChild = insertRecursive(current.leftChild, element);
        } else if (element.compareTo(current.value) > 0) {
            current.rightChild = insertRecursive(current.rightChild, element);
        } else {
            // элемент уже существует
        }
        return current;
    }
    public void delete(E element) {
        root = deleteRecursive(root, element);
    }

    private Node<E> deleteRecursive(Node<E> current, E element) {
        if (current == null) {
            return null;
        }
        if (element.compareTo(current.value) < 0) {
            current.leftChild = deleteRecursive(current.leftChild, element);
        } else if (element.compareTo(current.value) > 0) {
            current.rightChild = deleteRecursive(current.rightChild, element);
        } else {
            if (current.leftChild == null) {
                return current.rightChild;
            } else if (current.rightChild == null) {
                return current.leftChild;
            }
            current.value = minValue(current.rightChild); // изменяем значение на минимальное в правом поддереве
            current.rightChild = deleteRecursive(current.rightChild, current.value); // удаляем использованное значение
        }
        return current;
    }

    private E minValue(Node<E> root) { //  используется для поиска минимального значения в поддереве
        E minv = root.value;
        while (root.leftChild != null) {
            minv = root.leftChild.value;
            root = root.leftChild;
        }
        return minv;
    }
}
