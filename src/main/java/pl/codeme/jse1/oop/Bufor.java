package pl.codeme.jse1.oop;

public class Bufor implements Appendable {

    private Object[] elements;
    private int index = 0;

    private void resize() {
        if(elements == null) {
            elements = new Object[1];
        } else {
            Object[] newElements = new Object[elements.length + 1];
            for(int ix = 0; ix < elements.length; ix++) {
                newElements[ix] = elements[ix];
            }
            elements = newElements;
        }
    }

    @Override
    public Appendable append(Object object) {
        resize();
        elements[elements.length - 1] = object;

        return this;
    }

    @Override
    public boolean hasNext() {
        if(index == elements.length) {
            return false;
        }

        return true;
    }

    @Override
    public Object next() {
        if(hasNext()) {
            Object element = elements[index];
            index++;

            return element;
        }

        return null;
    }

    @Override
    public void reset() {
        index = 0;
    }

    public static void main(String[] args) {
        Bufor bufor = new Bufor();
        bufor.append(new Object()).append(new Object()).append(new Object());
        while(bufor.hasNext()) {
            System.out.println(bufor.next());
        }
    }

}
