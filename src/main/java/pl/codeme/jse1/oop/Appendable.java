package pl.codeme.jse1.oop;

/**
 * Interfejs do rozszezalnej kolekcji z funkcjonalnoscia iteratora
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public interface Appendable {

	/**
	 * Metoda umozliwia dodawanie obiektów do kolekcji
	 * 
	 * @param object
	 *            Nowy element kolekcji
	 * 
	 * @return Zwraca instancje obiektu (sam siebie)
	 */
	public Appendable append(Object object);

	/**
	 * Metoda sprawdza czy są jeszcze elementy za kursorem
	 * 
	 * @return Zwraca prawda / fałsz w zalezności czy kursor ustawiony jest na końcu kolekcji czy nie
	 */
	public boolean hasNext();

	/**
	 * Metoda zwraca element z kolekcji i przesówa kursor na kolejny element w kolekcji
	 * 
	 * @return Element z kolekcji na kyóry wskazuje kursor
	 */
	public Object next();

	/**
	 * Metoda ustawia kursor na początku kolekcji
	 */
	public void reset();

}
