package cop4814.social;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SocialNetwork 
{
    Map<String, Person> friends = new HashMap<>();
    
    public void add(Person p)
    {
        friends.put(p.email, p);
    }
    public Person find(String email)
    {
        Person p = friends.get(email);
        return p;
    }
    public List<String> connectedTo(String email) 
    {
        List<String> temp = new LinkedList<>();
        for(Person p : this.allMembers())
            if(p.email.equals(email))               //finds the person with the given email
                for(Person a : p.getConnections())
                    temp.add(a.toString());
        return temp;
    }
    public List<Person> allMembers()
    {
        List<Person> temp = new LinkedList<>();
        for(Person p : friends.values())
            temp.add(p);
        return temp;
    }
    public void remove(String email) 
    {//iterates through the entire network and removes this person from everyone's connections
        for(Person p : this.allMembers())
            if(p.getConnections().contains(this.find(email)))      //if someone is connected to this person
                p.getConnections().remove(this.find(email));       //remove all instances of this member from everyone's connections
    }
    public List<String> interestedIn(String description)
    {
        List<String> emails = new ArrayList<>();
        for(Person p : friends.values())
            if(p.getInterests().contains(description))
                emails.add(p.email);
        return emails;
    }
}
