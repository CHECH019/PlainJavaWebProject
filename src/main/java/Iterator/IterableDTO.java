package Iterator;

public interface IterableDTO<T> {
    public void agregar(T dto);
    public Iterator<T> iterator();
}
