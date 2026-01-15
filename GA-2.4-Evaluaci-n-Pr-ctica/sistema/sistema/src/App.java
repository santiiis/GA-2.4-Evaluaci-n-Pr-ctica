public class App {
    public static void main(String[] args) {

        Package<String> p1 = new Package<>("PK1", "Libros", PackageType.STANDARD, 3);
        Package<String> p2 = new Package<>("PK2", "Laptop", PackageType.FRAGILE, 1);
        Package<String> p3 = new Package<>("PK3", "Ropa", PackageType.EXPRESS, 2);

        // ===== RUTAS (Lista Doblemente Enlazada) =====
        RouteManager<Package<String>> route = new RouteManager<>();
        route.add(p1);
        route.add(p2);
        route.add(p3);

        route.moveNext();
        route.moveNext();
        route.movePrev();

        // ===== INVENTARIO (Tabla Hash) =====
        InventoryMap<String, Package<?>> inventory = new InventoryMap<>();
        inventory.put(p1.getId(), p1);
        inventory.put(p2.getId(), p2);

        System.out.println("Buscar PK2: " + inventory.get("PK2"));

        // ===== ORDENAMIENTO =====
        Package<?>[] array = {p1, p2, p3};

        System.out.println("\nInsertion Sort:");
        PrioritySorter.insertionSort(array);
        for (Package<?> p : array) {
            System.out.println(p);
        }
    }
}
