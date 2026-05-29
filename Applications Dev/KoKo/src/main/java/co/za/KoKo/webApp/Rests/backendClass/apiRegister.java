package co.za.KoKo.webApp.Rests.backendClass;

public class apiRegister {
    private String name;
    private String email;
    private String phone;
    private String password;

    public apiRegister(String name, String email, String phone, String password){
        if (name == null || email == null || phone == null || password == null){
            throw new IllegalArgumentException();
        }

        this.name=name;
        this.email=email;
        this.phone=phone;
        this.password=password;
    }
    public apiRegister(){}

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getPassword() {
        return password;
    }
}
