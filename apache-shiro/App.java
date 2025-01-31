import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

public class App {

    public static void main(String[] args) {
        try {
            // Load the SecurityManager from the shiro.ini file
            Factory<org.apache.shiro.mgt.SecurityManager> factory = 
                new org.apache.shiro.config.IniSecurityManagerFactory("classpath:shiro.ini");
            
            org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
            
            // Set the SecurityManager globally
            org.apache.shiro.SecurityUtils.setSecurityManager(securityManager);

            // Authenticate a user
            UsernamePasswordToken token = new UsernamePasswordToken("admin", "admin123");
            Subject currentUser = org.apache.shiro.SecurityUtils.getSubject();
            
            // Attempt login
            currentUser.login(token);
            
            System.out.println("User authenticated successfully!");

            // Check roles and permissions
            if (currentUser.hasRole("admin")) {
                System.out.println("User has 'admin' role!");
            }

            // Check if the user has a certain permission (we've configured 'admin' to have all permissions)
            if (currentUser.isPermitted("read")) {
                System.out.println("User has 'read' permission!");
            }

        } catch (AuthenticationException ae) {
            System.out.println("Authentication failed: " + ae.getMessage());
        }
    }
}
