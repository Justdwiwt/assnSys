package main;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDataAction extends ActionSupport {
    private UserData uData;
    private List<UserData> result = new ArrayList<UserData>();

    public String delete() {
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        String sql = "delete from userData where userId=" + uData.getUserId();
        Connection conn = sqlsrvdb.getConn();
        try {
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sqlsrvdb.closeConn();
        System.out.println("ɾ���ɹ���");
        return SUCCESS;
    }

    public String find() {
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        String sql = "select * from userData";
        ResultSet rs = sqlsrvdb.executeQuery(sql);
        try {
            while (rs.next()) {
                UserData data = new UserData();
                data.setUserId(rs.getInt(1));
                data.setUserName(rs.getString(2));
                data.setSex(rs.getString(3));
                data.setAssnName(rs.getString(4));
                data.setPhone(rs.getString(5));
                data.setEmail(rs.getString(6));
                data.setAddress(rs.getString(7));
                data.setJob(rs.getString(8));

                result.add(data);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlsrvdb.closeConn();
        sqlsrvdb.closeStmt();
        return SUCCESS;
    }

    public String insert() {
        return SUCCESS;
    }

    public String update() {
        System.out.println("����update�ɹ�!");
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        String sql = "select * from userData where userId=" + uData.getUserId();
        ResultSet rs = sqlsrvdb.executeQuery(sql);
        try {
            while (rs.next()) {
                uData.setUserId(rs.getInt(1));
                uData.setUserName(rs.getString(2));
                uData.setSex(rs.getString(3));
                uData.setAssnName(rs.getString(4));
                uData.setPhone(rs.getString(5));
                uData.setEmail(rs.getString(6));
                uData.setAddress(rs.getString(7));
                uData.setJob(rs.getString(8));

                result.add(uData);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlsrvdb.closeConn();
        sqlsrvdb.closeStmt();

        return SUCCESS;
    }

    public String save() throws Exception {
        System.out.println("save success!");
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        RootData loginUser = (RootData) session.get("user");

        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        PreparedStatement pst = null;
        String sql = new String();

        if (null == uData.getUserId()) {
            sql = "insert into userData values(?,?,?,?,?,?,?)";
            pst = sqlsrvdb.getConn().prepareStatement(sql);
            // pst.setInt(1, uData.getUserId());
            pst.setString(1, uData.getUserName());
            pst.setString(2, uData.getSex());
            pst.setString(3, uData.getAssnName());
            pst.setString(4, uData.getPhone());
            pst.setString(5, uData.getEmail());
            pst.setString(6, uData.getAddress());
            pst.setString(7, uData.getJob());
            System.out.println("add" + uData.getUserId());
        } else {
            sql = "update userData set userName=?, sex=?, assnName=?, phone=?, email=?, address=?, job=? where userId=? ";
            pst = sqlsrvdb.getConn().prepareStatement(sql);
            pst.setString(1, uData.getUserName());
            pst.setString(2, uData.getSex());
            pst.setString(3, uData.getAssnName());
            pst.setString(4, uData.getPhone());
            pst.setString(5, uData.getEmail());
            pst.setString(6, uData.getAddress());
            pst.setString(7, uData.getJob());
            pst.setInt(8, uData.getUserId());
            System.out.println("update" + uData.getUserId());
        }
        pst.executeUpdate();
        pst.close();

        return SUCCESS;
    }

    public String findUser() {
        System.out.println("���ҳɹ���");
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        String sql = "select * from userData where userName ='" + uData.getUserName() + "'";
        System.out.println(sql);
        ResultSet rs = sqlsrvdb.executeQuery(sql);
        try {
            while (rs.next()) {
                UserData data = new UserData();
                data.setUserId(rs.getInt(1));
                data.setUserName(rs.getString(2));
                data.setSex(rs.getString(3));
                data.setAssnName(rs.getString(4));
                data.setPhone(rs.getString(5));
                data.setEmail(rs.getString(6));
                data.setAddress(rs.getString(7));
                data.setJob(rs.getString(8));

                result.add(data);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlsrvdb.closeConn();
        sqlsrvdb.closeStmt();

        return SUCCESS;
    }

    public UserData getuData() {
        return uData;
    }

    public void setuData(UserData uData) {
        this.uData = uData;
    }

    public List<UserData> getResult() {
        return result;
    }

    public void setResult(List<UserData> result) {
        this.result = result;
    }

    public String register() {
        return SUCCESS;
    }

    public String registerOK() {
        return SUCCESS;
    }
}
