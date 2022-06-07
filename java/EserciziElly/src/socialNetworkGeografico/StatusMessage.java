package socialNetworkGeografico;

import java.util.Objects;

public class StatusMessage implements FriendShip{
    private String username;
    private String city;
    private String text;

    public StatusMessage(String username, String city, String text){
        this.username = username;
        this.city = city;
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public String getCity() {
        return city;
    }

    /**
     * Implementazione metodo interfaccia
     * @param obj
     * @return
     */
    @Override
    public boolean isNearTo(Object obj) {
        if(!(obj instanceof StatusMessage))
            return false;
        StatusMessage tmp = (StatusMessage) obj;

        return this.city.equals(tmp.city);
    }

    /**
     * Override metodo toString
     * @return
     */
    @Override
    public String toString(){
        return this.username + " " + this.text + " (" + this.city + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusMessage other = (StatusMessage) o;

        return this.username.compareTo(other.username) == 0 &&
                this.city.compareTo(other.city) == 0 &&
                this.text.compareTo(other.text) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, city, text);
    }
}
