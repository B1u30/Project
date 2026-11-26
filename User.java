public abstract class User {

    private String id;
    private String name;
    private String email;
    private String password;
    private boolean loggedin = false;

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean login(String email, String password) 
    {
       if(this.email.equals(email) && this.password.equals(password)) loggedin = true;
       
       return loggedin; 
    }

    public void logout() 
    {
        loggedin = false;
    }

    public void showMenuItems(Menu menu) 
    {
        if (menu == null || menu.items == null) return;
        for (int i = 0; i < menu.items.length; i++) {
            if (menu.items[i] == null) continue;
            System.out.println("-"+ (i + 1)+ ": "+menu.items[i].getName());
        }
    }
}
