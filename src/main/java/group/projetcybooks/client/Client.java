package group.projetcybooks.client;

import group.projetcybooks.serveur.ConnectDB;
import group.projetcybooks.serveur.model.Book;
import group.projetcybooks.serveur.model.BorrowManager;
import group.projetcybooks.serveur.model.User;
import group.projetcybooks.serveur.model.UserManager;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static final String host = "localhost";
    private static final int port = 5543;

    public Client() {
    }

    public Book ClientISBN(String isbn) {
        Book book = null;
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String clientInput = "105 " + isbn;
            out.println(clientInput);
            book = new Book(in.readLine());
            System.out.println(Integer.parseInt(in.readLine()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
            return null;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + host);
            e.printStackTrace();
            return null;
        }
        return book;
    }

    public int ClientSendNewUser(User user) {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String clientInput = "106 " + user.toString();
            out.println(clientInput);
            System.out.println(Integer.parseInt(in.readLine()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
            return -1;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + host);
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    public int ClientUpdateUser(User user, String lastName, String firstName, String phone) {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String clientInput = "107 " + user.toString() + lastName + firstName + phone;
            out.println(clientInput);
            System.out.println(Integer.parseInt(in.readLine()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
            return -1;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + host);
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    public List<User> ClientSearchUser(String lastName, String firstName, String phone) {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String clientInput = "108 " + lastName + firstName + phone;
            out.println(clientInput);

            System.out.println(Integer.parseInt(in.readLine()));
            List<User> users = new ArrayList<>();
            String result = in.readLine();
            String[] resultSplit = result.split("/");

            for (String line : resultSplit) {
                users.add(new User(line));
            }
            return users;

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
            return null;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + host);
            e.printStackTrace();
            return null;
        }
    }

    public int ClientRemoveUser(User user) {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String clientInput = "109 " + user.toString();
            out.println(clientInput);
            System.out.println(Integer.parseInt(in.readLine()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
            return -1;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + host);
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    public int ClientAskReturnBookList(User user) {
        try (Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String clientInput = "110 " + user.toString();
            out.println(clientInput);

            System.out.println(Integer.parseInt(in.readLine()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
            return -1;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + host);
            e.printStackTrace();
            return -1;
        }
        return 1;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Client().ClientAskReturnBookList(new User(1,"Hautecourt","Julien","0781287621")));
    }
}
