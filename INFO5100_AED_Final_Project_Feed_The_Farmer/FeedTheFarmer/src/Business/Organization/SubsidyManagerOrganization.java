/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.SubsidyManagerRole;
import java.util.ArrayList;

/**
 *
 * @author suhee
 */
public class SubsidyManagerOrganization extends Organization{
    public SubsidyManagerOrganization() {
        super(Organization.Type.SubsidyManagerOrganization.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SubsidyManagerRole());
        return roles;
    }
}
