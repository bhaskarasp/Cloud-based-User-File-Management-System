/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

/**
 *
 * @author DELL
 */
public class sessionclass {
    public static String user=null;
    public void setusername(String name){
        user=name;
    }
    public String getusername(){
        return user;
    }
     
    public static void main(String args[]){
        sessionclass sc=new sessionclass();
        sc.setusername("ravi");
        System.out.println(sc.getusername());
    }
}
