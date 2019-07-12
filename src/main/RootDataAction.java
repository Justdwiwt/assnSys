package main;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RootDataAction extends ActionSupport {
    private RootData user;

    public String login() {
        boolean validated = false;
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        RootData loginUser = null;
        loginUser = (RootData) session.get("usr");
        if (loginUser == null) {
            String sql = "select * from rootData";
            ResultSet rs = sqlsrvdb.executeQuery(sql);
            try {
                while (rs.next()) {
                    String name = rs.getString("rootName").trim();
                    String pwd = rs.getString("pwd");
                    if (name.equals(user.getRootName()) && pwd.equals(user.getPwd())) {
                        user.setRootId(rs.getInt(1));
                        session.put("user", user);
                        validated = true;
                    }
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sqlsrvdb.closeConn();
            sqlsrvdb.closeStmt();
        } else {
            validated = true;
        }
        if (validated) {
            return "success";
        } else {
            return "error";
        }

    }

    public void validate() {
        if (user.getRootName() == null || user.getRootName().trim().equals("")) {
            addFieldError("user.rootName", "��¼����Ϊ�գ�");
        }
        if (user.getPwd() == null || user.getPwd().trim().equals("")) {
            addFieldError("user.pwd", "���벻Ϊ�գ�");
        }
    }

    public String register() {
        return SUCCESS;
    }

    public String registerOK() {
        return SUCCESS;
    }

    public RootData getUser() {
        return user;
    }

    public void setUser(RootData user) {
        this.user = user;
    }
}
