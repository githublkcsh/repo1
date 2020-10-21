package edu.xasl.dao;

import edu.xasl.pojo.Authority;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("functionDao")
public interface FunctionDao {
    boolean addfunction(@Param("function_name") String function_name, @Param("function_address") String function_address, @Param("fatherFunction") String fatherFunction);

    List<Authority> findAllFatherFunction();
    List<Authority>selectFunction(Map<String,Integer> map);

    int selectTotalRecord();

    Authority selectFunctionById(@Param("function_id") String function_id);

    Authority selectSonFunctionById(@Param("function_id")String function_id);

    Authority selectFaFunctionById(@Param("function_id")String function_id);

    Integer selectFatherFunctionById(@Param("function_id")String function_id);

    Boolean updateFunction(@Param("function_name")String function_name, @Param("function_address") String function_address, @Param("fatherFunction_name") String fatherFunction_name, @Param("function_id") int function_id);

    boolean deleteFunction(@Param("function_id") String function_id);

    boolean deleteFunction01(String function_id);
}
