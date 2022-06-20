package com.spring5.practice.dao;

import com.spring5.practice.entity.Attachment;

import java.util.List;

public interface AttachmentDAO {

    public void insertBulk(List<Attachment> attachments);
}
