package Vector.domain;

import java.util.Arrays;

public class Vector {
    private Object[] objects = new Object[100]; //make more generic
    private int numberOfElements = 0;

    private void guaranteesSpace() {
        if(objects.length == numberOfElements) {
            Object extendedObject[] = new Object[numberOfElements * 2];

            for (int i = 0; i < objects.length; i++) {
                extendedObject[i] = objects[i];
            }

            this.objects = extendedObject;
        }
    }

    /*
    Imagine the vector
    index : 0  1  2  3  4
           [x][x][x][][]
    * x represents an allocated position
    Obviously the position must be positive.
    Furthermore
    how is it a vector
    the last position the object can occupy is slightly after the last allocated position.
    */
    private boolean positionIsValid(int pos) {
        return pos >= 0 && pos <= numberOfElements;
    }

    private boolean positionOccupied(int pos) {
        return pos >= 0 && pos < numberOfElements;
    }

    public void add(Object o) {
        guaranteesSpace();
        objects[numberOfElements] = o;
        numberOfElements++;
    }

    public void add(Object o, int pos) {
        guaranteesSpace();
        if(positionIsValid(pos)) {
            //displacement
            for(int i = pos ; i <= numberOfElements-1 ; i++) {
                objects[i+1] = objects[i];
            }
            objects[pos] = o;
            numberOfElements++;
        }
        else{
            throw new IllegalArgumentException("Invalid position");
        }
    }

    public Object get(int pos) {
        if(!positionOccupied(pos)){
            throw new IllegalArgumentException("Invalid position");
        }
        return objects[pos];
    }

    public void remove(int pos) {
        if(!positionOccupied(pos)){
            throw new IllegalArgumentException("Invalid position");
        }
        else{
            for(int i = pos ; i < numberOfElements - 1 ; i++){
                objects[i] = objects[i+1];
            }
            numberOfElements--;
        }
    }

    public boolean contains(Object object){
        for(int i = 0 ; i < numberOfElements ; i++){
            if(objects[i].equals(object)){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return numberOfElements;
    }

    @Override
    public String toString() {
        if(numberOfElements == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for(int i = 0 ; i < numberOfElements-1 ; i++){
            builder.append(objects[i]);
            builder.append(", ");
        }
        builder.append(objects[numberOfElements-1]);
        builder.append("]\n");

        return builder.toString();
    }
}
