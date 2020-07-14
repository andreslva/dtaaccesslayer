package itr.model;

import java.io.Serializable;

import itr.utils.ITRUtils;

public class ClasePeriodoPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int claseId;
    int perClasePerId;

	public ClasePeriodoPK() {
	}

	public ClasePeriodoPK(int claseId, int perClasePerId) {
		super();
		this.claseId = claseId;
		this.perClasePerId = perClasePerId;
	}

	public int getClaseId() {
		return claseId;
	}

	public void setClaseId(int claseId) {
		this.claseId = claseId;
	}

	public int getPerClasePerId() {
		return perClasePerId;
	}

	public void setPerClasePerId(int perClasePerId) {
		this.perClasePerId = perClasePerId;
	}
	
	@Override
    public int hashCode() {
    	String clsStr = ITRUtils.rightPad(Integer.toString(this.claseId), 4, "0");
    	String perStr = ITRUtils.rightPad(Integer.toString(this.perClasePerId), 2, "0");
    	StringBuffer hcStr = new StringBuffer(clsStr);
    	hcStr.append(perStr);
    	
    	int hc = 0;
    	try
    	{
    		hc = Integer.parseUnsignedInt(hcStr.toString());
    	}
    	catch(NumberFormatException e)
    	{
    		hc = -1;
    	}
    	
        return hc;
    }

    public boolean equals(Object obj) {
    	if (obj == null){return false;}
    	if (obj == this) {return true;}
    	if (!(obj instanceof ClasePeriodoPK)) {return false;}
    	ClasePeriodoPK pk = (ClasePeriodoPK) obj;
    	return (pk.claseId == claseId) && (pk.perClasePerId == perClasePerId);
    }
}
