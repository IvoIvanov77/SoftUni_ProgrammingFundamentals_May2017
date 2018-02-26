package object_and_classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class BookLibrary {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Library lib = new Library();
		for (int i = 0; i < n; i++) {
			Book book = new Book();
			book.readBook(sc.nextLine());
			lib.addBook(book);
		}
		Date date = new SimpleDateFormat("dd.MM.yyyy").parse(sc.nextLine());
//		lib.printPricesByAuthor();
		lib.printTitleByDate(date);
		sc.close();
	}

}

class Book{
//	title, author, publisher, release date, ISBN-number and price
	
	private String title;
	private String author;
	private String publisher;
	private Date releaseDate;
	private String ISBNumber;
	private double price;
	
	public void readBook(String line) throws ParseException{
		String[] input = line.split(" ");
		this.setTitle(input[0]);
		this.setAuthor(input[1]);
		this.setPublisher(input[2]);
		this.setReleaseDate(new SimpleDateFormat("dd.MM.yyyy").parse(input[3]));
		this.setISBNumber(input[4]);
		this.setPrice(Double.parseDouble(input[5]));
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getISBNumber() {
		return ISBNumber;
	}
	public void setISBNumber(String iSBNumber) {
		ISBNumber = iSBNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

class Library{	
	private List<Book> books;

	public Library(List<Book> books) {		
		this.books = books;
	}
	
	public Library() {		
		this(new ArrayList<>());
	}
	
	public void addBook(Book book){
		books.add(book);
	}

	public List<Book> getBooks() {
		return books;
	}
	
	public void printPricesByAuthor(){
		Map<String, Double> map = new TreeMap<>();
		for (Book book : books) {
			map.computeIfPresent(book.getAuthor(), (k, v) -> v + book.getPrice());
			map.computeIfAbsent(book.getAuthor(), v -> book.getPrice());
		}
		
		map.entrySet().stream()
		.sorted((book1, book2) -> book2.getValue().compareTo(book1.getValue()))
		.forEach(es -> {
			System.out.printf("%s -> %.2f%n", es.getKey(), es.getValue());
			});
	}
	
	public void printTitleByDate(Date date){
		Comparator<Book> comp = (book1, book2) -> book1.getReleaseDate()
				.compareTo(book2.getReleaseDate());
		comp = comp.thenComparing((b1, b2) -> b1.getTitle()
				.compareTo(b2.getTitle()));	
				
		this.books.stream().filter(book -> book.getReleaseDate().after(date))
		.sorted(comp)
		.forEach(book -> {
			System.out.printf("%s -> %s%n", book.getTitle(), 
					new SimpleDateFormat("dd.MM.yyyy").format(book.getReleaseDate()));
			} );
	}
}




