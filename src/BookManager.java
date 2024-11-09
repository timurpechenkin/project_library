import java.util.*;

public class BookManager {
    private ArrayList<Book> books;
    public BookManager(ArrayList<Book> books){
        this.books=books;
    }

    public void get(String[] supplement){
        ArrayList<Book> expectedBooks = new ArrayList<>();
        for(Book book: books){
            if(book.getName().equals(supplement[0])) expectedBooks.add(book);
        }
        if(expectedBooks.isEmpty()){
            System.out.println("There is no such books");
        }
        else {
            for (Book book: expectedBooks) System.out.println(book.toString());
        }
    }

    public void help(){
        System.out.println("List of commands:\nGET{\"Name\":\"xxx\"}\nHELP\nPOST {\"Name\":\"xxx\", \"Author\":\"xxx\", \"PagesCount\":xxx}\nSTOP");
    }

    public void post(String[] supplement){
        int pages;
        try{
            pages = Integer.parseInt(supplement[2]);
        }
        catch (Exception ex){
            pages = 0;
            System.out.println(ex.getMessage());
        }
        books.add(new Book(supplement[0], supplement[1], pages));
        System.out.println("The book was added");
    }

//    public void delete(){
//        System.out.print("delete a book command");
//    }
//
//    public void put(){
//        System.out.print("edit a book command");
//    }

}
