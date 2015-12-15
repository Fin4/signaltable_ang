package rldev.signaltable.service.security.permissionEvaluators;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import rldev.signaltable.entity.DigitalInput;

import java.io.Serializable;
import java.util.Collection;

@Component
public class DigitalInputPermissionEvaluator implements PermissionEvaluator {
    public boolean hasPermission(Authentication authentication, Object o, Object permission) {

        if (o instanceof DigitalInput && permission instanceof String && authentication != null) {
            DigitalInput digitalInput = (DigitalInput) o;
            Collection<? extends GrantedAuthority> authorities =  authentication.getAuthorities();
            String departmentName = digitalInput.getProcessControlObject().getDepartment().getName();

            for (Object authority : authorities) {
                String[] tokens = ((GrantedAuthority) authority).getAuthority().split("_");

                if (departmentName.equalsIgnoreCase(tokens[1])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
