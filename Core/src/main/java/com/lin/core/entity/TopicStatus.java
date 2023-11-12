package com.lin.core.entity;

import java.io.Serializable;
import java.util.Objects;

public class TopicStatus implements Serializable {
    private String cdcTopic;
    private Boolean cdcStatus;
    private String yxTopic;
    private Long startOffset;

    public TopicStatus(String cdcTopic, Boolean cdcStatus, String yxTopic, Long startOffset) {
        this.cdcTopic = cdcTopic;
        this.cdcStatus = cdcStatus;
        this.yxTopic = yxTopic;
        this.startOffset = startOffset;
    }

    public String getCdcTopic() {
        return cdcTopic;
    }

    public void setCdcTopic(String cdcTopic) {
        this.cdcTopic = cdcTopic;
    }

    public Boolean getCdcStatus() {
        return cdcStatus;
    }

    public void setCdcStatus(Boolean cdcStatus) {
        this.cdcStatus = cdcStatus;
    }

    public String getYxTopic() {
        return yxTopic;
    }

    public void setYxTopic(String yxTopic) {
        this.yxTopic = yxTopic;
    }

    public Long getStartOffset() {
        return startOffset;
    }

    public void setStartOffset(Long startOffset) {
        this.startOffset = startOffset;
    }

    public TopicStatus(String cdcTopic, String yxTopic, Long startOffset) {
        this.cdcTopic = cdcTopic;
        this.yxTopic = yxTopic;
        this.startOffset = startOffset;
    }

    public TopicStatus() {
    }


    @Override
    public String toString() {
        return "{" +
                "\"cdcTopic\":\"" + cdcTopic + "\"" +
                ",\"cdcStatus\":\"" + cdcStatus + '\"' +
                ",\"yxTopic\":\"" + yxTopic + '\"' +
                ",\"startOffset\":\"" + startOffset + '\"' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicStatus that = (TopicStatus) o;
        return Objects.equals(cdcTopic, that.cdcTopic);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cdcTopic, cdcStatus, yxTopic, startOffset);
    }
}
