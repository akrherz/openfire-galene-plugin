package com.rayo.core.verb;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.rayo.core.validation.Messages;

public class VerbCompleteEvent extends AbstractVerbEvent {

    public enum Reason implements VerbCompleteReason {
        STOP, ERROR, HANGUP
    }

    private String errorText;
    protected VerbCompleteReason reason;

    public VerbCompleteEvent() {}
    
    public VerbCompleteEvent(Verb verb) {
        super(verb);
    }

    public VerbCompleteEvent(VerbCompleteReason reason) {
        this.reason = reason;
    }

    public VerbCompleteEvent(Verb verb, VerbCompleteReason reason) {
        super(verb);
        this.reason = reason;
    }

    public VerbCompleteEvent(Verb verb, VerbCompleteReason reason, String errorText) {
        super(verb);
        this.reason = reason;
        this.errorText = errorText;
    }

    public VerbCompleteEvent(Verb verb, String errorText) {
        this(verb, Reason.ERROR, errorText);

    }

    public VerbCompleteReason getReason() {
        return reason;
    }

    public void setReason(VerbCompleteReason reason) {
        this.reason = reason;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public boolean isSuccess() {
        return reason != VerbCompleteEvent.Reason.ERROR;
    }

    @Override
    public String toString() {

    	return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)    		
    		.append("callId", getCallId())
    		.append("verbId", getVerbId())
    		.append("reason",reason)
    		.append("errorText",getErrorText())
    		.toString();
    }  
}
