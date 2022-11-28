package com.Mindtree.PlanMyTripServer.Service;


import com.Mindtree.PlanMyTripServer.Model.AttachmentEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public interface AttachmentService {
    public AttachmentEntity saveAttachment(MultipartFile file) throws Exception;

    public AttachmentEntity getAttachment(String fileId) throws Exception;
}
