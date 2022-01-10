
package laundry;

import java.util.ArrayList;
import laundry.db.MyConnection;
import laundry.form.LaundryForm;
import laundry.form.LoginForm;
import laundry.form.MenuForm;
import laundry.form.ParfumForm;
import laundry.form.PelangganForm;
import laundry.form.UserForm;
import laundry.libs.Pref;
import laundry.model.Login;
import laundry.model.Parfum;
import laundry.model.User;

public class Main {
    public static void main(String[] args) {
//        coba Koneksi
        MyConnection mc = new MyConnection();
        mc.getConnection();

//        coba create user
//        User user;
//        user = new User("rita","purnamasari","admin");
//        user.setConnection(mc.getConnection());
//        user.create();
        
//        coba panggil form user
//        new UserForm().setVisible(true);
        
//        coba read table user dari database
//        User user = new User();
//        ArrayList<User> list = user.read();
//        
//        for (int i = 0; 1< list.size(); i++){
//            System.out.println(list.get(i).getUser()+list.get(i).getPass());
//        }

//        coba Login
//        Login login = new Login();
//        login.masuk("fahmi","asd");
        
//        Coba panggil form login
//        new LoginForm().setVisible(true);
        
//        coba create parfum
//        Parfum parfum;
//        parfum = new Parfum("Mawar",12000);
//        parfum.setConnection(mc.getConnection());
//        parfum.create();

//        coba panggil form parfum
//        new ParfumForm().setVisible(true);

//        coba panggil form pelanggan
//        new PelangganForm().setVisible(true);

//        coba panggil form laundry
//        new LaundryForm().setVisible(true);

//        Coba Pakai Perf
        Pref pref = new Pref();
        String username = pref.getUser();
        if(username.equals("")){
            LoginForm loginform = new LoginForm();
            loginform.setVisible(true);
        } else {
            MenuForm menuform =  new MenuForm();
            menuform.setLevel(pref.getLevel());
            menuform.setUser(pref.getUser());
            menuform.setVisible(true);
        }
        
        
    }
}
