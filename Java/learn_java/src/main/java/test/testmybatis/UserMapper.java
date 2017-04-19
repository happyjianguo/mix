package test.testmybatis;

import java.util.List;

/**
 * Created by joshua on 17/4/18.
 */
public interface UserMapper {

    UserModel selectUserByID(int id);

    List<UserModel> selectUsers(String userName);

    void addUser(UserModel user);

    void updateUser(UserModel user);

    void deleteUser(int id);

    List<Article> getUserArticles(int userid);
}
