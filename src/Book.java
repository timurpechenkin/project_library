public class Book {
    private String author;
    private String name;
    private int pagesCount;

    public Book(String name, String author, int pagesCount){
        this.name = name;
        this.author=author;
        this.pagesCount=pagesCount;
    }

    public String toString(){
        return name+", "+author+", c."+pagesCount;
    }
    public String getAuthor(){
        return author;
    }
    public String getName(){
        return name;
    }
    public int getPagesCount(){
        return pagesCount;
    }
    public void setAuthor(String newAuthor){
        author=newAuthor;
    }
    public void setName(String newGenre){
        name =newGenre;
    }
    public void setPagesCount(int newPagesCount) {
        pagesCount = newPagesCount;
    }
}
