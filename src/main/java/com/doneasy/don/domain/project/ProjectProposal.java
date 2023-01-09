package com.doneasy.don.domain.project;

import com.doneasy.don.dto.BoardSaveDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor

public class ProjectProposal {


    private Long id;
    private Target category;
    private LocalDate deadline;
    private LocalDate service_start_date;
    private LocalDate service_end_date;
    private String title;
    private Integer target_price;
    private ProjectProposalStatus status;
    private LocalDateTime create_date;
    private Long organization_id;



    public static ProjectProposal getInstance(BoardSaveDto boardSaveDto){
        String category = boardSaveDto.getCategory();
        Target a;
        if (category.equals("seniorcitizen")) a = Target.ELDER_PEOPLE;
        else if (category.equals("children")) a= Target.CHILDREN;
        else if (category.equals("youth"))  a=Target.TEENAGER;
        else if (category.equals("environment")) a=Target.ENVIRONMENT;
        else if (category.equals("disabled")) a=Target.THE_DISABLED;
        else a=Target.SOCIETY;

        String deadline1 = boardSaveDto.getDeadline();
        int year = Integer.parseInt(deadline1.substring(0, 4));
        int month = Integer.parseInt(deadline1.substring(5, 7));
        int day = Integer.parseInt(deadline1.substring(8));
        LocalDate date = LocalDate.of(year, month, day);

        String start = boardSaveDto.getService_start_date();
        int year1 = Integer.parseInt(start.substring(0, 4));
        int month1 = Integer.parseInt(start.substring(5, 7));
        int day1 = Integer.parseInt(start.substring(8));
        LocalDate date1 = LocalDate.of(year1, month1, day1);

        String end = boardSaveDto.getService_end_date();
        int year2 = Integer.parseInt(end.substring(0, 4));
        int month2 = Integer.parseInt(end.substring(5, 7));
        int day2 = Integer.parseInt(end.substring(8));
        LocalDate date2 = LocalDate.of(year2, month2, day2);

        return new ProjectProposal(null,a,date,date1,date2, boardSaveDto.getTitle(), boardSaveDto.getTarget_price(),ProjectProposalStatus.WAIT,LocalDateTime.now(),1l);



    }


}
/**
 *  dto 는 리액트에서 오는 정보들만 받아오는것이고
 *  그 dto 를 도메인화(도메인만 디비에 저장된다) 시켜서 데이터베이스에 저장해야한다.
 *  그래서 위에 스테틱 메소드가 있는것이다.
 */