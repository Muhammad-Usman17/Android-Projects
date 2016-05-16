package com.example.muhammad_usman.database;

/**
 * Created by Muhammad_Usman on 5/1/2016.
 */
public class SetGet {

    int ID;
    String Name;
    String Email;

    public SetGet()
    {

    }
    public SetGet(int id,String name,String email)
    {
         this.ID=id;
        this.Name=name;
        this.Email=email;
    }
    public  SetGet(String name,String email)
    {
        this.Name=name;
        this.Email=email;
    }
    public int getIDs()
    {
       return this.ID;
    }
    public String getNames()
    {
        return this.Name;
    }
    public String getEmails()
    {
        return  this.Email;
    }
    public void setIDs(int id)
    {
        this.ID=id;
    }
    public void setNames(String name)
    {
        this.Name=name;

    }
    public void setEmails(String email)
    {
        this.Email=email;
    }


}
