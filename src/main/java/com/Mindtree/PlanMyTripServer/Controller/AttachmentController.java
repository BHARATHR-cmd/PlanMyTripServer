package com.Mindtree.PlanMyTripServer.Controller;
import com.Mindtree.PlanMyTripServer.Model.AttachmentEntity;
import com.Mindtree.PlanMyTripServer.Model.AttachmentResponseData;
import com.Mindtree.PlanMyTripServer.Service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.awt.*;

@RestController
@RequestMapping("/upload")
@CrossOrigin("*")
public class AttachmentController {

        @Autowired
        private AttachmentService attachmentService;


        @PostMapping("/")
        public AttachmentResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
            AttachmentEntity attachment = null;
            String downloadURl = "";
            attachment = attachmentService.saveAttachment(file);
            downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(attachment.getId())
                    .toUriString();

            return new AttachmentResponseData(attachment.getFileName(),
                    downloadURl,
                    file.getContentType(),
                    file.getSize());
        }

        @GetMapping("/{fileId}")
        public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
            AttachmentEntity attachment = null;
            attachment = attachmentService.getAttachment(fileId);
            return  ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(attachment.getFileType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + attachment.getFileName()
                                    + "\"")
                    .body(new ByteArrayResource(attachment.getData()));
        }

}
