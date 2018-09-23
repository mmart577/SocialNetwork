package cop4814.social;

import java.util.LinkedList;
import java.util.List;

public class Person 
{
    String email;
    String name;
    List<String> interests;
    List<Person> connections;
        
    public Person(String email, String name) 
    {
        this.email = email;
        this.name = name;
        interests = new LinkedList<>();
        connections = new LinkedList<>();
    }
    
    public void addInterest(String something) {
        if(!interests.contains(something))
            interests.add(something);
    }
        
    public void connect(Person p)
    {
        connections.add(p);  

        /**
        if(!connections.contains(p))
        {
            connections.add(p);  
            p.connect(this);
        }   **/
    }
    
    public boolean equals(Object obj)
    {
        Person p = (Person) obj;
        return this.email.equals(p.email);
    }
    
    public List<String> getInterests() {
        return interests;
    }
    
    public List<Person> getConnections() {
        return connections;
    }
    
    public String toString() {
        return email + " " + name;
    }
}
