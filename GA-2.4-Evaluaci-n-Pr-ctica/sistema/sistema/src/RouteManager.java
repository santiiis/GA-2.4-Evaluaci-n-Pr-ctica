public class RouteManager<T extends Package<?>> implements IContainer<T> {

    private Node<T> head;
    private Node<T> tail;
    private Node<T> current;

    public RouteManager() {
        head = null;
        tail = null;
        current = null;
    }

    // Insertar al final O(1)
    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Eliminar (búsqueda O(n), eliminación O(1))
    @Override
    public boolean remove(T element) {
        Node<T> temp = head;

        while (temp != null) {
            if (temp.data.equals(element)) {

                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }

                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    // Buscar por id (como pide IContainer)
    @Override
    public T get(String id) {
        Node<T> temp = head;

        while (temp != null) {
            if (temp.data.getId().equals(id)) {
                return temp.data;
            }
            temp = temp.next;
        }

        return null;
    }

    // Navegación hacia adelante
    public void moveNext() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Movido a siguiente punto: " + current.data);
        }
    }

    // Navegación hacia atrás
    public void movePrev() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Retorno a punto previo: " + current.data);
        }
    }
}
