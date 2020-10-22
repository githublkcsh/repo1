package edu.xasl.dao;

import edu.xasl.pojo.Authority;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("functionDao")
public interface FunctionDao {
    boolean addfunction(@Param("function_name") String function_name, @Param("function_address") String function_address, @Param("fatherFunction") String fatherFunction);//添加权限名和权限地址

    List<Authority> findAllFatherFunction();

    List<Authority>selectFunction(Map<String,Integer> map);                                                             //分页查询所有权限信息

    int selectTotalRecord();                                                                                            //查询所有权限数

    Authority selectFunctionById(@Param("function_id") String function_id);                                            //通过权限id查找权限信息

    Authority selectSonFunctionById(@Param("function_id")String function_id);                                          //通过权限id查找子权限信息

    Authority selectFaFunctionById(@Param("function_id")String function_id);                                           //通过权限id查找父权限信息

    Integer selectFatherFunctionById(@Param("function_id")String function_id);                                         //通过权限id查找父权限信息

    Boolean updateFunction(@Param("function_name")String function_name, @Param("function_address") String function_address, @Param("fatherFunction_name") String fatherFunction_name, @Param("function_id") int function_id);//更新权限信息

    boolean deleteFunction(@Param("function_id") String function_id);                                                 //通过权限id删除权限信息

    boolean deleteFunction01(String function_id);
}
