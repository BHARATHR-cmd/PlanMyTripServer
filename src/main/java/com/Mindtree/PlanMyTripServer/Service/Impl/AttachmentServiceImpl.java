package com.Mindtree.PlanMyTripServer.Service.Impl;


import com.Mindtree.PlanMyTripServer.Model.AttachmentEntity;
import com.Mindtree.PlanMyTripServer.Repository.AttachmentRepository;
import com.Mindtree.PlanMyTripServer.Service.AttachmentService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public AttachmentEntity saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                        + fileName);
            }

            AttachmentEntity attachment
                    = new AttachmentEntity(fileName,
                    file.getContentType(),
                    file.getBytes());
            System.out.println(file.getContentType()+"--"+file.getBytes()+"--"+file.getOriginalFilename());
            return attachmentRepository.save(attachment);

        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Could not save File: " + fileName +e);

        }
    }

    @Override
    public AttachmentEntity getAttachment(String fileId) throws Exception {
        return attachmentRepository
                .findById(fileId)
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + fileId));
    }
}