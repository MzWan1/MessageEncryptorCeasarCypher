package za.ac.tut.ejb.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.ejb.model.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-08-01T19:34:50")
@StaticMetamodel(Messages.class)
public class Messages_ { 

    public static volatile SingularAttribute<Messages, Users> agentIdFk;
    public static volatile SingularAttribute<Messages, Integer> messageLen;
    public static volatile SingularAttribute<Messages, Integer> messageId;
    public static volatile SingularAttribute<Messages, String> cyphertext;

}