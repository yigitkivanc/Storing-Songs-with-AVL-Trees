

import java.io.*;
import java.util.Scanner;

public class Main {
        static int count = 0;
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\songs.txt");
        Scanner reader = new Scanner(file);
        Scanner input = new Scanner(System.in);
        Song[] songs = new Song[2000000];
        String[] info = new String[20000000];
        AVLTree artist = new AVLTree();
        AVLTree songName = new AVLTree();
        AVLTree id = new AVLTree();


        while (reader.hasNextLine()){
            info = reader.nextLine().split(";");
            for (int i = 0; i < info.length; i+=5) {
                songs[count] = new Song(info[i],info[i+1],info[i+2],info[i+3],info[i+4]);
                artist.insert(songs[count].getArtist(),count);
                id.insert(songs[count].getId(),count);
                songName.insert(songs[count].getSongName(),count);
                count++;

            }
        }
        System.out.println("Song Name Tree Balance: " + songName.getBalance(songName.root));
        System.out.println("Artist Tree Balance: " + artist.getBalance(artist.root));
        System.out.println("ID Tree Balance: " + id.getBalance(id.root));

        displayMenu();
        int choice = input.nextInt();
        while (choice!=9){

            switch (choice){
                case 1:
                    Scanner scanArtistName = new Scanner(System.in);
                    System.out.println("Which artist you want to search");
                    String searchingartist = scanArtistName.nextLine();
                    try{
                        System.out.println(artist.firstSearch(artist.root,searchingartist).data);
                        System.out.println(songs[artist.firstSearch(artist.root,searchingartist).key].toString());
                    }catch(Exception e){
                        System.err.println("not found");
                    }


                    displayMenu();
                    choice = input.nextInt();
                    break;
                case 2:
                    Scanner scanSongName = new Scanner(System.in);
                    System.out.println("Which song name you want to search?");
                    String searchingSongName =scanSongName.nextLine();
                    try {
                        System.out.println(songName.firstSearch(songName.root, searchingSongName).data);
                        System.out.println(songs[songName.firstSearch(songName.root, searchingSongName).key].toString());
                    }catch (Exception e){
                        System.err.println("not found");
                    }

                    displayMenu();
                    choice = input.nextInt();
                    break;
                case 3:
                    Scanner scanId = new Scanner(System.in);
                    System.out.println("Which id you want to search?");
                    String searchingId = scanId.nextLine();
                    try {
                        System.out.println(id.firstSearch(id.root, searchingId).data);
                        System.out.println(songs[id.firstSearch(id.root, searchingId).key].toString());
                    }catch (Exception e){
                        System.err.println("not found");

                    }

                    displayMenu();
                    choice = input.nextInt();
                    break;
                case 4:
                    System.out.println("Enter upper bound id:");
                    String strUp = input.next();
                    System.out.println("Enter lower bound id");
                    String strLow = input.next();
                    int upInt = Integer.valueOf(strUp);

                    int lowInt = Integer.valueOf(strLow);

                    id.thirdSearch(id.root,upInt,lowInt,songs);
                    displayMenu();
                    choice = input.nextInt();
                    break;
                case 5:
                    Scanner scn = new Scanner(System.in);
                    System.out.println("Enter the name of your song");
                    String inputSongName = scn.nextLine();
                    System.out.println("Enter the name of your artist");
                    String inputArtist = scn.nextLine();
                    System.out.println("Enter the genre");
                    String inputGenre = scn.nextLine();
                    System.out.println("Enter year");
                    String inputYear = scn.nextLine();
                    count++;
                    int newId = 1000+count;
                    String sNewId = Integer.toString(newId);
                    Song newSong = new Song(inputSongName,inputArtist,sNewId,inputGenre,inputYear);
                    System.out.println("The song you inserted: " + newSong.toString());
                    id.insert(newSong.getId(),count);
                    artist.insert(newSong.getArtist(),count);
                    songName.insert(newSong.getSongName(),count);
                    songs[count] = newSong;
                    displayMenu();
                    choice = input.nextInt();
                    break;
                case 6:
                    Scanner scanDeleteArtist = new Scanner(System.in);
                    System.out.println("enter the artist name you want to delete:");
                    String deletingArtistName = scanDeleteArtist.nextLine();
                    int deletingArtistKey=artist.firstSearch(artist.root,deletingArtistName).key;
                    artist.deleteNode(artist.root,deletingArtistKey);
                    id.deleteNode(id.root,deletingArtistKey);
                    songName.deleteNode(songName.root,deletingArtistKey);
                    System.out.println("Song deleted by artist name.");
                    displayMenu();
                    choice = input.nextInt();
                    break;
                case 7:
                    Scanner scanDeleteSongName = new Scanner(System.in);
                    System.out.println("enter the song name you want to delete:");
                    String deletingSongName = scanDeleteSongName.nextLine();
                    int deletingSongNameKey=songName.firstSearch(songName.root,deletingSongName).key;
                    artist.deleteNode(artist.root,deletingSongNameKey);
                    songName.deleteNode(songName.root,deletingSongNameKey);
                    id.deleteNode(id.root,deletingSongNameKey);
                    System.out.println("Song deleted by song name.");
                    displayMenu();
                    choice = input.nextInt();
                    break;
                case 8:
                    Scanner scanDeleteId = new Scanner(System.in);
                    System.out.println("enter the id you want to delete:");
                    String deletingId= scanDeleteId.nextLine();
                    int deletingIDKey=id.firstSearch(id.root,deletingId).key;
                    artist.deleteNode(artist.root,deletingIDKey);
                    songName.deleteNode(songName.root,deletingIDKey);
                    id.deleteNode(id.root,deletingIDKey);
                    System.out.println("Song deleted by id.");
                    displayMenu();
                    choice = input.nextInt();
                    break;
                case 9:
                    System.out.println("Good bye");
                    System.exit(0);
                    break;
            }

        }
        System.out.println("Good bye");



    } public static void displayMenu() {
        System.out.println("\nWhich task you want to do?\n"
                + "1- Search by artist name\n"
                + "2- Search by song name\n"
                + "3- Search by id\n"
                + "4- Search by id interval\n"
                + "5- Insertion\n"
                + "6- Delete by artist\n"
                + "7- Delete by song name\n"
                + "8- Delete by id\n"
                + "9- Exit");
    }

}
