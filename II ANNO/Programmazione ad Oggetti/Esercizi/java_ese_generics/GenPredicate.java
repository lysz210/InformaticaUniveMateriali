/*
 * Interfaccia per classi che hanno un solo metodo test
 * per testare una proprietà su oggetto generico T
 */
interface GenPredicate<T> {
    public boolean test(T obj);
}

