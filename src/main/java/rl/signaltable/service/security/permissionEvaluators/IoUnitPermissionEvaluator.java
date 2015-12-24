package rl.signaltable.service.security.permissionEvaluators;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import rl.signaltable.core.entity.IoUnit;

import java.io.Serializable;
import java.util.Collection;

@Component
public class IoUnitPermissionEvaluator implements PermissionEvaluator {
    public boolean hasPermission(Authentication authentication, Object o, Object permission) {

        if (o instanceof IoUnit && permission instanceof String && authentication != null) {
            IoUnit ioUnit = (IoUnit) o;
            Collection<? extends GrantedAuthority> authorities =  authentication.getAuthorities();
            String departmentName = ioUnit.getProcessControlObject().getDepartment().getName();

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
