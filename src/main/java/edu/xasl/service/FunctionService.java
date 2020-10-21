package edu.xasl.service;

import edu.xasl.pojo.Authority;
import edu.xasl.pojo.PagingForUser;

import java.util.List;

public interface FunctionService {
    boolean addfunction(String function_name, String function_address, String fatherFunction);

    List<Authority> findAllFatherFunction();
    PagingForUser selectFunction(PagingForUser pagingForUser);

    Authority selectFunctionById(String function_id);



    Boolean updateFunction(String function_name, String function_address, String fatherFunction_name, int function_id);

    boolean deleteFunction(String function_id);
}
