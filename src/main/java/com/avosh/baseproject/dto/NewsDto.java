/*******************************************************************************
 * Created by Alireza Amirkhani 2022
 ******************************************************************************/

package com.avosh.baseproject.dto;

import java.util.Date;

public class NewsDto extends BaseDto {

    private String title;
    private String brief;
    private String news;
    private Date createDateTime;
    private UserDto user;
    private boolean hasSchedulerTile;

    public NewsDto() {
    }

    public NewsDto(Long id, String brief, String news, String title, Date createDateTime, UserDto user) {
        this.id = id;
        this.brief = brief;
        this.news = news;
        this.title = title;
        this.createDateTime = createDateTime;
        this.user = user;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public boolean isHasSchedulerTile() {
        return hasSchedulerTile;
    }

    public void setHasSchedulerTile(boolean hasSchedulerTile) {
        this.hasSchedulerTile = hasSchedulerTile;
    }
}
