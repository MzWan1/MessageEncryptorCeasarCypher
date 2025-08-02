package za.ac.tut.ejb.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.ejb.model.Messages;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-08-02T00:55:22")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> agentId;
    public static volatile ListAttribute<Users, Messages> messagesList;
    public static volatile SingularAttribute<Users, String> agentName;

}