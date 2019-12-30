package com.authentication;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;

public class TokenInfo {
    private ObjectId userId;
    private DateTime issued;
    private DateTime expires;
    
    public ObjectId getUserId() {
        return userId;
    }
    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }
    public DateTime getIssued() {
        return issued;
    }
   
	public void setIssued(DateTime issued) {
        this.issued = issued;
    }
    public DateTime getExpires() {
        return expires;
    }
    public void setExpires(DateTime expires) {
        this.expires = expires;
    }
    
    @Override
   	public String toString() {
   		return "TokenInfo [userId=" + userId + ", issued=" + issued + ", expires=" + expires + "]";
   	}
}