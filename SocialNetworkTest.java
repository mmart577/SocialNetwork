import cop4814.social.Person;
import cop4814.social.SocialNetwork;
import java.util.ArrayList;
import java.util.List;

public class SocialNetworkTest 
{
    SocialNetwork net = new SocialNetwork();
    
    void initializeNetwork() 
    {
        net.add(new Person("jsmith@gmail.com", "Smith, Joe"));
        net.add(new Person("swong@gmail.com", "Wong, Sarah"));
        net.add(new Person("echong@gmail.com", "Chong, Elaine"));
        net.add(new Person("trent@gmail.com", "Smith, Trent"));
        net.add(new Person("msmith@gmail.com", "Smith, Mary"));
        net.add(new Person("carn@gmail.com", "Nunez, Carol"));
        net.add(new Person("trint@gmail.com", "Klint, Trina"));
        net.add(new Person("mlacey@gmail.com", "Lacey, Martha"));
        net.add(new Person("yclancy@gmail.com", "Clancy, Yolanda"));
        net.add(new Person("orly@gmail.com", "O'Reilly, Olivia"));
    }
    
    void createConnections() 
    {
        net.find("jsmith@gmail.com").connect(net.find("swong@gmail.com"));
        net.find("jsmith@gmail.com").connect(net.find("echong@gmail.com"));
        net.find("jsmith@gmail.com").connect(net.find("trint@gmail.com"));
        net.find("jsmith@gmail.com").connect(net.find("mlacey@gmail.com"));   

        net.find("swong@gmail.com").connect(net.find("jsmith@gmail.com"));
        
        net.find("echong@gmail.com").connect(net.find("jsmith@gmail.com"));
        net.find("echong@gmail.com").connect(net.find("orly@gmail.com"));   
        
        net.find("trint@gmail.com").connect(net.find("jsmith@gmail.com"));   
        net.find("trint@gmail.com").connect(net.find("mlacey@gmail.com"));   
        net.find("trint@gmail.com").connect(net.find("carn@gmail.com"));  
        net.find("trint@gmail.com").connect(net.find("orly@gmail.com"));   

        net.find("carn@gmail.com").connect(net.find("trint@gmail.com"));  
        net.find("carn@gmail.com").connect(net.find("orly@gmail.com"));   
        
        net.find("trint@gmail.com").connect(net.find("orly@gmail.com")); 
        
        net.find("orly@gmail.com").connect(net.find("trint@gmail.com"));   
        net.find("orly@gmail.com").connect(net.find("carn@gmail.com"));  
        net.find("orly@gmail.com").connect(net.find("msmith@gmail.com"));   
        
        net.find("msmith@gmail.com").connect(net.find("orly@gmail.com"));   
        net.find("msmith@gmail.com").connect(net.find("yclancy@gmail.com"));  
        
        net.find("yclancy@gmail.com").connect(net.find("msmith@gmail.com"));   
    }
    
    void addInterests() {
        net.find("jsmith@gmail.com").addInterest("surfing");
        net.find("mlacey@gmail.com").addInterest("surfing");
        net.find("swong@gmail.com").addInterest("surfing");
        net.find("orly@gmail.com").addInterest("surfing");
        net.find("echong@gmail.com").addInterest("surfing");

        net.find("jsmith@gmail.com").addInterest("skateboarding");
        net.find("mlacey@gmail.com").addInterest("skateboarding");
        net.find("orly@gmail.com").addInterest("skateboarding");
        
        net.find("jsmith@gmail.com").addInterest("sewing");
        net.find("mlacey@gmail.com").addInterest("sewing");
                        
        net.find("yclancy@gmail.com").addInterest("sewing");
        net.find("orly@gmail.com").addInterest("sewing");
        net.find("jsmith@gmail.com").addInterest("sewing");
        
        net.find("msmith@gmail.com").addInterest("running");
        net.find("carn@gmail.com").addInterest("running");
        net.find("trent@gmail.com").addInterest("running");
        
        net.find("mlacey@gmail.com").addInterest("baseball");
        net.find("trint@gmail.com").addInterest("cooking");
        net.find("trent@gmail.com").addInterest("football");
    }
    
    void start() {
        initializeNetwork();
        createConnections();
        addInterests();
        
        System.out.println("\n***** All Members *****");
        List<Person> list = net.allMembers();
        for(Person p : list)
        {  
            //Connections
            System.out.println(p.toString());
            System.out.println("Connections: ");
            for(Person friend : p.getConnections())
                System.out.printf("\n%s, ", friend.toString());
            
            //System.out.println();
            
            //Interests
            System.out.println(p.toString() + "/nInterests: ");
            for(String interest : p.getInterests())
                System.out.printf("%s, ", interest);
            
            System.out.println("\n--------------------------");     
        } 
        System.out.println("\nMember: " + net.find("echong@gmail.com") + "\nInterests:" + net.find("echong@gmail.com").getInterests() + "\nConnections: "+ net.find("echong@gmail.com").getConnections());
       System.out.println("\nMember: " + net.find("msmith@gmail.com") + "\nInterests:" + net.find("msmith@gmail.com").getInterests() + "\nConnections: "+ net.find("msmith@gmail.com").getConnections());
       
       System.out.println("\nTrying to find bmarshall@gmail.com..."); 
       
       try
       {
           String person = net.find("bmarshall@gmail.com").toString();
       }
       catch(Exception e)
       {
           System.out.println("Person is not in the network");
       }
       System.out.println("***People Connected to Elaine Chong ***");
       List<String> myList = new ArrayList<>();
       myList.addAll(net.connectedTo("echong@gmail.com"));
       System.out.println(myList);
       
       net.remove("jsmith@gmail.com");
       
       System.out.println("\n***** All Members *****");
       for(Person p : list)
       {  
            //Connections
            System.out.println(p.toString());
            System.out.println("\n\tConnections: ");
            for(Person friend : p.getConnections())
                System.out.printf("\n%s, ", friend.toString());
            
            System.out.println();
            
            //Interests
            System.out.println(p.toString() + "\n\tInterests: ");
            for(String interest : p.getInterests())
                System.out.printf("\n%s, ", interest);
            
            System.out.println("\n--------------------------");     
        } 
    }
    
    public static void main(String[] args)
    {
        new SocialNetworkTest().start();
    }
}
