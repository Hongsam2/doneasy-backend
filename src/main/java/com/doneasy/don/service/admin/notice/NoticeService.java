package com.doneasy.don.service.admin.notice;

import com.doneasy.don.domain.admin.notice.ContentsOfNotice;
import com.doneasy.don.domain.admin.notice.Notice;
import com.doneasy.don.dto.admin.notice.NoticeContentDto;
import com.doneasy.don.dto.admin.notice.NoticeSaveDto;
import com.doneasy.don.repository.admin.notice.IContentOfNoticeRepository;
import com.doneasy.don.repository.admin.notice.INoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final INoticeRepository noticeRepository;
    private final IContentOfNoticeRepository contentOfNoticeRepository;

    @Value("${admin.image.dir}")
    private String path;

    public List<Notice> getNoticeAsList() {
        return noticeRepository.findAll();
    }

    public void save(NoticeSaveDto noticeSaveDto, List<MultipartFile> multipartFileList) throws IOException {
        Notice notice = Notice.getNotice(noticeSaveDto);
        List<NoticeContentDto> contextList = noticeSaveDto.getContextList();
        noticeRepository.save(notice);

        Notice recent = noticeRepository.findRecent();
        Long id = recent.getId();

        for (int i = 0; i < multipartFileList.size(); i++) {

            MultipartFile multipartFile = multipartFileList.get(i);

            String imageName = multipartFile.getOriginalFilename();
            ContentsOfNotice contentsOfNotice = ContentsOfNotice.getContentsOfNotice(contextList.get(i), i + 1, imageName, id);

            contentOfNoticeRepository.save(contentsOfNotice);


            multipartFile.transferTo(new File(path + imageName));
        }
    }
}
