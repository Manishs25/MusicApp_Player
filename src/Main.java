import com.manish.Album;
import com.manish.Song;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1", "AC/BC");

        album.addSong("TNT", 4.5);
        album.addSong("Highway to hell", 3.5);
        album.addSong("ThunderStuck", 5.0);
        albums.add(album);

        album = new Album("Album2", "Eminem");

        album.addSong("Rap god", 4.5);
        album.addSong("Not Afraid", 3.5);
        album.addSong("Lose Yourself", 4.5);
        albums.add(album);

        LinkedList<Song> playlist1 = new LinkedList<>();

        albums.get(0).addToPlayList("TNT", playlist1);
        albums.get(0).addToPlayList("Highway to hell", playlist1);
        albums.get(1).addToPlayList("Rap god", playlist1);
        albums.get(1).addToPlayList("Lose Yourself", playlist1);

        play(playlist1);
    }
    private static void play(LinkedList<Song> playlist) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.size() == 0) {
            System.out.println("This playlist have no song");
        } else {
            System.out.println("Now playing" + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {

                case 0:
                    System.out.println("PlayList Complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("No song available, reached to the end of the list");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward = true) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing" + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the lisit");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playlist);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playlist.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious())
                                System.out.println("Now playing " + listIterator.previous().toString());
                        }
                    }
            }
        }
    }
    private static void printMenu() {
        System.out.println("Available options : \nPress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list of all song\n" +
                "5 - print all the available options\n" +
                "6 - delete current song");
    }
    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("________________");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("________________");
    }
}