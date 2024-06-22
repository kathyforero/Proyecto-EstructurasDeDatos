package Bases;

import java.io.Serializable;

public class DoublyCircularNode<E> implements Serializable{
    private E content;
    private DoublyCircularNode<E> next;
    private DoublyCircularNode<E> previous;
    
    public DoublyCircularNode(E content){
        this.content=content;
        this.next=this; // Instancia de un nodo el next ya no apunta a null sino a si mismo
        this.previous=this;
    }
    
    public E getContent(){
        return content;
    }
    
    public void setContent(E content){
        this.content = content;
    }
    
    public DoublyCircularNode<E> getNext(){
        return next;
    }
    
    public void setNext(DoublyCircularNode<E> next){
        this.next = next;
    }
    
    public DoublyCircularNode<E> getPrevious(){
        return previous;
    }
    
    public void setPrevious (DoublyCircularNode<E> next){
        this.previous = next;
    }
    
}
