public class InventoryMap<K, V> {

    private int capacity = 10;
    private Entry<K, V>[] table;

    @SuppressWarnings("unchecked")
    public InventoryMap() {
        table = new Entry[capacity];
    }

    // Función hash (basada en hashCode)
    private int getHash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = getHash(key);

        Entry<K, V> newEntry = new Entry<>(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];

            // Buscar si ya existe la clave
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            current.next = newEntry;
        }
    }

    public V get(K key) {
        int index = getHash(key);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }
}
