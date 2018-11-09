package homework12;

import java.util.Arrays;

public class GenArray<T> {
    T[] genArray;

    public  GenArray(){

    }
    public GenArray(T[] genArray) {
        this.genArray = genArray;
    }

    public T get(int index) {
        return genArray[index];
    }

    public void set(int index, T element) throws IndexOutOfBoundsException {

        this.genArray[index] = element;
        if (index >= genArray.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenArray<?> genArray1 = (GenArray<?>) o;
        return Arrays.equals(genArray, genArray1.genArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(genArray);
    }

    @Override
    public String toString() {
        return "GenArray{" +
                "genArray=" + Arrays.toString(genArray) +
                '}';
    }
}
