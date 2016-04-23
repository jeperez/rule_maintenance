package com.datamelt.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.datamelt.db.DatabaseRecord;
import com.datamelt.db.Loadable;


public class ActionMethod extends DatabaseRecord implements Loadable
{
	private long actionId;
	private String returnType;
	private String methodTypes;
	private String note;
	private String optionalType1;
	private String optionalType1Explanation;
	private String optionalType2;
	private String optionalType2Explanation;
	private String optionalType3;
	private String optionalType3Explanation;
	
	private static final String TABLENAME="action_method";
	private static final String SELECT_SQL="select * from " + TABLENAME + " where id=?";
	
	public static final String INSERT_SQL = "insert into " + TABLENAME + " +(action_id, return_type, value, note, optionalType1, optionalType1_explanation, optionalType2, optionalType2_explanation, optionalType3, optionalType3_explanation) values (?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_SQL = "update " + TABLENAME + " + set check_id=?, return_type=?, value=?, note=?, optionalType1=?, optionalType1_explanation=?, optionalType2=?, optionalType2_explanation=?, optionalType3=?, optionalType3_explanation=? where id =?";
    public static final String DELETE_SQL = "delete from " + TABLENAME + " where id=?";

	
	public ActionMethod()
	{
		
	}
	
	public ActionMethod(long id)
	{
		this.setId(id);
	}
	
	
	public void load() throws Exception
	{
        ResultSet rs = selectRecordById(getConnection().getPreparedStatement(SELECT_SQL));
		if(rs.next())
		{
	        this.actionId = rs.getLong("action_id");
			this.returnType = rs.getString("return_type");
	        this.methodTypes = rs.getString("method_types");
	        this.note = rs.getString("note");
	        this.optionalType1 = rs.getString("optional_type1");
	        this.optionalType1Explanation = rs.getString("optional_type1_explanation");
	        this.optionalType2 = rs.getString("optional_type2");
	        this.optionalType2Explanation = rs.getString("optional_type2_explanation");
	        this.optionalType3 = rs.getString("optional_type3");
	        this.optionalType3Explanation = rs.getString("optional_type3_explanation");
	        
	        setLastUpdate(rs.getString("last_update"));
	        
		}
        rs.close();
	}
	
	private ResultSet selectRecordById(PreparedStatement p) throws Exception
	{
		p.setLong(1,getId());
		return p.executeQuery();
	}

	public void update(PreparedStatement p) throws Exception
	{
		p.setLong(1,actionId);
		p.setString(2,returnType);
		p.setString(3,methodTypes);
		p.setString(4,note);
		p.setString(5,optionalType1);
		p.setString(6,optionalType1Explanation);
		p.setString(7,optionalType2);
		p.setString(8,optionalType2Explanation);
		p.setString(9,optionalType3);
		p.setString(10,optionalType3Explanation);
		
		p.setLong(11,getId());

		try
		{
			p.executeUpdate();
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void insert(PreparedStatement p) throws Exception
    {
		p.setLong(1,actionId);
		p.setString(2,returnType);
		p.setString(3,methodTypes);
		p.setString(4,note);
		p.setString(5,optionalType1);
		p.setString(6,optionalType1Explanation);
		p.setString(7,optionalType2);
		p.setString(8,optionalType2Explanation);
		p.setString(9,optionalType3);
		p.setString(10,optionalType3Explanation);
		
        p.execute();
        
        setId(getConnection().getLastInsertId());
    }
	
	public void delete(PreparedStatement p) throws Exception
	{
		p.setLong(1,getId());
		try
		{
			p.executeUpdate();
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public long getActionId() 
	{
		return actionId;
	}

	public void setActionId(long actionId) 
	{
		this.actionId = actionId;
	}

	public String getReturnType() 
	{
		return returnType;
	}

	public void setReturnType(String returnType) 
	{
		this.returnType = returnType;
	}

	public String getMethodTypes() 
	{
		return methodTypes;
	}

	public void setMethodTypes(String methodTypes) 
	{
		this.methodTypes = methodTypes;
	}

	public String getNote() 
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public String getOptionalType1()
	{
		return optionalType1;
	}

	public void setOptionalType1(String optionalType1) 
	{
		this.optionalType1 = optionalType1;
	}

	public String getOptionalType1Explanation() 
	{
		return optionalType1Explanation;
	}

	public void setOptionalType1Explanation(String optionalType1Explanation) 
	{
		this.optionalType1Explanation = optionalType1Explanation;
	}
	
	public String getOptionalType2()
	{
		return optionalType2;
	}

	public void setOptionalType2(String optionalType2) 
	{
		this.optionalType2 = optionalType2;
	}

	public String getOptionalType2Explanation() 
	{
		return optionalType2Explanation;
	}

	public void setOptionalType2Explanation(String optionalType2Explanation) 
	{
		this.optionalType2Explanation = optionalType2Explanation;
	}
	
	public String getOptionalType3()
	{
		return optionalType3;
	}

	public void setOptionalType3(String optionalType3) 
	{
		this.optionalType3 = optionalType3;
	}

	public String getOptionalType3Explanation() 
	{
		return optionalType3Explanation;
	}

	public void setOptionalType3Explanation(String optionalType3Explanation) 
	{
		this.optionalType3Explanation = optionalType3Explanation;
	}


}
