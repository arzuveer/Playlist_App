import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album album1= new Album("Raaz3","k.k");
        album1.addSongToAlbum("rafta rafta",3.60);
        album1.addSongToAlbum("zindagi se churake",3.40);
        album1.addSongToAlbum("deewana kar raha hai",4.50);
        album1.addSongToAlbum("khayaalon mein bhi",4.20);

        Album album2= new Album("Aawarapan","k.k");
        album2.addSongToAlbum("tera mera rishta",3.60);
        album2.addSongToAlbum("to phir ao",3.40);
        album2.addSongToAlbum("mahiya",4.50);

        Album album3= new Album("Khamoshiyan","arijit singh");
        album3.addSongToAlbum("khamoshiyan",3.60);
        album3.addSongToAlbum("baatein ye kabhi na",3.40);
        album3.addSongToAlbum("tu har lamha",4.50);

        Album album4= new Album("Ashiqi2","Arijit singh");
        album4.addSongToAlbum("chahu mein ya na",3.60);
        album4.addSongToAlbum("tum hi ho",3.40);
        album4.addSongToAlbum("sun raha hai na tu",4.50);

           List<songs> MyPlaylist= new LinkedList<songs>();
        album1.addSongToPlaylistFromAlbum(3, MyPlaylist);
        album2.addSongToPlaylistFromAlbum(2,MyPlaylist);
        album4.addSongToPlaylistFromAlbum(2,MyPlaylist);
        album3.addSongToPlaylistFromAlbum(1,MyPlaylist);
        album1.addSongToPlaylistFromAlbum("rafta rafta",MyPlaylist );
        album3.addSongToPlaylistFromAlbum("tu har lamha",MyPlaylist);
        album1.addSongToPlaylistFromAlbum("khayaalon mein bhi",MyPlaylist);



        play(MyPlaylist);
    }

    private static void play(List<songs> myPlaylist) {

        ListIterator<songs> itr= myPlaylist.listIterator();//syntax of iterator
        if(myPlaylist.isEmpty()) {
            System.out.println("playlist is empty");
            return;
        }
        boolean isNext= false;
        System.out.println("currently playing :  ");
        System.out.println(itr.next());
        isNext=true;
        Scanner sc= new Scanner(System.in);
        printMenu();
        while(true){
            System.out.println("enter your choice: ");
            int choice= sc.nextInt();
            switch (choice){

                case 1:
                    if(!isNext)
                    {  // because if isNext is false then itr.prev must have done
                        // so to avoid repetition take one step ahead
                        itr.next();
                        isNext= true;
                    }
                    if(itr.hasNext()) {
                        System.out.println("now playing:");
                        System.out.println(itr.next());
                        isNext=true;
                    }
                    else
                        System.out.println("you have reached to the end");
                    break;

                case 2:
                    if(isNext)
                    {   // because if isNext is true then itr.next must have done
                        // so to avoid repetition take one step ahead
                        itr.previous();
                        isNext= false;
                    }
                    if(itr.hasPrevious()) {
                        System.out.println("now playing:");
                        System.out.println(itr.previous());
                        isNext=false;
                    }
                    else
                        System.out.println("you are on first song");
                    break;

                case 3:
                    if(isNext) {
                        System.out.println(itr.previous());
                        isNext=false;
                    }
                    else {
                        System.out.println(itr.next());
                        isNext=true;
                    }
                    break;

                case 4:
                      itr.remove();
                    System.out.println("song deleted");
                    break;

                case 5:
                    printListOfSongs(myPlaylist);
                    break;

                case 6:
                    printMenu();
                    break;

                case 7:
                    return;

                default:
                    System.out.println("Wrong choice. Please select again");
            }
        }
    }
    public static void printListOfSongs(List<songs> playList)
    {

   for(songs song: playList)
       System.out.println(song);

  return;
    }
    public static void printMenu()
    {
        System.out.println("choices:");
        System.out.println("1. play next song");
        System.out.println("2. play Previous song");
        System.out.println("3. play current song again");
        System.out.println("4. delete current song");
        System.out.println("5. show the list of songs");
        System.out.println("6. show choices again");
        System.out.println("7. exit");


    }

}