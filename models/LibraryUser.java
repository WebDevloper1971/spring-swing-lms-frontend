package models;

public class LibraryUser {
    private Long id;
    private String name;
    private String email;
    private String contact;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LibraryUser() {

    }

    public LibraryUser(Long id, String name, String email, String contact, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
    }

    @Override
    public String toString() {
        return "LibraryUser [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", address="
                + address + "]";
    }

}
