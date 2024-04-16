package src;
import java.util.Iterator;

public interface IterableByUser {
    @SuppressWarnings("rawtypes")
    Iterator iterator(User userToSearchWith);
}
