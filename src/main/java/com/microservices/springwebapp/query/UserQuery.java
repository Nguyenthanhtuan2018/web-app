package com.microservices.springwebapp.query;

import java.util.Objects;
import java.util.function.Function;

public class UserQuery {

	public static Function<String, String> createQueryToGetUserEntityByName = (name) -> {

        String query = "";

        query = " SELECT * " +                            
                " FROM" +
                " user" +
                " WHERE" +
                " user.is_delete = 0";

        if (!Objects.isNull(name))
            query += " AND user.name= '" + name + "'";

        return query;
    };
    
    public static String createQueryToGetAllUser()
    {

        String query = "";

        query = " SELECT * " +                            
                " FROM" +
                " user" +
                " WHERE" +
                " user.is_delete = 0";

        return query;
    };
}
