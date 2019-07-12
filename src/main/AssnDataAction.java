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

public class AssnDataAction extends ActionSupport {
    private AssnData aData;
    private List<AssnData> result = new ArrayList<>();

    public String deleteAssn() {
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        String sql = "delete from assnData where assnId=" + aData.getAssnId();
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

    public String find_Assn() {
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        String sql = "select * from assnData";
        ResultSet rs = sqlsrvdb.executeQuery(sql);
        try {
            while (rs.next()) {
                AssnData data = new AssnData();
                data.setAssnId(rs.getInt(1));
                data.setAssnName(rs.getString(2));
                data.setAssnChairman(rs.getString(3));
                data.setAssnTime(rs.getString(4));
                data.setAssnTeacher(rs.getString(5));

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

    public String updateAssn() {
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        String sql = "select * from assnData where assnId=" + aData.getAssnId();
        ResultSet rs = sqlsrvdb.executeQuery(sql);
        try {
            while (rs.next()) {
                aData.setAssnId(rs.getInt(1));
                aData.setAssnName(rs.getString(2));
                aData.setAssnChairman(rs.getString(3));
                aData.setAssnTime(rs.getString(4));
                aData.setAssnTeacher(rs.getString(5));

                result.add(aData);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlsrvdb.closeConn();
        sqlsrvdb.closeStmt();

        return SUCCESS;
    }

    public String saveAssn() throws Exception {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        RootData loginUser = (RootData) session.get("user");

        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        PreparedStatement pst = null;
        String sql = new String();
        if (null == aData.getAssnId()) {
            System.out.println("1 success");
            String time = "2018-01-02";
            sql = "insert into assnData values(?,?,?,?)";
            pst = sqlsrvdb.getConn().prepareStatement(sql);
            //pst.setInt(1, aData.getAssnId());
            pst.setString(1, aData.getAssnName());
            pst.setString(2, aData.getAssnTime());
            pst.setString(3, aData.getAssnChairman());
            pst.setString(4, aData.getAssnTeacher());
        } else {
            System.out.println("2 success");
            sql = "update assnData set assnName=?, assnChairman=?, assnTime=?, assnTeacher=? where assnId=? ";
            pst = sqlsrvdb.getConn().prepareStatement(sql);
            pst.setString(1, aData.getAssnName());
            pst.setString(2, aData.getAssnChairman());
            pst.setString(3, aData.getAssnTime());
            pst.setString(4, aData.getAssnTeacher());
            pst.setInt(5, aData.getAssnId());
        }
        pst.executeUpdate();
        pst.close();

        return SUCCESS;
    }

    public String findAssn() {
        System.out.println("���ҳɹ���");
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        String sql = "select * from assnData where assnName ='" + aData.getAssnName() + "'";
        ResultSet rs = sqlsrvdb.executeQuery(sql);
        try {
            while (rs.next()) {
                AssnData data = new AssnData();
                data.setAssnId(rs.getInt(1));
                data.setAssnName(rs.getString(2));
                data.setAssnChairman(rs.getString(3));
                data.setAssnTime(rs.getString(4));
                data.setAssnTeacher(rs.getString(5));

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

    public AssnData getaData() {
        return aData;
    }

    public void setaData(AssnData aData) {
        this.aData = aData;
    }

    public List<AssnData> getResult() {
        return result;
    }

    public void setResult(List<AssnData> result) {
        this.result = result;
    }
}
