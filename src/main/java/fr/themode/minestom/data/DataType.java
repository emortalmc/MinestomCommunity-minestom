package fr.themode.minestom.data;

public abstract class DataType<T> {

    public abstract byte[] encode(T value);

    public abstract T decode(byte[] value);

}