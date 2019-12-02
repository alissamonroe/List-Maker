package application;

/**
 * ParentList class: The parent list of NumberList and StringList
 * 
 * MVC - Model
 * 
 * @author alissamonroe
 */

public interface ParentList<T> {

	public String printList();

	public void clearList();

	public void addTo(T item);

	public int getListCount();

	public void setListCount(int numCount);

	public T getItem(int index);

}
