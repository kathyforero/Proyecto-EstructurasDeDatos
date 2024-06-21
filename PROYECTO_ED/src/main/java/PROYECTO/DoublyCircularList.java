
package PROYECTO;

import java.util.Iterator;

public class DoublyCircularList<E> implements List<E>{
    private DoublyCircularNode<E> last;

    public DoublyCircularNode<E> getLast(){
        return last;
    }
    
     public DoublyCircularNode<E> getHeader(){
        return last.getNext();
    }
    
    public void setLast(DoublyCircularNode<E> last){
        this.last = last;//NO USAR!
    }
    
    public void setHeader(DoublyCircularNode<E> last){
        this.last.setNext(last);//NO USAR!
    }
    
    @Override
    public boolean addFirst(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addLast(E e) {
        if(e!=null){ // No añadimos nulos.
            DoublyCircularNode node = new DoublyCircularNode<>(e);
            if(last==null){ // En caso de que la lista esté vacía, el primer elemento será last y apuntará a sí mismo.
                last = node;
                last.setNext(last);
                last.setPrevious(last);
                return true;                
            } else if(last.getNext()==last && last.getPrevious()==last){ // En caso de que solo haya un elemento.
                last.setNext(node);
                last.setPrevious(node);
                node.setNext(last);
                node.setPrevious(last);
                last = node;
                return true;
            }   else if(last.getNext()!=last){ // En caso de que la lista esté vacía, el primer elemento será last y apuntará a sí mismo.
                node.setNext(last.getNext());
                node.setPrevious(last);
                last.getNext().setPrevious(node);
                last.setNext(node);
                last=node;
                return true;                
            } 
        }    
        return false;
    }  

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeLast() {
        if(last.getNext()!=null){ // Comprobar si hay más de un elemento.
        DoublyCircularNode<E> n = last;
        E e = last.getContent();
        for(n = last.getNext(); n!=last; n = n.getNext()){
            if(n.getNext()==last){
                n.setNext(last.getNext());
                this.last = n;
                break;                
            }
        }
        return e;
        } else if(last.getNext()==null){ // Si solo tenemos last, hay un elemento nada más, creamos otro caso.
            E e = last.getContent();
            this.last = null;
            return e;
        }
        return null; // Si no se cumple ningún caso, quiere decir que no hay elementos, retornamos null.
    }

    public Iterator<E> iterator(){
        Iterator<E> it=new Iterator<E>() {
            DoublyCircularNode<E> cursor = last.getNext();
            boolean firstPass = true;
            
            @Override
            public boolean hasNext() {
                return cursor != last.getNext() || firstPass;         
            }
            @Override
            public E next() {
                E e = cursor.getContent();
                cursor = cursor.getNext();
                if (cursor == last.getNext()) {
                    firstPass = false;
                }
                return e;
            }
        };
        return it;
    } 
    
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> findIntersection(List<E> another) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}

