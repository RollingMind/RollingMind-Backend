package RollingRolling.RollingMindBackend.repository.user;

public interface PasswordEncoder {

    String encode(CharSequence rawpassword);

    boolean matches(CharSequence rawpassword, String encodedPassword);

    default boolean upgradeEncoding(String encodedPassword){
        return false;
    }
}
